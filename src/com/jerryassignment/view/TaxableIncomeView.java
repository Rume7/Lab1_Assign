package com.jerryassignment.view;

import javax.swing.JOptionPane;

/**
 *
 * @author Jerry
 */
public class TaxableIncomeView {

    public double createTaxableIncomeView() {
        String title = "Taxable Income ";
        String incomeEntered = JOptionPane.
                showInputDialog(null, title, "Input", JOptionPane.QUESTION_MESSAGE);

        while (!verifyIncomeAmount(incomeEntered)) {
            incomeEntered
                    = JOptionPane.showInputDialog(null, title, "Input", JOptionPane.QUESTION_MESSAGE);
        }
        double taxableIncome = Double.parseDouble(incomeEntered);
        return taxableIncome;
    }

    private boolean verifyIncomeAmount(String incomeAmount) {
        try {
            double income = Double.parseDouble(incomeAmount);
            if (income < 0) {
                return false;
            }
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }
}