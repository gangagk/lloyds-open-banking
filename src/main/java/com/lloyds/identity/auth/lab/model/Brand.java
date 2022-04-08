package com.lloyds.identity.auth.lab.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Brand {
  @JsonProperty("BrandName")
  public String brandName;

  @JsonProperty("ATM")
  public List<Atm> atm;

  public Brand() {}

  public Brand(String brandName, List<Atm> atm) {
    this.brandName = brandName;
    this.atm = atm;
  }

  public String getBrandName() {
    return brandName;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

  public List<Atm> getAtm() {
    return atm;
  }

  public void setAtm(List<Atm> atm) {
    this.atm = atm;
  }

  @Override
  public String toString() {
    return "Brand{" + "brandName='" + brandName + '\'' + ", Atm=" + atm + '}';
  }
}
