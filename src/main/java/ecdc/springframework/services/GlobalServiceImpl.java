package ecdc.springframework.services;

import ecdc.springframework.domain.Global;
import ecdc.springframework.repositories.GlobalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by jt on 1/10/17.
 */
@Service
public class GlobalServiceImpl implements GlobalServiceCustom {

    private GlobalRepository repository;

/*    @Autowired
    public GlobalServiceImpl(GlobalRepository repository, ProductFormToProduct productFormToProduct) {
        this.repository = repository;
        this.productFormToProduct = productFormToProduct;
    }*/
    
    @Autowired
    public GlobalServiceImpl(GlobalRepository repository) {
        this.repository = repository;
        
    }


    @Override
    public Global getById(String id) {
        return repository.getById(id);
    }

    
    public Global save(Global global) {
    	repository.save(global);
        return global;
    }



/*
    @Override
    public Product saveOrUpdateProductForm(ProductForm productForm) {
        Product savedProduct = saveOrUpdate(productFormToProduct.convert(productForm));

        System.out.println("Saved Product Id: " + savedProduct.getId());
        return savedProduct;
    }*/
}
