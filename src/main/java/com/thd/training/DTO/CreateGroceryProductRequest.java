package com.thd.training.DTO;

import com.thd.training.model.GroceryProduct;

public class CreateGroceryProductRequest {
    private GroceryProduct groceryProduct;

    public GroceryProduct getGroceryProduct() {
        return groceryProduct;
    }

    public void setGroceryProduct(GroceryProduct groceryProduct) {
        this.groceryProduct = groceryProduct;
    }
}
