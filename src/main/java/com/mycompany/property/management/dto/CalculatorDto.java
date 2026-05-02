package com.mycompany.property.management.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CalculatorDto {

    private Double num1;
    private Double num2;
    private Double num3;

    @JsonProperty("num41")
    private Double num4;


}
