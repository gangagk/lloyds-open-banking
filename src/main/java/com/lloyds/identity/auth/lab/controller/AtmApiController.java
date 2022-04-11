package com.lloyds.identity.auth.lab.controller;

import com.lloyds.identity.auth.lab.response.AtmResponse;
import com.lloyds.identity.auth.lab.service.AtmServiceImpl;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
public class AtmApiController implements AtmApi {

    private static final Logger logger = LoggerFactory.getLogger(AtmApiController.class);

    private final HttpServletRequest request;

    private final AtmServiceImpl atmServiceImpl;

    @Autowired
    public AtmApiController(AtmServiceImpl atmServiceImpl, HttpServletRequest request) {
        this.atmServiceImpl = atmServiceImpl;
        this.request = request;
    }

    public ResponseEntity<AtmResponse> fetchAtm(@NotNull @Parameter(in = ParameterIn.QUERY,
            description = "pass an identification value" ,required=true,schema=@Schema()) @Valid @RequestParam(
            value = "identification", required = true) String identification, @NotNull @Parameter(
            in = ParameterIn.QUERY, description = "pass an url from which the details need to be retrieved" ,
            required=true,schema=@Schema()) @Valid @RequestParam(value = "url", required = true) String url) {
        String accept = request.getHeader("Accept");
      AtmResponse response = null;
      if (accept != null && accept.contains("application/json")) {
        logger.info("Calling GET API in AtmAPI Controller");
        response = atmServiceImpl.getAtms(identification, url);
        return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
