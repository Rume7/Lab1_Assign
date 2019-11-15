package com.assignment.view;

import javax.swing.JOptionPane;

/**
 *
 * @author Jerry
 */
public class TaxResultView {

    public void createTaxResultView(int[] statuses, double income, double[] tax) {
        
        // Case 1: Only one status inputted
        if (statuses[1] == 0 && statuses[0] != 5) {
            String info = "\nYour tax for filing status " + statuses[0] + " \nfor taxable "
                    + "Income of " + income + " Naira  is \n" + tax[0] + " Naira.\n";
            String title = "Input";
            JOptionPane.showMessageDialog(null, info, title, JOptionPane.INFORMATION_MESSAGE);
        } else if (statuses[0] == 5) {
            String taxInfo = String.format("\nTax for an income of %.2f Naira for \n", income);
            taxInfo += "__________________________________\n";
            String space = " ";
            taxInfo += String.format("Single = %24s%.2f Naira\n", space, tax[0]);
            taxInfo += String.format("Married (Joint) = %9s%.2f Naira\n", space, tax[1]);
            taxInfo += String.format("Married (Singly) = %7s%.2f Naira\n", space, tax[2]);
            taxInfo += String.format("Head of Household = %2s%.2f Naira\n", space, tax[3]);
            
            JOptionPane.showMessageDialog(null, taxInfo, "Tax Information", JOptionPane.INFORMATION_MESSAGE);
        }

        // Case 2: Two statuses inputted 
        if (statuses[1] != 0) {
            String info = "\nYour tax for filing status \n" + statuses[0] + ", " + statuses[1] + "\n" + 
                                "for taxable Income of \n" + income + " Naira is \n" + tax[0] + ", " + tax[1] + ".\n";
            String title = "Input";
            JOptionPane.showMessageDialog(null, info, title, JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
