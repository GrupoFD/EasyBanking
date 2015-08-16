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
public class Combo_saveYourMoney_UseCredit extends Combos {
    
    public final double GIFT_200DOLLARS;

    public Combo_saveYourMoney_UseCredit() {
        GIFT_200DOLLARS = 200.0;
    }

    public Combo_saveYourMoney_UseCredit(BankAccount account_Colones, BankAccount account_Dollars, BankAccount account_Euros, BankAccount account_Credit) {
        super(account_Colones, account_Dollars, account_Euros, account_Credit);
        GIFT_200DOLLARS = 200.0;
    }
    
    
    // El plan que ofrece este combo es el siguiente:
    // Ahorre todo el dinero que a usted le sobra después de pagar lo básico de su vida... y ...
    // utilice crédito para sus compras y necesidades generales..!!!
    // DEJE DE GASTAR SU DINERO..!!  GUÁRDELO Y NO LO TOQUE..!!
    // HAGA SUS GASTOS CON UNA CUENTA DE CREDITO..!!!!
    // El combo le ofrece un 2 x 1 novedoso:
    // Se le abren 2 cuentas con un trámite. Una de ahorro y otra de crédito.
    // Ambas cuentas son el dólares.
    // LA IDEA FUNCIONA ASÍ:
    // El cliente recibe una cuenta de crédito, con 10.000 dólares de crédito,
    // y un regalo de 200 dólares a la cuenta de ahorro, si cumple con el compromiso
    // siguiente: NUNCA HARÁ RETIROS DE LA CUENTA DE AHORRO, Y TODO LO QUE DESEE
    // RETIRAR... O CUALQUIER DINERO QUE NECESITE... LO SACARÁ DE LA CUENTA DE
    // CRÉDITO...!!!
    // Si el cliente hace algún retiro de su cuenta de ahorros, perderá el derecho
    // a usar el crédito de su cuenta de crédito..!!

    public double getGIFT_200DOLLARS() {
        return GIFT_200DOLLARS;
    }
    
    public void createTwoAccounts(BankAccount accountOnlySavings_Dollars, BankAccount creditGiftAccount) {
    
        this.setAccount_Dollars(accountOnlySavings_Dollars);
        this.setAccount_Credit(creditGiftAccount);
        this.setDollarAccountBalance(this.getDollarAccountBalance() + this.GIFT_200DOLLARS);
    
    }
    
    
}
