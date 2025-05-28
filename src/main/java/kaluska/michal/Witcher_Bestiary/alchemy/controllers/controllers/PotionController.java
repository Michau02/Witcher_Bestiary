package kaluska.michal.Witcher_Bestiary.alchemy.controllers.controllers;

import kaluska.michal.Witcher_Bestiary.alchemy.services.PotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/potions")
@RequiredArgsConstructor
public class PotionController {

    private final PotionService potionService;

    @GetMapping()
    public String getAllPotions(Model model) {
        model.addAttribute("potions", potionService.findAll());
        return "potions";
    }

}
