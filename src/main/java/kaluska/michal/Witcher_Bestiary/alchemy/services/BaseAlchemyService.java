package kaluska.michal.Witcher_Bestiary.alchemy.services;

import kaluska.michal.Witcher_Bestiary.alchemy.models.AlchemyItem;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@RequiredArgsConstructor
public class BaseAlchemyService<T extends AlchemyItem> {
    protected final JpaRepository<T, Long> repository;

    public List<T> findAll() {
        return repository.findAll();
    }

    public T findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public T save(T entity) {
        return repository.save(entity);
    }

    public T update(Long id, T entity) {
        // doing it manually for now - until I create mappers - just to see it work :)

        T old = findById(id);
        old.setName(entity.getName());
        old.setDescription(entity.getDescription());
        return repository.save(old);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

