
package com.easybanking.entity;


/**
 * @author Glenn Benavides
 * 
 * CREDIT-AND-SAVE-COMBO:   Se trata de un combo que ofrece los siguientes tres productos,
 * .................. 1) Una cuenta de ahorros en moneda local (la cuenta que no se va a tocar),
 * .................. 2) Una cuenta de crédito en moneda extranjera (normalmente dólares),
 * .................. 3) Regalo en dólares depositados en cuenta de ahorro local (100 dólares para PopularFactory)
 * .................. 4) Derecho a que le doblen o tripliquen los puntos de la moneda local una vez por mes...
 * ___________________LOS TRES PRODUCTOS ANTERIORES SE DAN POR EL COSTO NORMAL DE ABRIR
 * ___________________SÓLO UNA CUENTA DE AHORRO REGULAR, PERO CON LA CONDICIÓN DE QUE EL CLIENTE
 * ___________________SE COMPROMETE A NO-USAR EL DINERO DE SU CUENTA DE AHORRO PARA SÓLO USAR
 * ___________________DINERO CON LA CUENTA DE AHORRO..!
 * 
 */
public class UseCreditAndSaveCombo {
    
    BankAccount localSavings;
    BankAccount foreignCredit;

    public UseCreditAndSaveCombo() {
    }

    public UseCreditAndSaveCombo(BankAccount localSavings, BankAccount foreignCredit) {
        this.localSavings = localSavings;
        this.foreignCredit = foreignCredit;
    }

    public BankAccount getLocalSavings() {
        return localSavings;
    }

    public void setLocalSavings(BankAccount localSavings) {
        this.localSavings = localSavings;
    }

    public BankAccount getForeignCredit() {
        return foreignCredit;
    }

    public void setForeignCredit(BankAccount foreignCredit) {
        this.foreignCredit = foreignCredit;
    }
    
    

}