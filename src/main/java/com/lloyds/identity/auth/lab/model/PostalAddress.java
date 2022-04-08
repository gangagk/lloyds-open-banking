package com.lloyds.identity.auth.lab.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostalAddress {
  @JsonProperty("AddressLine")
  public List<String> addressLine;

  @JsonProperty("StreetName")
  public String streetName;

  @JsonProperty("TownName")
  public String townName;

  @JsonProperty("CountrySubDivision")
  public List<String> countrySubDivision;

  @JsonProperty("Country")
  public String country;

  @JsonProperty("PostCode")
  public String postCode;

  public PostalAddress() {}

  public PostalAddress(
      List<String> addressLine,
      String streetName,
      String townName,
      List<String> countrySubDivision,
      String country,
      String postCode) {
    this.addressLine = addressLine;
    this.streetName = streetName;
    this.townName = townName;
    this.countrySubDivision = countrySubDivision;
    this.country = country;
    this.postCode = postCode;
  }

  public List<String> getAddressLine() {
    return addressLine;
  }

  public void setAddressLine(List<String> addressLine) {
    this.addressLine = addressLine;
  }

  public String getStreetName() {
    return streetName;
  }

  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }

  public String getTownName() {
    return townName;
  }

  public void setTownName(String townName) {
    this.townName = townName;
  }

  public List<String> getCountrySubDivision() {
    return countrySubDivision;
  }

  public void setCountrySubDivision(List<String> countrySubDivision) {
    this.countrySubDivision = countrySubDivision;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getPostCode() {
    return postCode;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }

  @Override
  public String toString() {
    return "PostalAddress{"
        + "addressLine="
        + addressLine
        + ", streetName='"
        + streetName
        + '\''
        + ", townName='"
        + townName
        + '\''
        + ", countrySubDivision="
        + countrySubDivision
        + ", country='"
        + country
        + '\''
        + ", postCode='"
        + postCode
        + '\''
        + '}';
  }
}
