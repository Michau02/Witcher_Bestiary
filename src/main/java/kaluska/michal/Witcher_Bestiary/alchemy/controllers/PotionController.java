package kaluska.michal.Witcher_Bestiary.alchemy.controllers;

import kaluska.michal.Witcher_Bestiary.alchemy.models.PotionItem;
import kaluska.michal.Witcher_Bestiary.alchemy.services.PotionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/potions")
public class PotionController extends BaseAlchemyController<PotionItem> {
    public PotionController(PotionService potionService) {
        super(potionService);
    }
}
