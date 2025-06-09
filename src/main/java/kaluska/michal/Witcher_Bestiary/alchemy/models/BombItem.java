package kaluska.michal.Witcher_Bestiary.alchemy.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BombItem extends AlchemyItem {
    private double range;
    private int damage;
    private int charges;
}
