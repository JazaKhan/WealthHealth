package model.incomes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.incomes.Income;

public class TestIncome {

    private Income incomeTest;

    @BeforeEach
    void runBefore() {
        incomeTest = new Income("Job 1", 3000);
    }

    @Test
    void testConstructor() {
        assertEquals("Job 1", incomeTest.getIncomeName());
        assertEquals(3000, incomeTest.getIncomeAmount());
    }
}
