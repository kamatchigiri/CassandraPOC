package ecdc.springframework.services;

import ecdc.springframework.domain.Global;

import java.util.List;
import java.util.UUID;

/**
 * Created by jt on 1/10/17.
 */
public interface GlobalServiceCustom {


    Global getById(int id);
    Global save(Global global);
 //   Product saveOrUpdateProductForm(ProductForm productForm);
}
