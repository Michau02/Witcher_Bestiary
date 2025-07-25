package kaluska.michal.Witcher_Bestiary.navigation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {

    @GetMapping("/home")
    public String showHomePage() {
        return "home";
    }

    @GetMapping("/alchemy")
    public String showAlchemyPage() {
        return "alchemy";
    }
}
