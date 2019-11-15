package com.assignment.status;

/**
 *
 * @author Jerry
 */
public class PayableTax {
    
    private double taxableIncome;

    public PayableTax(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    public void getPayableTaxList() {
    
    }

    @Override
    public String toString() {
        return "PayableTax = " ;
    }   
}
