import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalcAppTest {
    private CalcApp calc;

    @BeforeEach
    public void setUp() {
        calc = new CalcApp();
    }

    @Test
    @Tag("subtest")
    @Tag("sum")
    public void testSumTwoPositives() {
        double expected = 8;
        double actual = calc.addValues(5, 3);
        assertEquals(expected, actual);
    }

    @Test
    @Tag("subtest")
    @Tag("substraction")
    public void testSubstTwoPositivesIsUnexpected() {
        double unexpected = 12;
        double actual = calc.substValues(5, 3);
        assertNotEquals(unexpected, actual);
    }

    @Test
    @Tag("subtest")
    @Tag("substraction")
    public void notNull() {
        double actual = calc.substValues(5, 3);
        assertNotNull(actual);
    }

    @Test
    @Tag("subtest")
    @Tag("substraction")
    @Tag("sum")
    public void notThrowsException() {
        assertDoesNotThrow(() -> {
            calc.substValues(5, 3);
            calc.addValues(5, 3);
        });
    }

    @Test
    @Tag("subtest")
    @Tag("isPositive")
    public void moreThanZero() {
        double actual = calc.substValues(5, 3);
        assertTrue(actual > 0);
    }

    @ParameterizedTest
    @CsvSource(value = {"15,5,20",
            "5,3,8",
            "2,4,6",
            "20,1,21"})
    public void testSumTwoPositivesForMoreExamples(double input1, double input2, double expected) {
        double actual = calc.addValues(input1, input2);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {"15,5,12",
            "5,3,1",
            "2,4,15",
            "20,1,17"})
    public void testSubstTwoPositivesIsUnexpectedFmE(double input1, double input2, double unexpected) {
        double actual = calc.substValues(input1, input2);
        assertNotEquals(unexpected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {"15,5,20",
            "5,3,8",
            "2,4, 6",
            "20,2,22"})
    public void testAddValues(double val1, double val2, double expected) {
        double actual = calc.addValues(val1, val2);
        assertEquals(expected, actual);
        assertDoesNotThrow(() -> {
            calc.addValues(val1, val2);
        });
        assertTrue(actual % 2 == 0);
    }

    @ParameterizedTest
    @CsvSource(value = {"15,5,20",
            "5,3,8",
            "2,4, 6",
            "20,2,22"})
    public void testMoreComplexAssertJ(double val1, double val2, double expected) {
        double actual = calc.addValues(val1, val2);
        assertThat(actual)
                .as("%f + %f = %f", val1, val2, expected)
                .isEqualTo(expected)
                .isNotEqualTo(0)
                .isGreaterThan(-999)
                .isLessThan(999)
                .isBetween(-999.0, 999.0)
                .isNotCloseTo(0, offset(0.1))
                .isNotNull()
                .isNotNaN()
                .isNotInstanceOf(Exception.class);
        assertThat(actual % 2 == 0).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"5, 2, 25",
            "4, 3, 64",
            "2, 5, 32"})
    public void testPowValue(double val1, double pow, double expected) {
        double actual = calc.powValue(val1, pow);
        assertEquals(expected, actual);
        assertThat(actual)
                .isEqualTo(expected)
                .isNotNull();
        assertThat(pow >= 0).isTrue();
        assertDoesNotThrow(() -> {
            calc.powValue(val1, pow);
        });
    }

        @ParameterizedTest
        @CsvSource(value = {"5, -1",
                "4, -1",
                "2, -2"})
        public void testPowNegativeValue(double val1, double pow) {
        assertThrows(ArithmeticException.class, () -> { calc.powValue(val1, pow); });
    }

    @ParameterizedTest
    @CsvSource(value = {"5, 1, 5",
            "4, 2, 2",
            "20, 5, 4"})
    public void testDivValue(double val1, double val2, double expected) {
        double actual = calc.divValue(val1, val2);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {"5, 0",
            "4, 0",
            "20, 0"})
    public void testDivValueZero(double val1, double val2) {
        assertThrows(ArithmeticException.class, () -> {calc.divValue(val1, val2);});
    }

    @ParameterizedTest
    @CsvSource(value = {"25, 5",
            "16, 4",
            "64, 8"})
    public void testSqrtValue(double val1, double expected) {
        double actual = calc.sqrtValue(val1);
        assertEquals(expected, actual);
    }
    @ParameterizedTest
    @CsvSource(value = {"-25",
            "-4",
            "-8"})
    public void testSqrtPositiveValue(double val1) {
        assertThrows(ArithmeticException.class, () -> { calc.sqrtValue(val1); });
    }

}
