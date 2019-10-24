package com.jerryassignment.taxcalculator;

import com.jerryassignment.status.HeadOfHouseholdIncomeTax;
import com.jerryassignment.status.JointMarriedIncomeTax;
import com.jerryassignment.status.PayableTax;
import com.jerryassignment.status.SingleIncomeTax;
import com.jerryassignment.status.SinglyMarriedIncomeTax;

/**
 *
 * @author Jerry
 */
public class TaxCalculator {
    
    private double totalTax;
    private double taxableIncome;

    public TaxCalculator() {
    }
        
    public double calculator(int status, double income) {
        this.taxableIncome = income;
        switch (status) {
            case 0:
                // Output filling status
                break;
            case 1:
                SingleIncomeTax singleIncomeTax = new SingleIncomeTax(taxableIncome);
                totalTax = singleIncomeTax.computeTax();
                break;
            case 2:
                JointMarriedIncomeTax jointMarried = new JointMarriedIncomeTax(taxableIncome);
                totalTax = jointMarried.computeTax();
                break;
            case 3:
                SinglyMarriedIncomeTax singlyMarried = new SinglyMarriedIncomeTax(taxableIncome);
                totalTax = singlyMarried.computeTax();
                break;
            case 4:
                HeadOfHouseholdIncomeTax headOfHousehold = new HeadOfHouseholdIncomeTax(taxableIncome);
                totalTax = headOfHousehold.computeTax();
                break;
            case 5:
                PayableTax payableTax = new PayableTax(taxableIncome);
                payableTax.getPayableTaxList();
                break;
        }
        return totalTax;
    }    
    
    @Override
    public String toString() {
        return "Tax = " + this.totalTax;
    }
}
