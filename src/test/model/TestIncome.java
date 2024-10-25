package model;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONObject;
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
        assertEquals("Job 1", incomeTest.getIncomeName());
        assertEquals(3000, incomeTest.getIncomeAmount());
    }

    @Test
    void testSetIncomeName() {
        incomeTest.setIncomeName("Job 2");
        assertEquals("Job 2", incomeTest.getIncomeName());
    }

    @Test
    void testSetExpenseAmount() {
        incomeTest.setIncomeAmount(200);
        assertEquals(200, incomeTest.getIncomeAmount());
    }

    @Test
    void toJson() {
        JSONObject json = incomeTest.toJson();
        assertEquals(incomeTest.getIncomeName(), json.getString("name"));
        assertEquals(incomeTest.getIncomeAmount(), json.getDouble("amount"));
    }
}
