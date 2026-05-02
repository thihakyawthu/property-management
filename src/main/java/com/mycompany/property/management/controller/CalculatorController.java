package com.mycompany.property.management.controller;

import com.mycompany.property.management.dto.CalculatorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")//class level mapping of url to controller class
public class CalculatorController {

    //http://localhost:8080/api/v1/calculator/add
    //localhost:8080/api/v1/calculator/add?num111=6.7&num222=1.3
    @GetMapping("/add")//method level mapping of a url contorller function
    public Double add(@RequestParam("num111") Double num1, @RequestParam("num222") Double num2){
        return num1+num2;
    }

    @GetMapping("/sub/{num1}/{num2}")//Map the values of url to java variables by Path variable method
    public Double substract(@PathVariable("num1") Double num1, @PathVariable("num2") Double num2){
        Double result = null;
        if(num1>num2){
            result = num1 - num2;
        }else{
            result =  num2 - num1;
        }
        return result;
    }

    @PostMapping("/mul")
    public Double multiply(@RequestBody CalculatorDto calculatorDTO){
        Double result = null;
        result = calculatorDTO.getNum1() * calculatorDTO.getNum2() * calculatorDTO.getNum3() * calculatorDTO.getNum4();
        ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);
        return result;
    }

}
