package com.jara.curso.springboot.app.springboot_crud.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.jara.curso.springboot.app.springboot_crud.entities.Product;

@Component
public class ProductValidation implements Validator{

  @Override
  public boolean supports(@SuppressWarnings("null") Class<?> clazz) {
    return Product.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(@SuppressWarnings("null") Object target, @SuppressWarnings("null") Errors errors) {
    Product product = (Product) target;
    
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "es requerido");
    // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotBlanck.product.description");

    if (product.getDescription() == null || product.getDescription().isBlank()) {
      errors.rejectValue("description", "", "es requerido");
    }

    if (product.getPrice() == null) {
      errors.rejectValue("price", "", "es requerido"); 
    }
  }
  
}
