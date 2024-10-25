package model.incomes;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import model.persistence.Writable;

//Represents a list of incomes with titles and amounts (in Dollars).
public class IncomesList implements Writable {
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
    // EFFECTS: An income of the user's choice is removed from the list using
    // provided name, and amount.
    public void removeIncome(String name, double amount) {
        for (Income income : incomes) {
            if (income.getIncomeName().equals(name) && income.getIncomeAmount() == amount) {
                incomes.remove(income);
                break;
            }
        }
    }

    // REQUIRES: IncomesList.size() > 0
    // MODIFIES: this
    // EFFECTS: An income of user's choice is updated by name.
    public void modifyIncomeName(String name, String updateIncomeName) {
        for (Income income : incomes) {
            if (income.getIncomeName().equals(name)) {
                income.setIncomeName(updateIncomeName);
                break;
            }
        }
    }

    // REQUIRES: IncomesList.size() > 0
    // MODIFIES: this
    // EFFECTS: An income of user's choice is updated by amount.
    public void modifyIncomeAmount(double amount, double updateIncomeAmount) {
        for (Income income : incomes) {
            if (income.getIncomeAmount() == amount) {
                income.setIncomeAmount(updateIncomeAmount);
                break;
            }
        }
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
        String list = "";
        for (Income income : incomes) {
            list += income.getIncomeName() + ": " + income.getIncomeAmount() + " ";
        }
        return list;
    }

    public Income getIncome(Income income) {
        return income;
    }

    @Override
    public JSONObject toJson() {
        //stub
    }

    // EFFECTS: returns Incomes in this IncomesList as a JSON array
    private JSONArray incomesToJson() {
        //stub
    }

	public List<Income> getIncomes() {
		return incomes;
	}
}
