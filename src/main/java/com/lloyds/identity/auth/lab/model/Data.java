package com.lloyds.identity.auth.lab.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
  @JsonProperty("Brand")
  public List<Brand> brand;

  public Data() {
  }

  public Data(List<Brand> brand) {
    this.brand = brand;
  }

  public List<Brand> getBrand() {
    return brand;
  }

  public void setBrand(List<Brand> brand) {
    this.brand = brand;
  }

  @Override
  public String toString() {
    return "Data{" + "brand=" + brand + '}';
  }
}
