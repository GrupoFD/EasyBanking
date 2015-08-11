

package com.easybanking.banking;

import java.util.Calendar;


/**
 *
 * @author Glenn Ismael Benavides Pérez, de San Ramón de Alajuela, originario de Desamparados de San Josè Costa Rica, Amèrica Central, Continente Americano, Hemisferio Occidental de planeta Tierra.
 */
 
 
public class Credit extends BankAccount implements Interesable {
    
    private final double creditAmount = 10.000;
    private final double minimumMonthPayment = 100;
    private double loanLastBalance;
    private double remainingCreditAmount;

    public Credit() {
    }

    public Credit(double loanLastBalance, double remainingCreditAmount) {
        this.loanLastBalance = loanLastBalance;
        this.remainingCreditAmount = remainingCreditAmount;
    }

    public double getLoanLastBalance() {
        return loanLastBalance;
    }

    public void setLoanLastBalance(double loanLastBalance) {
        this.loanLastBalance = loanLastBalance;
    }

    public double getRemainingCreditAmount() {
        return remainingCreditAmount;
    }

    public void setRemainingCreditAmount(double remainingCreditAmount) {
        this.remainingCreditAmount = remainingCreditAmount;
    }

    @Override
    public double getInterest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
