package kaluska.michal.Witcher_Bestiary.alchemy.models;

import jakarta.persistence.*;
import kaluska.michal.Witcher_Bestiary.Ingredient;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AlchemyItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private List<Ingredient> ingredients;
    private int requiredLevelToCraft;
    private int costOfCrafting;
    private int itemLevel;
    private String description;
}
