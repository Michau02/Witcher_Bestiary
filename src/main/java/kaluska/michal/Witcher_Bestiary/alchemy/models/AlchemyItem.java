package kaluska.michal.Witcher_Bestiary.alchemy.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AlchemyItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private int costOfCrafting;
    private int itemLevel;

    @OneToMany(mappedBy = "alchemyItem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AlchemyIngredient> ingredients;

    public void setIngredients(List<AlchemyIngredient> ingredients) {
        this.ingredients = ingredients;
        if (ingredients != null) {
            ingredients.forEach(i -> i.setAlchemyItem(this));
        }
    }
}
