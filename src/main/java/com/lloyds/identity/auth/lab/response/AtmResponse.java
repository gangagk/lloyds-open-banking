package com.lloyds.identity.auth.lab.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lloyds.identity.auth.lab.model.Atm;

import java.util.ArrayList;
import java.util.List;

public class AtmResponse {

  @JsonProperty("Identification")
  private String identification;

  @JsonProperty("Atm")
  private List<Atm> atms = new ArrayList<>();

  public String getIdentification() {
    return identification;
  }

  public void setIdentification(String identification) {
    this.identification = identification;
  }

  public List<Atm> getAtms() {
    return atms;
  }

  public void setAtms(List<Atm> atms) {
    this.atms = atms;
  }
}
