package com.link.mobility.apis.service.impl;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.link.mobility.apis.constants.MobilityConstants;
import com.link.mobility.apis.service.IValidateMobNumbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ValidateMobNumbServiceImpl implements IValidateMobNumbService {
    private static final Logger LOGGER= LoggerFactory.getLogger(ValidateMobNumbServiceImpl.class);

    public List<String> getValidMobNumbList(List<String> numbers) {
        LOGGER.info("Inside getValidMobNumbList");
        List<String> list=new ArrayList<>();
        numbers.forEach( data -> {
            try {
                PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
                Phonenumber.PhoneNumber phoneNumber = phoneUtil.parse(data, MobilityConstants.REGION_CODE);
                if(phoneUtil.isValidNumber(phoneNumber)){
                    list.add(phoneNumber.getCountryCode()+""+phoneNumber.getNationalNumber());
                }else{
                    list.add("invalid");
                }
            } catch (NumberParseException e) {
                LOGGER.error("Error at getValidMobNumbList " +e.getStackTrace());
            }
        });
        return list;
    }
}
