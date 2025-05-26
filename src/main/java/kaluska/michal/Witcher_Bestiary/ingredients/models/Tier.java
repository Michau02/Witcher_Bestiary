package kaluska.michal.Witcher_Bestiary.ingredients.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Tier {
    COMMON, MAGIC, MASTER, RELIC;

    @JsonCreator
    public static Tier fromString(String string) {
        try {
            return Tier.valueOf(string.toUpperCase());
        } catch (Exception e) {
            return null;
        }
    }

    @JsonValue
    public String toJson() {
        return name().toLowerCase();
    }
}
