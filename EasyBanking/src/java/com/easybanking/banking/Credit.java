

package com.easybanking.banking;

import java.util.Calendar;


/**
 *
 * @author Glenn 
 */
 
 
public class Credit extends BankAccount implements Interesable {
    
    private final double creditAmount = 10.000;
    private final double minimumMonthPayment = 100;
    private double loanLastBalance;
    private double remainingCreditAmount;
    private boolean hasPermissionToLoan;
    
    // Borrar los siguientes comentarios después de leer:
    // NO cambiar los finals..!!  
    // loanLastBalance guarda el saldo de la deuda, lo que todavìa se debe
    // remainingCreditAmount guarda el saldo de lìmite de crèdito, o saldo usable
    // la booleana guarda TRUE si la persona està habilitada para usar el crèdito,
    // si el cliente deja de hacer uno de sus pagos mensuales obligatorios,
    // esta booleana debe ponerse en FALSE

    public Credit() {
        hasPermissionToLoan = true;
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

//    public boolean isHasPermissionToLoan() {
//        return hasPermissionToLoan;
//    }

    public void setHasPermissionToLoan(boolean hasPermissionToLoan) {
        this.hasPermissionToLoan = hasPermissionToLoan;

    }
    
    
       public void amortizationToLoan(double paymentAmount) {
        
            if ((paymentAmount >= this.minimumMonthPayment) && (this.isHasPermissionToLoan() == true)) {
             this.setLoanLastBalance(this.getLoanLastBalance() - paymentAmount);
                this.setRemainingCreditAmount(this.getRemainingCreditAmount() + paymentAmount);
            } else {
                System.out.println("Exception");
            }
            
        }
        
        
        
        
      public void loanFromLoanBalance(double loanAmount){
            
            if (loanAmount >= this.getRemainingCreditAmount()) {
                this.setLoanLastBalance(this.getLoanLastBalance() + loanAmount);
                this.setRemainingCreditAmount(this.getRemainingCreditAmount() - loanAmount);
            } else {
                System.out.println("Exception");
            }
            
        }

    @Override
    public double getInterestRegularAccount() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public double getInterestCreditAccount() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
            
        }
       

