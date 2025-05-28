package kaluska.michal.Witcher_Bestiary.alchemy.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PotionItem extends AlchemyItem {
    private int durationTimeInSeconds;
    private int toxicity;
    private int charges;

    public PotionItem(int durationTimeInSeconds, int toxicity, int charges) {
        this.durationTimeInSeconds = durationTimeInSeconds;
        this.toxicity = toxicity;
        this.charges = charges;
    }
}
