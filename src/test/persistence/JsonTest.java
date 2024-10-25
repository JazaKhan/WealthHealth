package persistence;


import static org.junit.jupiter.api.Assertions.assertEquals;

import model.expenses.Expense;
import model.incomes.Income;

public class JsonTest {
    protected void checkExpense(String name, Double amount, Expense expense) {
        assertEquals(name, expense.getExpenseName());
        assertEquals(amount, expense.getExpenseAmount());
    }

    protected void checkIncome(String name, Double amount, Income income) {
        assertEquals(name, income.getIncomeName());
        assertEquals(amount, income.getIncomeAmount());
    }
}
