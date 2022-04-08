package com.lloyds.identity.auth.lab.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Meta {
  @JsonProperty("LastUpdated")
  public Date lastUpdated;

  @JsonProperty("TotalResults")
  public int totalResults;

  @JsonProperty("Agreement")
  public String agreement;

  @JsonProperty("License")
  public String license;

  @JsonProperty("TermsOfUse")
  public String termsOfUse;

  public Meta() {}

  public Meta(
      Date lastUpdated, int totalResults, String agreement, String license, String termsOfUse) {
    this.lastUpdated = lastUpdated;
    this.totalResults = totalResults;
    this.agreement = agreement;
    this.license = license;
    this.termsOfUse = termsOfUse;
  }

  @Override
  public String toString() {
    return "Meta{"
        + "lastUpdated="
        + lastUpdated
        + ", totalResults="
        + totalResults
        + ", agreement='"
        + agreement
        + '\''
        + ", license='"
        + license
        + '\''
        + ", termsOfUse='"
        + termsOfUse
        + '\''
        + '}';
  }

  public Date getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(Date lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public int getTotalResults() {
    return totalResults;
  }

  public void setTotalResults(int totalResults) {
    this.totalResults = totalResults;
  }

  public String getAgreement() {
    return agreement;
  }

  public void setAgreement(String agreement) {
    this.agreement = agreement;
  }

  public String getLicense() {
    return license;
  }

  public void setLicense(String license) {
    this.license = license;
  }

  public String getTermsOfUse() {
    return termsOfUse;
  }

  public void setTermsOfUse(String termsOfUse) {
    this.termsOfUse = termsOfUse;
  }
}
