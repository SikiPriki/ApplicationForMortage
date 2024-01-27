package mortage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void answerTest(){
        Calculator calculationTest = new Calculator();
        assertEquals(43.870975494384766,calculationTest.FixedMonthlyPayment(1000,5,2));
    }

}