package com.thd.training.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thd.training.model.GroceryProduct;

import java.util.List;

public class FindByNameGroceryProductResponse {
    @JsonProperty("grocery_products")
    private List<GroceryProduct> groceryProducts;

    public List<GroceryProduct> getGroceryProducts() {
        return groceryProducts;
    }

    public void setGroceryProducts(List<GroceryProduct> groceryProducts) {
        this.groceryProducts = groceryProducts;
    }
}
