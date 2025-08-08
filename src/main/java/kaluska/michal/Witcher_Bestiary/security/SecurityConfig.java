package kaluska.michal.Witcher_Bestiary.security;

import kaluska.michal.Witcher_Bestiary.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.SavedRequest;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j
public class SecurityConfig {

    private final UserService userService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/favorites").authenticated()
                        .anyRequest().permitAll()
                )
                .formLogin(
                        form -> form
                                .loginProcessingUrl("/login")
                                .successHandler((request, response, authentication) -> {
                                    var saved = request.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST");

                                    if (saved instanceof SavedRequest savedRequest) {
                                        response.sendRedirect(savedRequest.getRedirectUrl());
                                    } else {
                                        String referer = request.getHeader("Referer");
                                        response.sendRedirect(referer != null ? referer : "/home");
                                    }
                                })
                                .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessHandler((request, response, authentication) -> {
                            log.info("User '{}' logged out", authentication.getName());
                            response.sendRedirect("/home");
                        })
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userService)
                .passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
