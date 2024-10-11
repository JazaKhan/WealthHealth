package model.Expenses;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestExpensesList {
    private ExpensesList testExpensesList;

    @BeforeEach
    void runBefore() {
        testExpensesList = new ExpensesList();
    }

    @Test
    void testAddExpense() {
        Expense expense = new Expense("Food", 200);
        testExpensesList.addExpense(expense);
        assertTrue(testExpensesList.contains(expense));
    }

    @Test
    void testAddMultipleExpenses() {
        Expense expense = new Expense("Food", 200);
        Expense expense1 = new Expense("Clothes", 400);
        Expense expense2 = new Expense("Jewelry", 2000);

        testExpensesList.addExpense(expense);
        testExpensesList.addExpense(expense1);

        assertTrue(testExpensesList.contains(expense));
        assertTrue(testExpensesList.contains(expense1));
        assertFalse(testExpensesList.contains(expense2));
    }

    @Test
    void testRemoveExpense() {
        Expense expense = new Expense("Food", 200);
        testExpensesList.addExpense(expense);
        assertTrue(testExpensesList.contains(expense));

        testExpensesList.removeExpense(expense);
        assertFalse(testExpensesList.contains(expense));
    }

    @Test
    void testRemoveMultipleExpenses() {
        Expense expense = new Expense("Food", 200);
        Expense expense1 = new Expense("Clothes", 400);
        Expense expense2 = new Expense("Jewelry", 2000);

        testExpensesList.addExpense(expense);
        testExpensesList.addExpense(expense1);
        testExpensesList.addExpense(expense2);

        assertTrue(testExpensesList.contains(expense));
        assertTrue(testExpensesList.contains(expense1));
        assertTrue(testExpensesList.contains(expense2));

        testExpensesList.removeExpense(expense);
        testExpensesList.removeExpense(expense1);

        assertFalse(testExpensesList.contains(expense));
        assertFalse(testExpensesList.contains(expense1));
        assertTrue(testExpensesList.contains(expense2));
    }

    @Test
    void testModifyExpenseName() {
        Expense expense = new Expense("Food", 200);
        testExpensesList.addExpense(expense);
        assertTrue(testExpensesList.contains(expense));

        testExpensesList.modifyExpenseName(expense, "Clothes");
        assertEquals("Clothes", testExpensesList.getExpense(expense).getExpenseName());
    }

    @Test
    void testModifyMultipleExpenseName() {
        Expense expense = new Expense("Food", 200);
        Expense expense1 = new Expense("Clothes", 400);
        Expense expense2 = new Expense("Jewelry", 2000);

        testExpensesList.addExpense(expense);
        testExpensesList.addExpense(expense1);
        testExpensesList.addExpense(expense2);

        assertTrue(testExpensesList.contains(expense));
        assertTrue(testExpensesList.contains(expense1));
        assertTrue(testExpensesList.contains(expense2));

        testExpensesList.modifyExpenseName(expense, "Bills");
        testExpensesList.modifyExpenseName(expense1, "Utilities");
        testExpensesList.modifyExpenseName(expense1, "Shoes");

        assertEquals("Bills", testExpensesList.getExpense(expense).getExpenseName());
        assertEquals("Shoes", testExpensesList.getExpense(expense1).getExpenseName());
        assertEquals("Jewelry", testExpensesList.getExpense(expense2).getExpenseName());

    }

    @Test
    void testModifyExpenseAmount() {
        Expense expense = new Expense("Food", 200);
        testExpensesList.addExpense(expense);
        assertTrue(testExpensesList.contains(expense));

        testExpensesList.modifyExpenseAmount(expense, 10);
        assertEquals(10, testExpensesList.getExpense(expense).getExpenseAmount());
    }

    @Test
    void testModifyMultipleExpenseAmount() {
        Expense expense = new Expense("Food", 200);
        Expense expense1 = new Expense("Clothes", 400);
        Expense expense2 = new Expense("Jewelry", 2000);

        testExpensesList.addExpense(expense);
        testExpensesList.addExpense(expense1);
        testExpensesList.addExpense(expense2);

        assertTrue(testExpensesList.contains(expense));
        assertTrue(testExpensesList.contains(expense1));
        assertTrue(testExpensesList.contains(expense2));

        testExpensesList.modifyExpenseAmount(expense, 10);
        testExpensesList.modifyExpenseAmount(expense1, 20);
        testExpensesList.modifyExpenseAmount(expense1, 80);

        assertEquals(10, testExpensesList.getExpense(expense).getExpenseName());
        assertEquals(80, testExpensesList.getExpense(expense1).getExpenseName());
        assertEquals(2000, testExpensesList.getExpense(expense2).getExpenseName());

    }

}
