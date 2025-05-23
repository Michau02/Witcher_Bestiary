package kaluska.michal.Witcher_Bestiary.alchemy.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BombItem extends AlchemyItem {
    private double range;
    private int damage;
}
