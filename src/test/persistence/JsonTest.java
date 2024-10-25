package persistence;


import static org.junit.jupiter.api.Assertions.assertEquals;

import model.Expense;
import model.Income;

//JsonSerializationDemo PROJECT WAS REFERRED TO IN ORDER TO WRITE THIS CODE.
public class JsonTest {
    protected void checkExpense(String name, double amount, Expense expense) {
        assertEquals(name, expense.getExpenseName());
        assertEquals(amount, expense.getExpenseAmount());
    }

    protected void checkIncome(String name, double amount, Income income) {
        assertEquals(name, income.getIncomeName());
        assertEquals(amount, income.getIncomeAmount());
    }
}
