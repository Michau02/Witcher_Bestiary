package kaluska.michal.Witcher_Bestiary;

import jakarta.persistence.Embeddable;

@Embeddable
public class Ingredient {

    // fast impl just so it exists
    private Long id;
    private String name;
    private double weight;
    private double price;
    private int quantity;
}
