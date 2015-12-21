
package com.easybanking.entity;


/**
 * @author Glenn Benavides
 * 
 * TWO-IN-ONE-COMBO: Se trata de un combo que ofrece los siguientes cuatro productos,
 * .................. 1) Una cuenta de ahorros en una moneda(básicamente la moneda local),
 * .................. 2) Una cuenta de ahorros en una moneda extranjera (normalmente dólares),
 * .................. 3) Un bono -o regalo en efectivo- depositado en la cuenta extranjera, y
 * .................. 4) Un bono -o regalo en millas- de aumento a los puntos de la cuenta.
 * ___________________LOS CUATRO PRODUCTOS ANTERIORES SE DAN POR EL COSTO NORMAL DE ABRIR
 * ___________________SÓLO UNA CUENTA NORMAL EN MONEDA LOCAL..!
 * 
 */

public class TwoInOneCombo {
    
    BankAccount localSavings;
    BankAccount foreignSavings;

    public TwoInOneCombo() {
    }

    public TwoInOneCombo(BankAccount localSavings, BankAccount foreignSavings) {
        this.localSavings = localSavings;
        this.foreignSavings = foreignSavings;
    }

    public BankAccount getLocalSavings() {
        return localSavings;
    }

    public void setLocalSavings(BankAccount localSavings) {
        this.localSavings = localSavings;
    }

    public BankAccount getForeignSavings() {
        return foreignSavings;
    }

    public void setForeignSavings(BankAccount foreignSavings) {
        this.foreignSavings = foreignSavings;
    }


    
}
