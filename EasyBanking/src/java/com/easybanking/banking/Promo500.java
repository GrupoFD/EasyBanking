/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.banking;

import com.easybanking.banking.BankAccount;
import com.easybanking.banking.Transaction;

/**
 *
 * @author Glenn Benavides
 */
public class Promo500 extends Promos {

    private final double GIFT500DOLLARS;
    // La PROMO500 le regala una cuenta en dólares con un saldo de 
    // 500 dolares, cuando se complete por primera vez 500 transacciones..!!!
    // Para aplicar este combo, se debe llamar al método llamado
    // applyPromo500() enviándole por parámetro la
    // la cuenta de banco en sí, y también enviándole una cuenta
    // nueva en dólares (la del regalo, con los datos de la persona
    // ya completos.!!  El método se encarga de insertar los primeros 500 dólares en la cuenta...

    public Promo500() {
        this.GIFT500DOLLARS = 500.0;
    }


    public Promo500(BankAccount account_Dollars) {
        super(account_Dollars);
        this.GIFT500DOLLARS = 500;
    }
    
    

    public boolean thisIsTransactionNo500(BankAccount bankAccount) {

        int counter = 0;
        boolean thisIsTransactionNo500 = false;

        for (Transaction t : bankAccount.getListOfTransactions()) {
            counter += 1;
        }

        if (counter == 1) {
            thisIsTransactionNo500 = true;
        }

        return thisIsTransactionNo500;
    }

    public void applyPromo500(BankAccount bankAccount, BankAccount giftAccountDollars) {

        if (thisIsTransactionNo500(bankAccount)) {
            giftAccountDollars.setAmount(giftAccountDollars.getAmount() + GIFT500DOLLARS);
            this.setAccount_Dollars(giftAccountDollars);
        }

    }

}
