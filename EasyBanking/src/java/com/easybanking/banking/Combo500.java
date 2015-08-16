/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.banking;

/**
 *
 * @author Glenn Benavides
 */
public class Combo500 extends Combos {
    
    private final double GIFT_100DOLLARS;
    // El COMBO500 le regala una cuenta en dólares con un saldo de 
    // 100 dolares, cuando se complete por primera vez 500 transacciones..!!!
    // Para aplicar este combo, se debe llamar al método llamado
    // applyCombo500_ifItIsTheCase() enviándole por parámetro la
    // la cuenta de banco en sí, y también enviándole una cuenta
    // nueva en dólares (la del regalo, con los datos de la persona
    // ya completos.!!  El método se encarga de insertar los primeros 500 dólares en la cuenta...

    public Combo500() {
        this.GIFT_100DOLLARS = 100.0;
    }

    public Combo500(BankAccount account_Colones, BankAccount account_Dollars, BankAccount account_Euros, BankAccount account_Credit) {
        super(account_Colones, account_Dollars, account_Euros, account_Credit);
        this.GIFT_100DOLLARS = 100.0;
    }
    
    
    
public boolean thisIsTransactionNo500(BankAccount bankAccount) {

    int counter = 0;
    boolean thisIsTransactionNo500 = false;
    
    for (Transaction t: bankAccount.getListOfTransactions()) {
        counter += 1;
    }
    
    if (counter == 1) {
        thisIsTransactionNo500 = true;
    }
    
    return thisIsTransactionNo500;
}

public void applyCombo500_ifItIsTheCase(BankAccount bankAccount, BankAccount giftAccount_Dollars) {

    if(thisIsTransactionNo500(bankAccount)) {
        this.setAccount_Dollars(giftAccount_Dollars);
        this.setDollarAccountBalance(this.getDollarAccountBalance() + GIFT_100DOLLARS);
    }

}
    
    
}
