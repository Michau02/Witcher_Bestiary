package kaluska.michal.Witcher_Bestiary.alchemy.controllers;

import kaluska.michal.Witcher_Bestiary.alchemy.models.PotionItem;
import kaluska.michal.Witcher_Bestiary.alchemy.services.PotionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/potions")
public class PotionController extends BaseAlchemyController<PotionItem> {
    private final PotionService potionService;

    public PotionController(PotionService potionService) {
        super(potionService);
        this.potionService = potionService;
    }

    @GetMapping("name/{name}")
    public PotionItem getByName(@PathVariable("name") String name) {
        return potionService.findByName(name);
    }
}
