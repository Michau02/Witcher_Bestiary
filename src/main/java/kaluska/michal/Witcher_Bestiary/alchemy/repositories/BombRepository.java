package kaluska.michal.Witcher_Bestiary.alchemy.repositories;

import kaluska.michal.Witcher_Bestiary.alchemy.models.BombItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BombRepository extends JpaRepository<BombItem, Long> {
}
