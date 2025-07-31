package kaluska.michal.Witcher_Bestiary.ingredients.services;

import kaluska.michal.Witcher_Bestiary.ingredients.models.Ingredient;
import kaluska.michal.Witcher_Bestiary.ingredients.repositories.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    public Ingredient findById(Long id) {
        return ingredientRepository.findById(id).orElse(null);
    }

    public Ingredient save(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public List<Ingredient> saveAll(List<Ingredient> ingredients) {
        return ingredientRepository.saveAll(ingredients);
    }

    public Ingredient update(Long id, Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public void deleteById(Long id) {
        ingredientRepository.deleteById(id);
    }
}
