package com.thd.training.controller;

import com.thd.training.DTO.*;
import com.thd.training.DTO.ControllerExceptions.GroceryProduct.*;
import com.thd.training.model.GroceryProduct;
import com.thd.training.service.GroceryProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grocery_products")
public class GroceryProductControllerImpl implements GroceryProductController{

    @Autowired
    private GroceryProductService gps;

    @Value( "${handledExceptionsMessages.GroceryProductController.create}" )
    private String exceptionMessageOnCreate;
    @Value( "${handledExceptionsMessages.GroceryProductController.update}" )
    private String exceptionMessageOnUpdate;
    @Value( "${handledExceptionsMessages.GroceryProductController.delete}" )
    private String exceptionMessageOnDelete;
    @Value( "${handledExceptionsMessages.GroceryProductController.findByName}" )
    private String exceptionMessageOnFindByName;
    @Value( "${handledExceptionsMessages.GroceryProductController.findById}" )
    private String exceptionMessageOnFindById;


    @Override
    @PostMapping("/create")
    public ResponseEntity<CreateGroceryProductResponse> create(@RequestBody CreateGroceryProductRequest gp)
    throws CreateGroceryProductException {
        CreateGroceryProductResponse response = new CreateGroceryProductResponse();

        if(gp.getGroceryProduct().getId() != null && gp.getGroceryProduct().getId() != 0){
            throw new CreateGroceryProductException(exceptionMessageOnCreate);
        }
        GroceryProduct g = gps.create(gp.getGroceryProduct());
        response.setGroceryProduct(g);
        return new ResponseEntity<CreateGroceryProductResponse>(response, HttpStatus.OK);
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<UpdateGroceryProductResponse> update(@RequestBody  UpdateGroceryProductRequest gp)
            throws UpdateGroceryProductException {
        UpdateGroceryProductResponse response = new UpdateGroceryProductResponse();

        if(gp.getGroceryProduct().getId() == null || gp.getGroceryProduct().getId() <= 0){
            throw new UpdateGroceryProductException(exceptionMessageOnUpdate);
        }

        GroceryProduct g = gps.create(gp.getGroceryProduct());
        response.setGroceryProduct(g);
        return new ResponseEntity<UpdateGroceryProductResponse>(response, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseEntity<DeletteGroceryProductResponse> delete(@RequestBody DeleteGroceryProductRequest gp)
            throws DeleteGroceryProductException {
        DeletteGroceryProductResponse response = new DeletteGroceryProductResponse();
        Boolean deleted = gps.delete(gp.getId());
        response.setDeleted(deleted);
        if(!deleted)
            throw new DeleteGroceryProductException(exceptionMessageOnDelete);
        return new ResponseEntity<DeletteGroceryProductResponse>(response, HttpStatus.OK);
    }

    @Override
    @GetMapping("/find_by_id")
    public FindByIdGroceryProductResponse findById(@RequestParam("id") Integer id)
            throws FindByIdGroceryProductException {
        FindByIdGroceryProductResponse response = new FindByIdGroceryProductResponse();
        GroceryProduct gp = gps.findById(id);
        if(gp==null)
            throw new FindByIdGroceryProductException(exceptionMessageOnFindById);
        response.setGroceryProduct(gp);
        return response;
    }

    @Override
    @GetMapping("/find_by_name")
    public FindByNameGroceryProductResponse findByName(@RequestParam("name") String name)
            throws FindByNameGroceryProductException {
        FindByNameGroceryProductResponse response = new FindByNameGroceryProductResponse();
        List<GroceryProduct> gprods = gps.findByName(name);
        if(gprods == null || gprods.isEmpty())
            throw new FindByNameGroceryProductException(exceptionMessageOnFindByName);
        response.setGroceryProducts(gprods);
        return response;
    }
}
