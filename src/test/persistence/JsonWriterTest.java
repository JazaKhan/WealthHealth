package persistence;

import org.junit.jupiter.api.Test;

import model.expenses.Expense;
import model.expenses.ExpensesList;
import model.incomes.Income;
import model.incomes.IncomesList;
import model.persistence.JsonReader;
import model.persistence.JsonWriter;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest extends JsonTest {

    //ExpensesList based testing
    @Test
    void testWriterInvalidExpensesListFile() {
        try {
            ExpensesList eList = new ExpensesList();
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
            ExpensesList eList = new ExpensesList();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyExpensesList.json");
            writer.open();
            writer.writeExpenses(eList);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyExpensesList.json");
            eList = reader.readExpenses();
            assertEquals(0, eList.getSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralExpensesList() {
        try {
            ExpensesList eList = new ExpensesList();
            eList.addExpense(new Expense("car", 1000));
            eList.addExpense(new Expense("house", 3000));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralExpensesList.json");
            writer.open();
            writer.writeExpenses(eList);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralExpensesList.json");
            eList = reader.readExpenses();
            List<Expense> expenses = eList.getExpenses();
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
            IncomesList iList = new IncomesList();
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
            IncomesList iList = new IncomesList();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyIncomesList.json");
            writer.open();
            writer.writeIncomes(iList);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyIncomesList.json");
            iList = reader.readIncomes();
            assertEquals(0, iList.getSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralIncomesList() {
        try {
            IncomesList iList = new IncomesList();
            iList.addIncome(new Income("Job 1", 1000));
            iList.addIncome(new Income("Job 2", 4000));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralIncomesList.json");
            writer.open();
            writer.writeIncomes(iList);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralIncomesList.json");
            iList = reader.readIncomes();
            List<Income> incomes = iList.getIncomes();
            assertEquals(2, incomes.size());
            checkIncome("Job 1", 1000, incomes.get(0));
            checkIncome("Job 2", 4000, incomes.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}