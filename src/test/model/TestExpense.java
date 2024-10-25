package model;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestExpense {

    private Expense expenseTest;

    @BeforeEach
    void runBefore() {
        expenseTest = new Expense("Clothes", 300);
    }

    @Test
    void testConstructor() {
        assertEquals("Clothes", expenseTest.getExpenseName());
        assertEquals(300, expenseTest.getExpenseAmount());

    }

    @Test
    void testSetExpenseName() {
        expenseTest.setExpenseName("Shoes");
        assertEquals("Shoes", expenseTest.getExpenseName());
    }

    @Test
    void testSetExpenseAmount() {
        expenseTest.setExpenseAmount(200);
        assertEquals(200, expenseTest.getExpenseAmount());
    }

    @Test
    void toJson() {
        JSONObject json = expenseTest.toJson();
        assertEquals(expenseTest.getExpenseName(), json.getString("name"));
        assertEquals(expenseTest.getExpenseAmount(), json.getDouble("amount"));
    }
}
