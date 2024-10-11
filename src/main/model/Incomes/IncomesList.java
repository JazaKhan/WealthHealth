package model.Incomes;

import java.util.ArrayList;
import java.util.List;

//Represents a list of incomes with titles and amounts (in Dollars).
public class IncomesList {
    private List<Income> incomes;

    // EFFECTS: Initializes an empty list of incomes.
    public IncomesList() {
        incomes = new ArrayList<Income>();
    }

    // MODIFIES: this
    // EFFECTS: An income with a title and an amount (in Dollars) is added to the
    // list of incomes.
    public void addIncome(Income income) {
        this.incomes.add(income);
    }

    // REQUIRES: IncomesList.size() > 0
    // MODIFIES: this
    // EFFECTS: An income of the user's choice is removed from the list.
    public void removeIncome(Income income) {
        this.incomes.remove(income);
    }

    // REQUIRES: IncomesList.size() > 0
    // MODIFIES: this
    // EFFECTS: An income of user's choice is updated by name.
    public void modifyIncomeName(Income income, String updateIncomeName) {
        income.setIncomeName(updateIncomeName);
    }

    // REQUIRES: IncomesList.size() > 0
    // MODIFIES: this
    // EFFECTS: An income of user's choice is updated by amount.
    public void modifyIncomeAmount(Income income, int updateIncomeAmount) {
        income.setIncomeAmount(updateIncomeAmount);
    }

    // REQUIRES: IncomesList.size() > 0
    // EFFECTS: Returns true if IncomesList contains the given income, and false
    // if it does not.
    public boolean contains(Income income) {
        if (incomes.contains(income)) {
            return true;
        } else {
            return false;
        }
    }

    // REQUIRES: IncomesList.size() > 0
    // EFFECTS: The list of incomes is returned to the user to view.
    public String viewIncomesList() {
        return null;
    }

    public Income getIncome(Income income) {
        return income;
    }
}
