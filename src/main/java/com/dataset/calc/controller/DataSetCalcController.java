package com.dataset.calc.controller;
import com.dataset.calc.model.StandardDeviationResponse;
import com.dataset.calc.service.StandardDeviationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/statistics")
public class DataSetCalcController {
    private final StandardDeviationService standardDeviationService;
    public DataSetCalcController(StandardDeviationService standardDeviationService){
        this.standardDeviationService = standardDeviationService;
    }

    // Accept a List<Number> directly in the request body
    @PostMapping("/standard-deviation")
    public StandardDeviationResponse calculateStandardDeviation(@RequestBody List<Number> numbers) {
        BigDecimal result = standardDeviationService.calculateStandardDeviation(numbers);
        return new StandardDeviationResponse(result);
    }


}
