package model.Incomes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestIncomesList {
    private IncomesList testIncomesList;

    @BeforeEach
    void runBefore() {
        testIncomesList = new IncomesList();
    }

    @Test
    void testAddIncome() {
        Income income = new Income("Job 1", 3000);
        testIncomesList.addIncome(income);
        assertTrue(testIncomesList.contains(income));
    }

    @Test
    void testAddMultipleIncomes() {
        Income income = new Income("Job 1", 3000);
        Income income1 = new Income("Job 2", 400);
        Income income2 = new Income("Job 3", 2000);

        testIncomesList.addIncome(income);
        testIncomesList.addIncome(income1);

        assertTrue(testIncomesList.contains(income));
        assertTrue(testIncomesList.contains(income1));
        assertFalse(testIncomesList.contains(income2));
    }

    @Test
    void testRemoveIncome() {
        Income income = new Income("Job 1", 3000);
        testIncomesList.addIncome(income);
        assertTrue(testIncomesList.contains(income));

        testIncomesList.removeIncome(income);
        assertFalse(testIncomesList.contains(income));
    }

    @Test
    void testRemoveMultipleIncomes() {
        Income income = new Income("Job 1", 3000);
        Income income1 = new Income("Job 2", 400);
        Income income2 = new Income("Job 3", 2000);

        testIncomesList.addIncome(income);
        testIncomesList.addIncome(income1);
        testIncomesList.addIncome(income2);

        assertTrue(testIncomesList.contains(income));
        assertTrue(testIncomesList.contains(income1));
        assertTrue(testIncomesList.contains(income2));

        testIncomesList.removeIncome(income);
        testIncomesList.removeIncome(income1);

        assertFalse(testIncomesList.contains(income));
        assertFalse(testIncomesList.contains(income1));
        assertTrue(testIncomesList.contains(income2));
    }

    @Test
    void testModifyIncomeName() {
        Income income = new Income("Job 1", 3000);
        testIncomesList.addIncome(income);
        assertTrue(testIncomesList.contains(income));

        testIncomesList.modifyIncomeName(income, "WORK");
        assertEquals("WORK", testIncomesList.getIncome(income).getIncomeName());
    }

    @Test
    void testModifyMultipleIncomeName() {
        Income income = new Income("Job 1", 3000);
        Income income1 = new Income("Job 2", 400);
        Income income2 = new Income("Job 3", 2000);

        testIncomesList.addIncome(income);
        testIncomesList.addIncome(income1);
        testIncomesList.addIncome(income2);

        assertTrue(testIncomesList.contains(income));
        assertTrue(testIncomesList.contains(income1));
        assertTrue(testIncomesList.contains(income2));

        testIncomesList.modifyIncomeName(income, "WORK");
        testIncomesList.modifyIncomeName(income1, "WORK2");
        testIncomesList.modifyIncomeName(income1, "WORK3");

        assertEquals("WORK", testIncomesList.getIncome(income).getIncomeName());
        assertEquals("WORK3", testIncomesList.getIncome(income1).getIncomeName());
        assertEquals("Job 3", testIncomesList.getIncome(income2).getIncomeName());

    }

    @Test
    void testModifyIncomeAmount() {
        Income income = new Income("Job 1", 3000);
        testIncomesList.addIncome(income);
        assertTrue(testIncomesList.contains(income));

        testIncomesList.modifyIncomeAmount(income, 10);
        assertEquals(10, testIncomesList.getIncome(income).getIncomeAmount());
    }

    @Test
    void testModifyMultipleIncomeAmount() {
        Income income = new Income("Job 1", 3000);
        Income income1 = new Income("Job 2", 400);
        Income income2 = new Income("Job 3", 2000);

        testIncomesList.addIncome(income);
        testIncomesList.addIncome(income1);
        testIncomesList.addIncome(income2);

        assertTrue(testIncomesList.contains(income));
        assertTrue(testIncomesList.contains(income1));
        assertTrue(testIncomesList.contains(income2));

        testIncomesList.modifyIncomeAmount(income, 10);
        testIncomesList.modifyIncomeAmount(income1, 20);
        testIncomesList.modifyIncomeAmount(income1, 80);

        assertEquals(10, testIncomesList.getIncome(income).getIncomeName());
        assertEquals(80, testIncomesList.getIncome(income1).getIncomeName());
        assertEquals(2000, testIncomesList.getIncome(income2).getIncomeName());

    }
}
