package persistence;

import org.junit.jupiter.api.Test;

import model.Expense;
import model.ExpensesList;
import model.Income;
import model.IncomesList;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//JsonSerializationDemo PROJECT WAS REFERRED TO IN ORDER TO WRITE THIS CODE.
class JsonWriterTest extends JsonTest {

    //ExpensesList based testing
    @Test
    void testWriterInvalidExpensesListFile() {
        try {
            ExpensesList expensesList = new ExpensesList();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyExpensesList() {
        try {
            ExpensesList expensesList = new ExpensesList();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyExpensesList.json");
            writer.open();
            writer.writeExpenses(expensesList);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyExpensesList.json");
            expensesList = reader.readExpenses();
            assertEquals(0, expensesList.getSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralExpensesList() {
        try {
            ExpensesList expensesList = new ExpensesList();
            expensesList.addExpense(new Expense("car", 1000));
            expensesList.addExpense(new Expense("house", 3000));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralExpensesList.json");
            writer.open();
            writer.writeExpenses(expensesList);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralExpensesList.json");
            expensesList = reader.readExpenses();
            List<Expense> expenses = expensesList.getExpenses();
            assertEquals(2, expenses.size());
            checkExpense("car", 1000, expenses.get(0));
            checkExpense("house", 3000, expenses.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    //IncomesList based testing

    @Test
    void testWriterInvalidIncomesListFile() {
        try {
            IncomesList incomesList = new IncomesList();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyIncomesList() {
        try {
            IncomesList incomesList = new IncomesList();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyIncomesList.json");
            writer.open();
            writer.writeIncomes(incomesList);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyIncomesList.json");
            incomesList = reader.readIncomes();
            assertEquals(0, incomesList.getSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralIncomesList() {
        try {
            IncomesList incomesList = new IncomesList();
            incomesList.addIncome(new Income("Job 1", 1000));
            incomesList.addIncome(new Income("Job 2", 4000));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralIncomesList.json");
            writer.open();
            writer.writeIncomes(incomesList);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralIncomesList.json");
            incomesList = reader.readIncomes();
            List<Income> incomes = incomesList.getIncomes();
            assertEquals(2, incomes.size());
            checkIncome("Job 1", 1000, incomes.get(0));
            checkIncome("Job 2", 4000, incomes.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}