package kaluska.michal.Witcher_Bestiary.ingredients.controllers;

import kaluska.michal.Witcher_Bestiary.ingredients.models.Ingredient;
import kaluska.michal.Witcher_Bestiary.ingredients.models.IngredientType;
import kaluska.michal.Witcher_Bestiary.ingredients.services.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
@RequiredArgsConstructor
public class IngredientController {
    private final IngredientService ingredientService;

    @GetMapping
    public List<Ingredient> getAllIngredients() {
        return ingredientService.findAll();
    }

    @GetMapping("/{type}")
    public List<Ingredient> getIngredientsByType(@PathVariable String type) {
        return ingredientService.findAllByType(IngredientType.valueOf(type));
    }

    @GetMapping("/{id}")
    public Ingredient getIngredientById(@PathVariable Long id) {
        return ingredientService.findById(id);
    }

    @PostMapping
    public Ingredient addIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.save(ingredient);
    }

    @PostMapping("/multiple")
    public List<Ingredient> addIngredients(@RequestBody List<Ingredient> ingredients) {
        return ingredientService.saveAll(ingredients);
    }

    @PutMapping("/{id}")
    public Ingredient updateIngredient(@PathVariable("id") Long id, @RequestBody Ingredient ingredient) {
        return ingredientService.update(id, ingredient);
    }

    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable Long id) {
        ingredientService.deleteById(id);
    }
}
