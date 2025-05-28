package kaluska.michal.Witcher_Bestiary.alchemy.services;

import kaluska.michal.Witcher_Bestiary.alchemy.models.PotionItem;
import kaluska.michal.Witcher_Bestiary.alchemy.repositories.PotionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PotionService extends BaseAlchemyService<PotionItem> {
    private final PotionRepository potionRepository;

    public PotionService(PotionRepository potionRepository) {
        super(potionRepository);
        this.potionRepository = potionRepository;
    }

    @Override
    public List<PotionItem> findAll() {
        return List.of(new PotionItem(20, 20, 20)
                , new PotionItem(30, 30, 30),
                new PotionItem(40, 40, 40));
    }

    public PotionItem findByName(String name) {
        return potionRepository.findByName(name);
    }
}