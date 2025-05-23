package kaluska.michal.Witcher_Bestiary.alchemy.controllers;

import kaluska.michal.Witcher_Bestiary.alchemy.models.AlchemyItem;
import kaluska.michal.Witcher_Bestiary.alchemy.services.BaseAlchemyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
public abstract class BaseAlchemyController<T extends AlchemyItem> {
    private final BaseAlchemyService<T> service;

    @GetMapping
    public List<T> findAll() {
        return service.findAll();
    }
}
