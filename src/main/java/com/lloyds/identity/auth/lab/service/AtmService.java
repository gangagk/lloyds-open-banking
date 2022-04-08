package com.lloyds.identity.auth.lab.service;

import com.lloyds.identity.auth.lab.response.AtmResponse;

/**
 * This interface has methods related to ATM services
 */
public interface AtmService {

  AtmResponse getAtms(String identification, String url);
}
