package com.jara.curso.springboot.app.springboot_crud.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jara.curso.springboot.app.springboot_crud.services.ProductService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class IsExistsDBValidation implements ConstraintValidator<IsExistsDB, String> {

  @Autowired
  private ProductService service;

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return !service.existsBySku(value);
  }
  
}
