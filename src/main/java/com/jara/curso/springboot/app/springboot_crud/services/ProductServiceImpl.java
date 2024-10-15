package com.jara.curso.springboot.app.springboot_crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jara.curso.springboot.app.springboot_crud.entities.Product;
import com.jara.curso.springboot.app.springboot_crud.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
  @Autowired
  private ProductRepository repository;

  @Transactional(readOnly = true)
  @Override
  public List<Product> findAll() {
    return (List<Product>) repository.findAll();
  }

  @Transactional(readOnly = true)
  @Override
  public Optional<Product> findById(Long id) {
    return repository.findById(id);
  }
  
  @Transactional
  @Override
  public Product save(Product product) {
    return repository.save(product);
    
  }

  @Transactional
  @Override
  public Optional<Product> update(Long id, Product product) {
    Optional<Product> productOptional = repository.findById(id);
    
    if (productOptional.isPresent()) {
      Product prodductDB = productOptional.orElseThrow();

      prodductDB.setSku(product.getSku());
      prodductDB.setName(product.getName());
      prodductDB.setDescription(product.getDescription());
      prodductDB.setPrice(product.getPrice());

      return Optional.of(repository.save(prodductDB));
    }
    
    return productOptional;
  }
  
  @Transactional
  @Override
  public Optional<Product> delete(Long id) {
    Optional<Product> productOptional = repository.findById(id);
    
    productOptional.ifPresent(prodductDB -> {
      repository.delete(prodductDB);
    });
    
    return productOptional;
  }
  
  @Transactional(readOnly = true)
  @Override
  public boolean existsBySku(String sku) {
    return repository.existsBySku(sku);
  }
}
