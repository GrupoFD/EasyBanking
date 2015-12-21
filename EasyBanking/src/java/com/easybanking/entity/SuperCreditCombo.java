
package com.easybanking.entity;

/**
 * @author Glenn Benavides
 * 
 * SUPER-CREDIT-COMBO:   Se trata de un combo que ofrece los siguientes tres productos,
 * .................. 1) Una cuenta de crédito en moneda extranjera (dólares para clase popular),
 * .................. 2) Un paquete de tiquetes del cine como regalo,
 * .................. 3) Una tarjeta tipo GOLD CARD que aumenta el crédito de la tarjeta (más o menos, según factory)
 * ___________________LOS TRES PRODUCTOS ANTERIORES SE DAN POR EL COSTO NORMAL DE ABRIR
 * ___________________SÓLO UNA CUENTA DE CRÉDITO EN DÓLARES REGULAR..!
 * 
 */
public class SuperCreditCombo {
    
    BankAccount dollarCredit;

    public SuperCreditCombo() {
    }

    public SuperCreditCombo(BankAccount dollarCredit) {
        this.dollarCredit = dollarCredit;
    }

    public BankAccount getDollarCredit() {
        return dollarCredit;
    }

    public void setDollarCredit(BankAccount dollarCredit) {
        this.dollarCredit = dollarCredit;
    }


    
}
