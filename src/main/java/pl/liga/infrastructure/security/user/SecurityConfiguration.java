package pl.liga.infrastructure.security.user;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@EnableConfigurationProperties({WebConfigProperties.class})
public class SecurityConfiguration {

    private final WebConfigProperties webConfigProperties;

    private static final String[] AUTH_WHITELIST = {
            // -- Swagger UI v2
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            // -- Swagger UI v3 (OpenAPI)
            "/v3/api-docs/**",
            "/swagger-ui/**"
            // other public endpoints of your API may be appended to this array
    };

    public SecurityConfiguration(WebConfigProperties webConfigProperties) {
        this.webConfigProperties = webConfigProperties;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authManager(
            HttpSecurity http,
            PasswordEncoder passwordEncoder,
            UserDetailsService userDetailService
    )
            throws Exception {
        AuthenticationManagerBuilder builder = http.getSharedObject(AuthenticationManagerBuilder.class);
        builder.userDetailsService(userDetailService).passwordEncoder(passwordEncoder);

        return builder.build();
    }

    @Bean
    @ConditionalOnProperty(value = "spring.security.enabled", havingValue = "true", matchIfMissing = true)
    SecurityFilterChain securityEnabled(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        request ->
                            request.requestMatchers(AUTH_WHITELIST).permitAll()
                                .requestMatchers("/login", "/error", "/images/error.jpg","/api/**").permitAll()
                                .requestMatchers(
                                        "/",
                                        "/images/**",
                                        "/styles/**",
                                        "/achievement/**",
                                        "/match/**",
                                        "/tournament").hasAnyAuthority("user", "admin")
                                .requestMatchers(HttpMethod.GET,"/player/**",
                                                                                "/season",
                                                                                "/season/details/**",
                                                                                "/tournament/active",
                                                                                "/tournament/details").hasAnyAuthority("user","admin")


                                .requestMatchers(HttpMethod.POST, "/player", "/season").hasAnyAuthority("admin")
                                .requestMatchers(HttpMethod.DELETE, "/season/details/**",
                                                                                    "/tournament/details/**").hasAnyAuthority("admin")
                                .requestMatchers(HttpMethod.PATCH,"/tournament/start").hasAnyAuthority("admin")
                                .requestMatchers(
                                        "/admin_panel",
                                        "/user/**").hasAnyAuthority("admin")
                )
                .formLogin(Customizer.withDefaults())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .logoutSuccessUrl("/login")
                );

        return http.build();
    }

    @Bean
    @ConditionalOnProperty(value = "spring.security.enabled", havingValue = "false")
    SecurityFilterChain securityDisabled(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request
                        .anyRequest().permitAll()
                );

        return http.build();
    }

    @Bean
    public WebMvcConfigurer corsMappingConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                WebConfigProperties.Cors cors = webConfigProperties.getCors();
                registry.addMapping("/**")
                        .allowedOrigins(cors.getAllowedOrigins())
                        .allowedMethods(cors.getAllowedMethods())
                        .maxAge(cors.getMaxAge())
                        .allowedHeaders(cors.getAllowedHeaders())
                        .exposedHeaders(cors.getExposedHeaders());
            }
        };
    }
}
