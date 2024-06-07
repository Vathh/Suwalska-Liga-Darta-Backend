package pl.liga.infrastructure.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;
import static pl.liga.infrastructure.security.user.Permission.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

    private static final String[] GET_WHITE_LIST_URL = {
            "/match",
            "/player",
            "/season",
            "/season/details",
            "/tournament",
            "/tournament/active",
            "/tournament/details"
    };

    private static final String[] POST_WHITE_LIST_URL = {
            "/authorization/authenticate"
    };

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authProvider;
    private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(httpSecurityCorsConfigurer ->
                        httpSecurityCorsConfigurer.configurationSource(configurationSource()))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                        req.requestMatchers(GET, GET_WHITE_LIST_URL)
                            .permitAll()
                            .requestMatchers(POST, POST_WHITE_LIST_URL)
                            .permitAll()

                            .requestMatchers(GET,
                                    "/match/active").hasAnyAuthority(USER_READ.getPermission())
                            .requestMatchers(POST,
                                    "/achievement",
                                            "/authorization/refresh").hasAnyAuthority(USER_CREATE.getPermission())
                            .requestMatchers(PATCH,
                                    "/match/details").hasAnyAuthority(USER_UPDATE.getPermission())
                            .requestMatchers(DELETE,
                                    "").hasAnyAuthority(USER_DELETE.getPermission())

                            .requestMatchers(GET,
                                    "").hasAnyAuthority(ADMIN_READ.getPermission())
                            .requestMatchers(POST,
                                    "/player",
                                            "/season"
                            ).hasAnyAuthority(ADMIN_CREATE.getPermission())
                            .requestMatchers(PATCH,
                                    "/tournament/start").hasAnyAuthority(ADMIN_UPDATE.getPermission())
                            .requestMatchers(DELETE,
                                    "/season/details",
                                    "/tournament/details").hasAnyAuthority(ADMIN_DELETE.getPermission())
                            .anyRequest()
                            .authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(logout ->
                        logout.logoutUrl("/logout")
                                .addLogoutHandler(logoutHandler)
                                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
                )
        ;

        return http.build();
    }

    @Bean
    CorsConfigurationSource configurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.applyPermitDefaultValues();
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "PATCH"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


}
