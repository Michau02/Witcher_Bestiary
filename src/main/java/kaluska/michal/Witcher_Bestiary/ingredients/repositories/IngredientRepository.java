package kaluska.michal.Witcher_Bestiary.ingredients.repositories;

import kaluska.michal.Witcher_Bestiary.ingredients.models.Ingredient;
import kaluska.michal.Witcher_Bestiary.ingredients.models.IngredientType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findAllByType(IngredientType type);
}
