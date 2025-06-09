package kaluska.michal.Witcher_Bestiary.alchemy.controllers.controllers;

import kaluska.michal.Witcher_Bestiary.alchemy.services.BombService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/bombs")
@RequiredArgsConstructor
public class BombController {
    private final BombService bombService;

    @GetMapping
    public String getAllBombs(Model model) {
        model.addAttribute("bombs", bombService.findAll());
        return "all_bombs";
    }
    
    @GetMapping("/{id}")
    public String getSingleBomb(@PathVariable("id") Long id, Model model) {
        model.addAttribute("bomb", bombService.findById(id));
        return "single_bomb";
    }
}
