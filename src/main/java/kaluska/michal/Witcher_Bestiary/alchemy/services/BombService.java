package kaluska.michal.Witcher_Bestiary.alchemy.services;

import kaluska.michal.Witcher_Bestiary.alchemy.models.BombItem;
import kaluska.michal.Witcher_Bestiary.alchemy.repositories.BombRepository;
import org.springframework.stereotype.Service;

@Service
public class BombService extends BaseAlchemyService<BombItem> {
    public BombService(BombRepository bombRepository) {
        super(bombRepository);
    }
}
