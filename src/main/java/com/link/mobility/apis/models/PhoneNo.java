package com.link.mobility.apis.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNo {
    @NotEmpty(message = "Numbers field is mandatory")
    List<String> numbers;
}
