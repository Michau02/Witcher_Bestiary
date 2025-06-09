package kaluska.michal.Witcher_Bestiary.alchemy.controllers.restControllers;

import kaluska.michal.Witcher_Bestiary.alchemy.models.BombItem;
import kaluska.michal.Witcher_Bestiary.alchemy.services.BombService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bombs")
public class BombRestController extends BaseAlchemyRestController<BombItem> {
    private final BombService bombService;

    public BombRestController(BombService bombService) {
        super(bombService);
        this.bombService = bombService;
    }

    @GetMapping("name/{name}")
    public BombItem getByName(@PathVariable("name") String name) {
        return bombService.findByName(name);
    }
}
