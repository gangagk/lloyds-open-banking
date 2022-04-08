package com.lloyds.identity.auth.lab.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lloyds.identity.auth.lab.model.Root;
import com.lloyds.identity.auth.lab.response.AtmResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class AtmServiceImplTest {

  private static final Logger logger = LoggerFactory.getLogger(AtmServiceImplTest.class);

  private static final String OPEN_API_URL = "https://api.lloydsbank.com/open-banking/v2.2/Atms";

  private static Root root;

  @InjectMocks AtmServiceImpl atmServiceImpl;

  @Mock private RestTemplate restTemplate;

  @BeforeAll
  static void beforeAll() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    root = mapper.readValue(Paths.get("src/test/resources/ValidAtmResponse.json").toFile(), Root.class);
  }

  @Test
  public void verifyNumberOfInvocationsOfAPI() {
    Mockito.when(restTemplate.getForEntity(OPEN_API_URL, Root.class))
        .thenReturn(new ResponseEntity(root, HttpStatus.OK));
    atmServiceImpl.getAtms("", OPEN_API_URL);
    Mockito.verify(restTemplate, times(1)).getForEntity(OPEN_API_URL, Root.class);
  }

  @Test
  public void responseShouldReturnAtmIfIdentificationMatches() {
    Mockito.when(restTemplate.getForEntity(OPEN_API_URL, Root.class))
            .thenReturn(new ResponseEntity(root, HttpStatus.OK));
    AtmResponse atmResponse = atmServiceImpl.getAtms("LFFFBC11", OPEN_API_URL);
    assertEquals(1, atmResponse.getAtms().size());
  }

  @Test
  public void responseShouldReturnEmptyListIfIdentificationDoesNotMatches() {
    Mockito.when(restTemplate.getForEntity(OPEN_API_URL, Root.class))
            .thenReturn(new ResponseEntity(root, HttpStatus.OK));
    AtmResponse atmResponse = atmServiceImpl.getAtms("LFFBC11", OPEN_API_URL);
    assertTrue(atmResponse.getAtms().isEmpty());
  }


}
