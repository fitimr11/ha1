package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    //TODO hier weitere Tests erstellen


    //grüner Test
    @Test
    @DisplayName("should change percentage to decimal")
    void testChangePercentageToDecimal() {
        Calculator calc = new Calculator();

        //calc.pressDigitKey(33);
        calc.pressDigitKey(3);
        calc.pressDigitKey(3);
        //calc.pressBinaryOperationKey(%);
        //calc.pressBinaryOperationsKey("%");
        //calc.pressUnaryOperationKey(%);
        calc.pressUnaryOperationKey("%");
        //calc.pressEqualsKey();

        String expected = "0.33";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    //roter Test
    @Test
    @DisplayName("should multiply decimal numbers and only show 2 digits after the comma")
    void testMultiplyDecimalNumbers() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(3);
        //calc.pressDotKey(.);
        calc.pressDotKey();
        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(3);
        calc.pressDotKey();
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "10.24"; //Expected :10.24 Actual   :10.2400000
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("should display error after dividing numbers with 0")
    void testDivideByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressDigitKey(4);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "error"; //Expected :error Actual   :Infinity
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }




}

