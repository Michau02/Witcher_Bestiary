package kaluska.michal.Witcher_Bestiary.security;

import kaluska.michal.Witcher_Bestiary.user.Role;
import kaluska.michal.Witcher_Bestiary.user.User;
import kaluska.michal.Witcher_Bestiary.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.SavedRequest;

import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j
public class SecurityConfig {

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
                            logout.permitAll();
                        })
                );

        return http.build();
    }

    @Bean
    public CommandLineRunner init(UserRepository repo) {
        String newUserName = "a";
        return args -> {
            if (repo.findByUsername(newUserName).isEmpty()) {
                var user = new User();
                user.setUsername(newUserName);
                user.setEmail(newUserName.concat("@example.com"));
                user.setPassword(newUserName);
                user.setRoles(List.of(Role.USER));
                repo.save(user);
            }
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
