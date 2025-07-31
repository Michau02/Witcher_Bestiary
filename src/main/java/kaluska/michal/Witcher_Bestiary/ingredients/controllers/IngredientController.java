package kaluska.michal.Witcher_Bestiary.ingredients.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ingredients")
@RequiredArgsConstructor
public class IngredientController {

    @GetMapping("/{id}")
    public String getIngredientById(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("type", "ingredients");
        return "pages/single-item";
    }
}
