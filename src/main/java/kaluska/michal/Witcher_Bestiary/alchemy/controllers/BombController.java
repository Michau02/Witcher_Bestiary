package kaluska.michal.Witcher_Bestiary.alchemy.controllers;

import kaluska.michal.Witcher_Bestiary.alchemy.models.BombItem;
import kaluska.michal.Witcher_Bestiary.alchemy.services.BombService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bombs")
public class BombController extends BaseAlchemyController<BombItem> {
    public BombController(BombService bombService) {
        super(bombService);
    }
}
