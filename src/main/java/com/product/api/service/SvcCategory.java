package com.product.api.service;

import com.product.api.entity.Category;

import java.util.List;

import org.springframework.http.ResponseEntity;

/**
 * Interfaz de servicio para operaciones de categoría.
 */
public interface SvcCategory {

    ResponseEntity<List<Category>> getCategories();
}
