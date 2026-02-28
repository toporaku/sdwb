package com.product.model;

/**
 * Clase modelo de Categoría.
 * Representa una entidad de categoría con un id, nombre, etiqueta y estatus.
 */
public class Category {

    private Integer categoryId;
    private String category;
    private String tag;
    private Integer status;

    public Category() {}

    public Category(Integer categoryId, String category, String tag, Integer status) {
        this.categoryId = categoryId;
        this.category = category;
        this.tag = tag;
        this.status = status;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Category {"
                + "categoryId=" + categoryId
                + ", category='" + category + '\''
                + ", tag='" + tag + '\''
                + ", status=" + status
                + '}';
    }
}
