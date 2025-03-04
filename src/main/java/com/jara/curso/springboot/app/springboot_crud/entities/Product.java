package com.jara.curso.springboot.app.springboot_crud.entities;

import com.jara.curso.springboot.app.springboot_crud.validation.IsExistsDB;
import com.jara.curso.springboot.app.springboot_crud.validation.IsRequired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "products")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @IsRequired
  @IsExistsDB
  private String sku;

  @IsRequired
  @Size(min = 3, max = 45)
  private String name;

  @IsRequired
  private String description;

  @NotNull(message = "{NotNull.product.price}")
  private Integer price;
  
  public Product() {}

  public Product(String name, String description, Integer price) {
    this.name = name;
    this.description = description;
    this.price = price;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }
  
  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  @Override
  public String toString() {
    return String.format(
        """
        Id: %d    
        Name: %s
        Description: %s
        Price: %d
        """,
        id,
        name,
        description,
        price
    );
  }
}