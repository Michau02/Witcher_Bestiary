package kaluska.michal.Witcher_Bestiary.alchemy.controllers.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alchemy/potions")
@RequiredArgsConstructor
public class PotionController {

    @GetMapping("/{id}")
    public String getPotionById(Model model, @PathVariable Long id) {
        model.addAttribute("id", id);
        model.addAttribute("type", "potions");
        return "pages/single-item";
    }
}