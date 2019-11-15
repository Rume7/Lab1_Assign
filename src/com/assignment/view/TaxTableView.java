package com.assignment.view;

import javax.swing.JOptionPane;

/**
 *
 * @author Rhume
 */
public class TaxTableView {

    private static int[] marginalTaxRate = {10, 15, 20, 30, 34, 38};
    private static String[] single = {"0 - 25,000", "25,001 - 135,000", "135,001 - 380,000", "380,001 - 650,000", "650,001 - 1,200,00", "1,200,001+"};
    private static String[] jointlyMarried = {"0 - 50,000", "50,001 - 265,000", "265,001 - 520,000", "520,001 - 800,000", "800,001 - 1,200,000", "1,200,001+"};
    private static String[] separatelyMarried = {"0 - 25,000", "25,001 - 135,000", "135,001 - 330,000", "330,001 - 600,000", "600,001 - 1,000,000", "1,000,001+"};
    private static String[] headOfHousehold = {"0 - 35,000", "35,001 - 165,000", "165,001 - 420,000", "420,001 - 700,000", "700,001 - 1,200,000", "1,200,001+"};

    private TaxTableView() {
    }

    public static void getTaxTableInstance() {

        String line1 = "\n_________________________________________________________________________________________\n";
        String headingLine1 = "Marginal      Single                   Married filing Jointly or          Married filing             Head of Household\n";
        String headingLine2 = "Tax Rate                                     Qualified Widow(er)                Separately                     \n";
        String line2 = "__________________________________________________________________________________\n";

        // format the table
        String ans = String.format("%5d%-9s%-33s%-33s%-35s%-25s\n", marginalTaxRate[0], "%", single[0], 
                    jointlyMarried[0], separatelyMarried[0], headOfHousehold[0]);
        for (int index = 1; index < single.length-1; index++) {
            ans += String.format("%5d%-8s%-24s%-26s%-30s%-25s\n", marginalTaxRate[index], "%", single[index], 
                    jointlyMarried[index], separatelyMarried[index], headOfHousehold[index]);
        }
        int len = single.length-1;
        ans += String.format("%5d%-9s%-33s%-33s%-35s%-25s\n", marginalTaxRate[len], "%", single[len], 
                    jointlyMarried[len], separatelyMarried[len], headOfHousehold[len]);
        
        // Concatenating parts to form the table
        String table = line1 + headingLine1 + headingLine2+ line2 + ans;
        
        JOptionPane.showMessageDialog(null, table, "Personal Income Tax Table", JOptionPane.INFORMATION_MESSAGE);
    }
}
