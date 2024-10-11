package model.Incomes;

import java.util.List;


//Represents a list of incomes with titles and amounts (in Dollars).
public class IncomesList {
    private List<Income> incomes;

    // EFFECTS: Initializes an empty list of incomes.
    public IncomesList() {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: An income with a title and an amount (in Dollars) is added to the
    // list of incomes.
    public void addIncome(Income income) {
        // stub
    }

    // REQUIRES: IncomesList.size() > 0
    // MODIFIES: this
    // EFFECTS: An income of the user's choice is removed from the list.
    public void removeIncome(Income income) {
        // stub
    }

    // REQUIRES: IncomesList.size() > 0
    // MODIFIES: this
    // EFFECTS: An income of user's choice is updated by name.
    public void modifyIncomeName(Income income, String updateIncomeName) {
        // stub
    }

    // REQUIRES: IncomesList.size() > 0
    // MODIFIES: this
    // EFFECTS: An income of user's choice is updated by amount.
    public void modifyIncomeAmount(Income income, int updateIncomeAmount) {
        // stub
    }
    
    // REQUIRES: IncomesList.size() > 0
    // EFFECTS: Returns true if IncomesList contains the given income, and false
    // if it does not.
    public boolean contains(Income income) {
        return false;
    }

    // REQUIRES: IncomesList.size() > 0
    // EFFECTS: The list of incomes is returned to the user to view.
    public String viewIncomesList() {
        return null;
    }

    public Income getIncome(Income income) {
        return null;
    }
}
