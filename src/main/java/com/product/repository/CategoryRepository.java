package com.product.repository;

import com.product.model.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Repositorio en memoria para entidades {@link Category}.
 */
@Repository
public class CategoryRepository {

    private final Map<Integer, Category> storage = new HashMap<>();
    private final Set<String> tags = new HashSet<>();

    public CategoryRepository() {
        // Almacenamiento simulado inicial (Mock data)
        save(new Category(1, "Lentes", "Lts", 1));
        save(new Category(2, "Relojes", "Rljs", 1));
        save(new Category(3, "Mochilas", "Mchs", 1));
        save(new Category(4, "Zapatos", "Zpts", 0)); // Inactivo
    }

    public Category save(Category category) {
        if (storage.containsKey(category.getCategoryId())) {
            throw new IllegalArgumentException(
                    "Ya existe una categoría con el id " + category.getCategoryId() + ".");
        }
        if (tags.contains(category.getTag())) {
            throw new IllegalArgumentException(
                    "Ya existe una categoría con el tag '" + category.getTag() + "'.");
        }

        storage.put(category.getCategoryId(), category);
        tags.add(category.getTag());
        return category;
    }

    public Optional<Category> findById(Integer id) {
        return Optional.ofNullable(storage.get(id));
    }

    public List<Category> findAll() {
        return new ArrayList<>(storage.values());
    }

    public List<Category> findAllActive() {
        return storage.values().stream()
                .filter(c -> c.getStatus() != null && c.getStatus() == 1)
                .collect(Collectors.toList());
    }

    public boolean deleteById(Integer id) {
        Category category = storage.get(id);
        if (category != null && category.getStatus() != null && category.getStatus() == 1) {
            category.setStatus(0);
            return true;
        }
        return false;
    }
}
