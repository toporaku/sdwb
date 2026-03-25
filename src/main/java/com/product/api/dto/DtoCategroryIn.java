package com.product.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

public class DtoCategroryIn {

    @JsonProperty("category")
    @NotNull(message = "Category is required")
    private String category;

    @JsonProperty("tag")
    @NotNull(message = "Tag is required")
    private String tag;

    @JsonProperty("status")
    private Integer status;

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


    @Override
    public String toString() {
        return "DtoCategroryIn {"
                + "category='" + category + '\''
                + ", tag='" + tag + '\''
                + ", status=" + status
                + '}';
    }
}
