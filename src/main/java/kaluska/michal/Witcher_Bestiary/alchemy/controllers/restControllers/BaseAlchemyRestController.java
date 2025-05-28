package kaluska.michal.Witcher_Bestiary.alchemy.controllers.restControllers;

import kaluska.michal.Witcher_Bestiary.alchemy.models.AlchemyItem;
import kaluska.michal.Witcher_Bestiary.alchemy.services.BaseAlchemyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
public abstract class BaseAlchemyRestController<T extends AlchemyItem> {
    protected final BaseAlchemyService<T> service;

    @GetMapping
    public List<T> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public T findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public T save(@RequestBody final T item) {
        return service.save(item);
    }

    @PutMapping("/{id}")
    public T update(@PathVariable("id") Long id, @RequestBody final T item) {
        return service.update(id, item);
    }

    @DeleteMapping
    public void delete(@RequestBody final Long id) {
        service.deleteById(id);
    }
}
