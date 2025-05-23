package kaluska.michal.Witcher_Bestiary.alchemy.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class PotionItem extends AlchemyItem {
    private int durationTimeInSeconds;
    private List<String> potionEffects;
}
