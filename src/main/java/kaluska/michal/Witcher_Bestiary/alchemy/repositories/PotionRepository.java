package kaluska.michal.Witcher_Bestiary.alchemy.repositories;

import kaluska.michal.Witcher_Bestiary.alchemy.models.PotionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PotionRepository extends JpaRepository<PotionItem, Long> {
    PotionItem findByName(String name);
}
