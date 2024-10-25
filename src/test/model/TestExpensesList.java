package model;

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

        testExpensesList.removeExpense("Food", 200);
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

        testExpensesList.removeExpense("Food", 200);
        testExpensesList.removeExpense("Clothes", 400);
        testExpensesList.removeExpense("Jewelry", 80);
        testExpensesList.removeExpense("NotJewelry", 2000);

        assertFalse(testExpensesList.contains(expense));
        assertFalse(testExpensesList.contains(expense1));
        assertTrue(testExpensesList.contains(expense2));
    }

    @Test
    void testModifyExpenseName() {
        Expense expense = new Expense("Food", 200);
        testExpensesList.addExpense(expense);
        assertTrue(testExpensesList.contains(expense));

        testExpensesList.modifyExpenseName("Food", "Clothes");
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

        testExpensesList.modifyExpenseName("Food", "Bills");
        testExpensesList.modifyExpenseName("Clothes", "Utilities");
        testExpensesList.modifyExpenseName("Utilities", "Shoes");
        testExpensesList.modifyExpenseName("Jewlry", "None");

        assertEquals("Bills", testExpensesList.getExpense(expense).getExpenseName());
        assertEquals("Shoes", testExpensesList.getExpense(expense1).getExpenseName());
        assertEquals("Jewelry", testExpensesList.getExpense(expense2).getExpenseName());
        assertEquals("Jewelry", testExpensesList.getExpense(expense2).getExpenseName());

    }

    @Test
    void testModifyExpenseAmount() {
        Expense expense = new Expense("Food", 200);
        testExpensesList.addExpense(expense);
        assertTrue(testExpensesList.contains(expense));

        testExpensesList.modifyExpenseAmount(200, 10);
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

        testExpensesList.modifyExpenseAmount(200, 10);
        testExpensesList.modifyExpenseAmount(400, 20);
        testExpensesList.modifyExpenseAmount(20, 80);
        testExpensesList.modifyExpenseAmount(200, 0);

        assertEquals(10, testExpensesList.getExpense(expense).getExpenseAmount());
        assertEquals(80, testExpensesList.getExpense(expense1).getExpenseAmount());
        assertEquals(2000, testExpensesList.getExpense(expense2).getExpenseAmount());
        assertEquals(2000, testExpensesList.getExpense(expense2).getExpenseAmount());

    }

    @Test
    void testViewExpensesList() {
        Expense expense = new Expense("Food", 200);
        testExpensesList.addExpense(expense);
        assertTrue(testExpensesList.contains(expense));

        assertEquals("Food: 200.0 ", testExpensesList.viewExpensesList());
    }

    @Test
    void testViewMultipleExpensesList() {
        Expense expense = new Expense("Food", 200);
        Expense expense1 = new Expense("Clothes", 400);
        Expense expense2 = new Expense("Jewelry", 2000);

        testExpensesList.addExpense(expense);
        testExpensesList.addExpense(expense1);
        testExpensesList.addExpense(expense2);

        assertTrue(testExpensesList.contains(expense));
        assertTrue(testExpensesList.contains(expense1));
        assertTrue(testExpensesList.contains(expense2));

        assertEquals("Food: 200.0 Clothes: 400.0 Jewelry: 2000.0 ", testExpensesList.viewExpensesList());
    }

    //add tests
}
