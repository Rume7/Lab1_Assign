package com.jerryassignment.view;

import com.jerryassignment.taxcalculator.TaxCalculator;

/**
 *
 * @author Jerry
 */
public class TaxApplication {

    public static void main(String[] args) {

        FilingStatusView statusView = new FilingStatusView();
        int[] statusesChosen = statusView.createFilingStatusView();

        TaxableIncomeView incomeView = new TaxableIncomeView();
        double income = incomeView.createTaxableIncomeView();

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
        }
        int status1 = statusesChosen[0];
        int status2 = statusesChosen[1];

        TaxCalculator taxCalculator = new TaxCalculator();
        double taxAccrued1 = taxCalculator.calculator(status1, income);
        double taxAccrued2 = taxCalculator.calculator(status2, income);
        double[] allTaxes = {taxAccrued1, taxAccrued2};

        // Display the answer
        TaxResultView taxResultView = new TaxResultView();
        taxResultView.createTaxResultView(statusesChosen, income, allTaxes);
    }
}
