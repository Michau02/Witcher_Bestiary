package kaluska.michal.Witcher_Bestiary.alchemy.controllers.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alchemy/bombs")
@RequiredArgsConstructor
public class BombController {

    @GetMapping("/{id}")
    public String getBombById(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("type", "bombs");
        return "pages/single-item";
    }
}
