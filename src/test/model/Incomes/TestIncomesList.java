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

        testIncomesList.removeIncome("Job 1", 3000);
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

        testIncomesList.removeIncome("Job 1", 3000);
        testIncomesList.removeIncome("Job 2", 400);

        assertFalse(testIncomesList.contains(income));
        assertFalse(testIncomesList.contains(income1));
        assertTrue(testIncomesList.contains(income2));
    }

    @Test
    void testModifyIncomeName() {
        Income income = new Income("Job 1", 3000);
        testIncomesList.addIncome(income);
        assertTrue(testIncomesList.contains(income));

        testIncomesList.modifyIncomeName("Job 1", "WORK");
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

        testIncomesList.modifyIncomeName("Job 1", "WORK");
        testIncomesList.modifyIncomeName("WORK", "WORK2");
        testIncomesList.modifyIncomeName("Job 2", "WORK3");

        assertEquals("WORK2", testIncomesList.getIncome(income).getIncomeName());
        assertEquals("WORK3", testIncomesList.getIncome(income1).getIncomeName());
        assertEquals("Job 3", testIncomesList.getIncome(income2).getIncomeName());

    }

    @Test
    void testModifyIncomeAmount() {
        Income income = new Income("Job 1", 3000);
        testIncomesList.addIncome(income);
        assertTrue(testIncomesList.contains(income));

        testIncomesList.modifyIncomeAmount(3000, 10);
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

        testIncomesList.modifyIncomeAmount(3000, 10);
        testIncomesList.modifyIncomeAmount(400, 20);
        testIncomesList.modifyIncomeAmount(20, 80);

        assertEquals(10, testIncomesList.getIncome(income).getIncomeAmount());
        assertEquals(80, testIncomesList.getIncome(income1).getIncomeAmount());
        assertEquals(2000, testIncomesList.getIncome(income2).getIncomeAmount());

    }
}
