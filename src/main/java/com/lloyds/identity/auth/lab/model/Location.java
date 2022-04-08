package com.lloyds.identity.auth.lab.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
  @JsonProperty("PostalAddress")
  public PostalAddress postalAddress;

  public Location() {}

  public Location(PostalAddress postalAddress) {
    this.postalAddress = postalAddress;
  }

  public PostalAddress getPostalAddress() {
    return postalAddress;
  }

  public void setPostalAddress(PostalAddress postalAddress) {
    this.postalAddress = postalAddress;
  }

  @Override
  public String toString() {
    return "Location{" + "postalAddress=" + postalAddress + '}';
  }
}
