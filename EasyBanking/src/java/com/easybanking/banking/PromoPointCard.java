/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.banking;

import com.easybanking.banking.BankAccount;
import com.easybanking.banking.Transaction;
import com.easybanking.banking.Transfer;
/**
 *
 * @author Glenn Benavides
 */
public class PromoPointCard extends Promos {
    

    public PromoPointCard() {
    }
    
    // Esta promo funciona como una tarjeta de acumular puntos.
    // Le da puntos al cliente que, teniendo una cuenta en dólares, le paga al banco
    // una cuota de 2 dólares por transferencia la cuenta en dólares del banco (hay que crearla)...
    // El cliente que haya pagado los dos dólares al banco, se hace acreedor de la oferta o promoción..!!
    // El banco, dentro de la promo, le regala un monto inicial de 10 puntos. Despuès, 
    // le regala 1 punto por cada 10 dólares que mueva en cualquier tipo
    // de transacción bancaria en dólares...
    // El cliente puede cambiar sus puntos por entradas al cine (10 puntos = 2 entradas)


    public PromoPointCard(BankAccount account_Dollars) {
        super(account_Dollars);
    }
    
    public boolean hasPayed2dollarsToBank (BankAccount bankAccount) {
        
        boolean the2DollarsArePaidToBank = false;
        for (Transaction t: bankAccount.getListOfTransactions()) {
            Transfer tran = new Transfer();
            tran = (Transfer) t;
            
            if (tran.getBeneficiaryOfTransaction().equals("Bank")) {
                the2DollarsArePaidToBank = true;
            }
        }
        
        return the2DollarsArePaidToBank;
    }
    
    public int accumulatedPointCounter(BankAccount bankAccount) {

        double totalAmountOfTransactions = 0.0;
        int pointsAccumulated = 10;

        if (hasPayed2dollarsToBank(bankAccount)) {
            for (Transaction t : bankAccount.getListOfTransactions()) {
                totalAmountOfTransactions += t.getAmountOfTransaction();
            }
        } else {
            System.out.println("You have not paid the promo fee to Bank");
        }
        
        pointsAccumulated = (int)(totalAmountOfTransactions / 10);
        

        return pointsAccumulated;
    }
    
    
}
