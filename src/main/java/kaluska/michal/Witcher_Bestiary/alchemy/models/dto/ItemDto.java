package kaluska.michal.Witcher_Bestiary.alchemy.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ItemDto {
    private Long id;
    private String name;
    private String description;
    private int costOfCrafting;
    private int itemLevel;
}
