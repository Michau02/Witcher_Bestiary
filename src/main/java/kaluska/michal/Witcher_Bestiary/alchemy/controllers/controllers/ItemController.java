package kaluska.michal.Witcher_Bestiary.alchemy.controllers.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alchemy/*")
@RequiredArgsConstructor
public class ItemController {

    @GetMapping
    public String getAllItems() {
        return "pages/all-items";
    }
}
