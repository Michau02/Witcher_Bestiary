package kaluska.michal.Witcher_Bestiary.alchemy.services;

import kaluska.michal.Witcher_Bestiary.alchemy.models.AlchemyItem;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class BaseAlchemyService<T extends AlchemyItem> {
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
        Optional<T> optOld = Optional.ofNullable(findById(id));
        if (optOld.isEmpty()) return null;

        T old = optOld.get();
        BeanUtils.copyProperties(entity, old, "id");
        return repository.save(old);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

