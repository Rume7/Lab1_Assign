package com.assignment.view;

import com.assignment.calculator.TaxCalculator;

/**
 *
 * @author Rhume
 */
public class TaxApplication {

    public static void main(String[] args) {

        FilingStatusView statusView = new FilingStatusView();
        int[] statusesChosen = statusView.createFilingStatusView();

        TaxableIncomeView incomeView = new TaxableIncomeView();
        double income = incomeView.createTaxableIncomeView();
        
        TaxCalculator taxCalculator;
        TaxResultView taxResultView;
        
        // Handle the case when status and income is zero
        if (statusesChosen[0] == 0 && statusesChosen[1] == 0) {
            if (income < 1.0) {
                TaxTableView.getTaxTableInstance();
                return;
            } else {
                while (income > 1 && (statusesChosen[0] == 0 && statusesChosen[1] == 0)) {
                    statusView = new FilingStatusView();
                    statusesChosen = statusView.createFilingStatusView();
                }
            }
        } // Case 4: Filing status entered is type 5 and income is inputted
        else if (statusesChosen[0] == 5 && income > 0) {
            // Calculate the tax for each status and display on the screen
            taxCalculator = new TaxCalculator();
            double taxForSingle = taxCalculator.calculator(1, income);
            double taxForJointlyMarried = taxCalculator.calculator(2, income);
            double taxForSingleMarried = taxCalculator.calculator(3, income);
            double taxForHeadOfHousehold = taxCalculator.calculator(4, income);
            double[] allTaxesAccrued = {taxForSingle, taxForJointlyMarried, taxForSingleMarried, taxForHeadOfHousehold};
            taxResultView = new TaxResultView();
            taxResultView.createTaxResultView(statusesChosen, income, allTaxesAccrued);
            return ;
        }

        int status1 = statusesChosen[0];
        int status2 = statusesChosen[1];

        taxCalculator = new TaxCalculator();
        double taxAccrued1 = taxCalculator.calculator(status1, income);
        double taxAccrued2 = taxCalculator.calculator(status2, income);
        double[] allTaxes = {taxAccrued1, taxAccrued2};

        // Display the answer
        taxResultView = new TaxResultView();
        taxResultView.createTaxResultView(statusesChosen, income, allTaxes);
    }
}
