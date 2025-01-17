package com.dataset.calc;
import com.dataset.calc.controller.DataSetCalcController;
import com.dataset.calc.model.StandardDeviationResponse;
import com.dataset.calc.service.StandardDeviationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class DataSetCalculationTests {
    @InjectMocks
    private DataSetCalcController dataSetCalcController;

    @Mock
    private StandardDeviationService standardDeviationService;

    @Test
    public void testStandardDeviationCalculation() {
        // Provide a list of numbers (could be Integers, Doubles, etc.)
        List<Number> numbers = Arrays.asList(10.0, 12, 23.0, 23, 16.0, 23, 21.0, 16);

        BigDecimal expected = new BigDecimal("4.9");
        when(standardDeviationService.calculateStandardDeviation(numbers)).thenReturn(expected);

        StandardDeviationResponse actual = dataSetCalcController.calculateStandardDeviation(numbers);
        assertEquals(expected, actual.standardDeviation());
    }
}
