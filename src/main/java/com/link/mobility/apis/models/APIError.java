package com.link.mobility.apis.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIError {
    String errorCode;
    String errorMsg;
    Date timestamp;
}
