package model.Incomes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestIncome {

    private Income incomeTest;

    @BeforeEach
    void runBefore() {
        incomeTest = new Income("Job 1", 3000);
    }

    @Test
    void testConstructor() {
        assertEquals("job 1", incomeTest.getIncomeName());
        assertEquals(3000, incomeTest.getIncomeAmount());
    }
}
