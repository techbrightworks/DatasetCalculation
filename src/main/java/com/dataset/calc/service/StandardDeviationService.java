package com.dataset.calc.service;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class StandardDeviationService {
    // Accept List<Number> directly
    public BigDecimal calculateStandardDeviation(List<Number> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return BigDecimal.ZERO;
        }

        BigDecimal mean = calculateMean(numbers);
        BigDecimal sumOfSquares = BigDecimal.ZERO;

        for (Number num : numbers) {
            BigDecimal diff = BigDecimal.valueOf(num.doubleValue()).subtract(mean);
            sumOfSquares = sumOfSquares.add(diff.pow(2));
        }

        BigDecimal variance = sumOfSquares.divide(BigDecimal.valueOf(numbers.size()), RoundingMode.HALF_UP);
        return sqrt(variance).setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateMean(List<Number> numbers) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Number num : numbers) {
            sum = sum.add(BigDecimal.valueOf(num.doubleValue()));
        }
        return sum.divide(BigDecimal.valueOf(numbers.size()), RoundingMode.HALF_UP);
    }

    private BigDecimal sqrt(BigDecimal value) {
        return value.sqrt(new java.math.MathContext(10)); // Precision of 10
    }
}
