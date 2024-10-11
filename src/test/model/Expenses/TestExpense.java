package model.expenses;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.expenses.Expense;

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
}
