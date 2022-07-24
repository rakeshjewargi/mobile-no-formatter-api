package com.link.mobility.apis.controller;

import com.link.mobility.apis.models.PhoneNo;
import com.link.mobility.apis.service.IValidateMobNumbService;
import com.link.mobility.apis.service.impl.ValidateMobNumbServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/validate")
@Validated
public class ValidateMobNumbController {

    private static final Logger LOGGER= LoggerFactory.getLogger(ValidateMobNumbServiceImpl.class);

    IValidateMobNumbService validateMobNumbService;

    @Autowired
    ValidateMobNumbController(IValidateMobNumbService validateMobNumbService){
        this.validateMobNumbService = validateMobNumbService;
    }

    @GetMapping("/mobile")
    public ResponseEntity<PhoneNo> validate(@Valid @RequestBody PhoneNo numbers){
        LOGGER.info("Inside ValidateMobNumbController.validate()");
        PhoneNo phoneNo=new PhoneNo();
        phoneNo.setNumbers(validateMobNumbService.getValidMobNumbList(numbers.getNumbers()));
        return ResponseEntity.ok(phoneNo);
    }

}
