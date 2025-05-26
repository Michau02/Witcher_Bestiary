package kaluska.michal.Witcher_Bestiary.ingredients.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum IngredientType {
    ALCHEMY, CRAFT;

    @JsonCreator
    public static IngredientType fromString(String string) {
        try {
            return IngredientType.valueOf(string.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @JsonValue
    public String toJson() {
        return name().toLowerCase();
    }
}
