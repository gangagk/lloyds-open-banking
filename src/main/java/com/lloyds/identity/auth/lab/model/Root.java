package com.lloyds.identity.auth.lab.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
  @JsonProperty("meta")
  public Meta meta;

  @JsonProperty("data")
  public List<Data> data;

  public Root() {}

  public Root(Meta meta, List<Data> data) {
    this.meta = meta;
    this.data = data;
  }

  public Meta getMeta() {
    return meta;
  }

  public void setMeta(Meta meta) {
    this.meta = meta;
  }

  public List<Data> getData() {
    return data;
  }

  public void setData(List<Data> data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "Root {" + "meta=" + meta + ", data=" + data + '}';
  }
}
