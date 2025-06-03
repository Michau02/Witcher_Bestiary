package kaluska.michal.Witcher_Bestiary.alchemy;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlchemyController {
    @GetMapping("/alchemy")
    public String potions(Model model) {
        return "alchemy";
    }
}
