package com.product.api.service;

import com.product.api.entity.Category;
import com.product.api.repository.RepoCategory;
import com.product.exception.ApiException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Implementación de servicio para operaciones de categoría utilizando JPA.
 */
@Service
public class SvcCategoryImp implements SvcCategory {

    @Autowired
    private RepoCategory repoCategory;

    @Override
    public ResponseEntity<List<Category>> getCategories() {
        try {
            // Prueba de excepcion
            // throw new DataAccessException("Simulated database failure");

            return new ResponseEntity<>(repoCategory.getCategories(), HttpStatus.OK);
        } catch (DataAccessException e) {
            throw new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
