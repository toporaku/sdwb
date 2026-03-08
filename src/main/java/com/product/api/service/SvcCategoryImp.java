package com.product.api.service;

import com.product.api.entity.Category;
import com.product.api.repository.RepoCategory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

/**
 * Implementación de servicio para operaciones de categoría utilizando JPA.
 */
@Service
public class SvcCategoryImp implements SvcCategory {

    @Autowired
    private RepoCategory repoCategory;

    @Override
    public List<Category> getCategories() {
        return repoCategory.getCategories();
    }
}
