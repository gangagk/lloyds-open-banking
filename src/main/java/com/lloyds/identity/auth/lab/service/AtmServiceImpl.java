package com.lloyds.identity.auth.lab.service;

import com.lloyds.identity.auth.lab.model.Atm;
import com.lloyds.identity.auth.lab.model.Root;
import com.lloyds.identity.auth.lab.response.AtmResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtmServiceImpl implements AtmService {

  private static final Logger logger = LoggerFactory.getLogger(AtmServiceImpl.class);

  @Autowired
  RestTemplate restTemplate;

  @Override
  public AtmResponse getAtms(String identification, String url) {
    AtmResponse atmResponse = new AtmResponse();
    atmResponse.setIdentification(identification);
    List<Atm> filteredAtms = new ArrayList<>();
    //rest call to open banking atm api for fetching the data
    ResponseEntity<Root> response = restTemplate.getForEntity(url, Root.class);
    if (checkIfValidResponse(response)) {
      List<Atm> atmRsp = response.getBody().getData().get(0).getBrand().get(0).getAtm();
      logger.info("Result from open banking atm API : {}", atmRsp);
      // Code to filter atm response based on the identification passed
      filteredAtms =
          atmRsp.stream()
              .filter(atm -> identification.equalsIgnoreCase(atm.identification))
              .collect(Collectors.toList());
      atmResponse.getAtms().addAll(filteredAtms);
      // Code to add entire atms to response
//      atmResponse.getAtms().addAll(atmRsp);


    }
    return atmResponse;
  }

  /**
   * This method will check for nulls and return true for valid response
   *
   * @return
   */
  private boolean checkIfValidResponse(ResponseEntity<Root> response) {
    return null != response
            && null != response.getBody()
            && null != response.getBody().getData()
            && null != response.getBody().getData().get(0)
            && null != response.getBody().getData().get(0).getBrand()
            && null != response.getBody().getData().get(0).getBrand().get(0)
            && null != response.getBody().getData().get(0).getBrand().get(0).getAtm();
  }
}
