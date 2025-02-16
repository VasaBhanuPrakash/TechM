package org.bhanu;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Parameters {

    private final Calculator calculator = new Calculator();
    private final String operation;
    private final int a;
    private final int b;
    private final int expected;

    public Parameters(String operation, int a, int b, int expected) {
        this.operation = operation;
        this.a = a;
        this.b = b;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
            {"sum", 3, 2, 5},
            {"sum", -1, -1, -2},
            {"sum", 0, 5, 5},
            {"sum", 100, 200, 300},

            {"diff", 5, 3, 2},
            {"diff", 10, 10, 0},
            {"diff", -5, -3, -2},
            {"diff", 100, 50, 50},

            {"product", 3, 2, 6},
            {"product", -2, 4, -8},
            {"product", 0, 5, 0},
            {"product", 7, 7, 49},

            {"divide", 6, 2, 3},
            {"divide", 9, 3, 3},
            {"divide", -10, 2, -5},
            {"divide", 100, 10, 10}
        });
    }

    @Test
    public void testCalculatorOperations() {
        int result = 0;
        switch (operation) {
            case "sum":
                result = calculator.sum(a, b);
                break;
            case "diff":
                result = calculator.diff(a, b);
                break;
            case "product":
                result = calculator.product(a, b);
                break;
            case "divide":
                result = calculator.divide(a, b);
                break;
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
        Assert.assertEquals("Failed for operation: " + operation, expected, result);
    }
}
