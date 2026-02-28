package com.product.controller;

import com.product.model.Category;
import com.product.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST para el recurso de categoría.
 */
@RestController
@RequestMapping("/category")
public class CtrlProduct {

    private final CategoryService categoryService;

    public CtrlProduct(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * GET que devuelve todas las categorias
     * @return Arreglo de objetos Category
     */
    @GetMapping
    public Category[] getCategories() {
        return categoryService.getAllCategories().toArray(new Category[0]);
    }
}
