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

import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;
import static pl.liga.infrastructure.security.user.Permission.*;
import static pl.liga.infrastructure.security.user.Role.ADMIN;
import static pl.liga.infrastructure.security.user.Role.USER;

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
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                        req.requestMatchers(GET, GET_WHITE_LIST_URL)
                            .permitAll()
                            .requestMatchers(POST, POST_WHITE_LIST_URL)
                            .permitAll()

                            .requestMatchers(GET,
                                    "/match/active").hasAnyAuthority(USER_READ.name())
                            .requestMatchers(POST,
                                    "/achievement",
                                            "/authorization/refresh").hasAnyAuthority(USER_CREATE.name())
                            .requestMatchers(PATCH,
                                    "/match/details").hasAnyAuthority(USER_UPDATE.name())
                            .requestMatchers(DELETE,
                                    "").hasAnyAuthority(USER_DELETE.name())

                            .requestMatchers(GET,
                                    "").hasAnyAuthority(ADMIN_READ.name())
                            .requestMatchers(POST,
                                    "/player",
                                            "/season"
//                                    ,
//                                            "/authorization/register"
                            ).hasAnyAuthority(ADMIN_CREATE.name())
                            .requestMatchers(PATCH,
                                    "/tournament/start").hasAnyAuthority(ADMIN_UPDATE.name())
                            .requestMatchers(DELETE,
                                    "/season/details",
                                    "/tournament/details").hasAnyAuthority(ADMIN_DELETE.name())
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
}
