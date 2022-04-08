package com.lloyds.identity.auth.lab.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Atm {

  @JsonProperty("Identification")
  public String identification;

  @JsonProperty("SupportedCurrencies")
  public List<String> supportedCurrencies;

  @JsonProperty("Location")
  public Location location;

  public Atm() {}

  public Atm(String identification, List<String> supportedCurrencies, Location location) {
    this.identification = identification;
    this.supportedCurrencies = supportedCurrencies;
    this.location = location;
  }

  public String getIdentification() {
    return identification;
  }

  public void setIdentification(String identification) {
    this.identification = identification;
  }

  public List<String> getSupportedCurrencies() {
    return supportedCurrencies;
  }

  public void setSupportedCurrencies(List<String> supportedCurrencies) {
    this.supportedCurrencies = supportedCurrencies;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  @Override
  public String toString() {
    return "Atm{"
        + "identification='"
        + identification
        + '\''
        + ", supportedCurrencies="
        + supportedCurrencies
        + ", location="
        + location
        + '}';
  }
}
