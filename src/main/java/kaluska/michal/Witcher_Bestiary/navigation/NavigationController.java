package kaluska.michal.Witcher_Bestiary.navigation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {

    private static final String homePath = "pages/home";
    private static final String alchemyPath = "pages/alchemy";

    @GetMapping("/home")
    public String showHomePage() {
        return homePath;
    }

    @GetMapping("/alchemy")
    public String showAlchemyPage() {
        return alchemyPath;
    }
}
