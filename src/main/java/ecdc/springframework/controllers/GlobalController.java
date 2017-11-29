package ecdc.springframework.controllers;

import ecdc.springframework.domain.Global;
import ecdc.springframework.services.GlobalServiceCustom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.UUID;

/**
 * Created by jt on 1/10/17.
 */
@RestController
@RequestMapping(value = "/global")
public class GlobalController {
    private GlobalServiceCustom globalService;


    @Autowired
    public void setProductService(GlobalServiceCustom globalService) {
        this.globalService = globalService;
    }

/*    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/product/list";
    }*/
/*
    @RequestMapping({"/product/list", "/product"})
    public String listProducts(Model model){
        model.addAttribute("products", productService.listAll());
        return "product/list";
    }*/

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Global getGlobal(@PathVariable String id){
    	return globalService.getById(id);
/*        model.addAttribute("product", globalService.getById(UUID.fromString(id)));
        return "global/show";*/
    }

    @RequestMapping("global/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        Global global = globalService.getById(id);
        return global.getId();
       /* ProductForm productForm = productToProductForm.convert(product);

        model.addAttribute("productForm", productForm);
        return "product/productform";
    }*/
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Global add(@RequestBody @Valid Global global){
        return globalService.save(global);
    }

/*    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveOrUpdateProduct(@Valid ProductForm productForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "product/productform";
        }

        Global savedProduct = globalService.saveOrUpdateProductForm(productForm);

        return "redirect:/product/show/" + savedProduct.getId();
    }*/

}
