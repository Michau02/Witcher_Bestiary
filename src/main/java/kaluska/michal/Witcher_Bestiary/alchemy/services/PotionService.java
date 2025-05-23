package kaluska.michal.Witcher_Bestiary.alchemy.services;

import kaluska.michal.Witcher_Bestiary.alchemy.models.PotionItem;
import kaluska.michal.Witcher_Bestiary.alchemy.repositories.PotionRepository;
import org.springframework.stereotype.Service;

@Service
public class PotionService extends BaseAlchemyService<PotionItem> {
    public PotionService(PotionRepository potionRepository) {
        super(potionRepository);
    }
}