package persistence;


import org.junit.jupiter.api.Test;

import model.expenses.Expense;
import model.expenses.ExpensesList;
import model.incomes.Income;
import model.incomes.IncomesList;
import model.persistence.JsonReader;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//JsonSerializationDemo PROJECT WAS REFERRED TO IN ORDER TO WRITE THIS CODE.
class JsonReaderTest extends JsonTest {

    //ExpensesList based testing
    @Test
    void testReaderNonExistentExpensesFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            ExpensesList eList = reader.readExpenses();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyExpensesList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyExpensesList.json");
        try {
            ExpensesList eList = reader.readExpenses();
            assertNull(eList.getExpenses());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralExpensesList() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralExpensesList.json");
        try {
            ExpensesList eList = reader.readExpenses();
            List<Expense> expenses = eList.getExpenses();
            assertEquals(2, expenses.size());
            checkExpense("car", 100, expenses.get(0));
            checkExpense("house", 1000, expenses.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }


    //IncomesList based testing
    @Test
    void testReaderNonExistentIncomesFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            IncomesList iList = reader.readIncomes();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyIncomesList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyIncomesList.json");
        try {
            IncomesList iList = reader.readIncomes();
            assertNull(iList.getIncomes());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralIncomesList() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralIncomesList.json");
        try {
            IncomesList iList = reader.readIncomes();
            List<Income> incomes = iList.getIncomes();
            assertEquals(2, incomes.size());
            checkIncome("Job 1", 1000, incomes.get(0));
            checkIncome("Job 2", 4000, incomes.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}