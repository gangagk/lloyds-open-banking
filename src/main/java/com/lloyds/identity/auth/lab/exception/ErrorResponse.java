package com.lloyds.identity.auth.lab.exception;

public class ErrorResponse {

  private String message;
  private String time;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }
}
