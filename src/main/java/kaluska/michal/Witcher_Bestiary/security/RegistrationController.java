package kaluska.michal.Witcher_Bestiary.security;

import kaluska.michal.Witcher_Bestiary.user.Role;
import kaluska.michal.Witcher_Bestiary.user.User;
import kaluska.michal.Witcher_Bestiary.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RegistrationController {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "security/registration";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password,
                               @RequestParam String confirmPassword, Model model) {

        if (username.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
            model.addAttribute("error", "All fields (username, password, confirmed password) should be filled for successful registration.");
            return "security/registration";
        }
        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match.");
            return "security/registration";
        }
        if (userRepository.findByUsername(username).isPresent()) {
            model.addAttribute("error", "User already exists. Try with another username!");
            return "security/registration";
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(username.concat("@gmail.com"));
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles(List.of(Role.USER));
        userRepository.save(user);

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "redirect:/home";
    }

}
