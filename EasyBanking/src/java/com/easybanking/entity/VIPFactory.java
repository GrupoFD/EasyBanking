
package com.easybanking.entity;

import com.easybanking.entity.BankAccount;
import com.easybanking.entity.Credit;
import com.easybanking.entity.Person;
import com.easybanking.entity.Savings;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * NOTA IMPORTANTE:   Para conocer las características de cada uno de los tres combos para el tipo
 *                    de cliente VIP (VIPFactory), ver abajo. Allí se dan detalles según el
 *                    tipo de combo.
 * 
 * @author Glenn Benavides
 */
public class VIPFactory extends ComboFactory {
    
    private final Currency CURRENCY_DOLLAR;
    private final Currency CURRENCY_EURO;
    private final Currency CURRENCY_COLON;
    private final double SPECIAL_EURO_BONUS;
    private final double SPECIAL_DOLLAR_BONUS;
    private final int SPECIAL_GIFTPOINTS_1000;
    private final int SPECIAL_GIFTPOINTS_500;
    private final int SPECIAL_GIFTPOINTS_100;
    private final double D_MAXCREDIT_REGULAR;
    private final double D_MAXCREDIT_SPECIAL;
    private final double D_CR_MIN_PAYMENT_REGULAR;
    private final double D_CR_MIN_PAYMENT_COMPANY;
    private final double LAST_BALANCE;
    private final double INTEREST_SAVINGS;
    private final double INTEREST_CREDIT;
    private final boolean IS_ACTIVE;
    private final boolean ISGOOD_FORLOAN;
    private final Calendar TODAY;
    private final Calendar FIVE_YEARS_FROM_TODAY;
    private BankAccount account;
    
    public VIPFactory(){
    
        CURRENCY_DOLLAR = new Currency("Dollar");
        CURRENCY_EURO = new Currency("Euro");
        CURRENCY_COLON = new Currency("Colon");
        SPECIAL_EURO_BONUS = 200.0;
        SPECIAL_DOLLAR_BONUS = 400.0;
        SPECIAL_GIFTPOINTS_1000 = 1000;
        SPECIAL_GIFTPOINTS_500 = 500;
        SPECIAL_GIFTPOINTS_100 = 100;
        D_MAXCREDIT_REGULAR = 10000.0;
        D_MAXCREDIT_SPECIAL = D_MAXCREDIT_REGULAR * 4.0;
        D_CR_MIN_PAYMENT_REGULAR = 50.0;
        D_CR_MIN_PAYMENT_COMPANY = 200.0;
        LAST_BALANCE = 0.0;
        INTEREST_SAVINGS = 0.10;
        INTEREST_CREDIT = 0.20;
        IS_ACTIVE = true;
        ISGOOD_FORLOAN = true;
        TODAY = Calendar.getInstance();
        Calendar fiveYearLater = Calendar.getInstance();
        fiveYearLater.add(Calendar.YEAR, -5);
        FIVE_YEARS_FROM_TODAY = fiveYearLater;
        account = new BankAccount();
        
    }

    
    @Override
    public TwoInOneCombo createTwoInOne(Bank issuer, Person personOwner, double openingAmount) {
        // Cuenta en dólares con sus propiedades y las ventajas del combo:
        // Esta cuenta se abre con la cantidad que aporta el cliente
        String accNumber01 = account.createAccountNumber(issuer, 2); // ---> Autogenera número de cuenta
        BankAccount dollarAccount = new Savings(accNumber01, issuer, openingAmount, CURRENCY_DOLLAR, personOwner, TODAY, FIVE_YEARS_FROM_TODAY, SPECIAL_GIFTPOINTS_500, INTEREST_SAVINGS, IS_ACTIVE);    
        // Cuenta en euros con sus propiedades y las ventajas del combo:
        // Esta cuenta se abre con el premio de 400 euros de parte del banco
        String accNumber02 = account.createAccountNumber(issuer, 3); // ---> Autogenera número de cuenta
        BankAccount euroAccount = new Savings(accNumber02, issuer, SPECIAL_EURO_BONUS, CURRENCY_EURO, personOwner, TODAY, FIVE_YEARS_FROM_TODAY, 0, INTEREST_SAVINGS, IS_ACTIVE);
        // Combo con las dos cuentas completas
        TwoInOneCombo combo = new TwoInOneCombo(dollarAccount, euroAccount);
        return combo;
    }

    @Override
    public SuperCreditCombo createSuperCredit(Bank issuer, Person personOwner) {
        // Cuenta de crédito en dólares, única cuenta del combo:
        String accNumber01 = account.createAccountNumber(issuer, 4); // ---> Autogenera número de cuenta
        BankAccount dollarCredit = new Credit(D_MAXCREDIT_SPECIAL,  LAST_BALANCE, accNumber01, issuer, D_MAXCREDIT_SPECIAL, CURRENCY_DOLLAR, personOwner, TODAY, FIVE_YEARS_FROM_TODAY, SPECIAL_GIFTPOINTS_500);
        // Combo con las cuenta especial de crédito ya completa
        SuperCreditCombo combo = new SuperCreditCombo(dollarCredit);
        return combo;
    }

    @Override
    public UseCreditAndSaveCombo createUseCreditAndSave(Bank issuer, Person personOwner, double openingAmount) {
         // Cuenta de ahorro en dólares, la que no debe usarse según el trato del combo
        String accNumber01 = account.createAccountNumber(issuer, 2); // ---> Autogenera número de cuenta
        BankAccount dollarAccount = new Savings(accNumber01, issuer, (SPECIAL_DOLLAR_BONUS + openingAmount), CURRENCY_DOLLAR, personOwner, TODAY, FIVE_YEARS_FROM_TODAY, 0, INTEREST_SAVINGS, IS_ACTIVE);       
         // Cuenta de crédito en euros, la que el cliente se compromete a usar en vez de usar sus ahorros       
        String accNumber02 = account.createAccountNumber(issuer, 6); // ---> Autogenera número de cuenta
        BankAccount euroEuroCredit = new Credit(D_MAXCREDIT_SPECIAL,  LAST_BALANCE, accNumber02, issuer, D_MAXCREDIT_SPECIAL, CURRENCY_EURO, personOwner, TODAY, FIVE_YEARS_FROM_TODAY, SPECIAL_GIFTPOINTS_500);
         // Combo
	UseCreditAndSaveCombo combo = new UseCreditAndSaveCombo(dollarAccount, euroEuroCredit);	
	return combo;
    }
    
}

/**
 *....................Propiedades de los tres combos dentro de VIPFactory
 *                    Recordar que VIP_FACTORY
 *                                 va dirigido a la clase ejecutiva y clase alta, para clientes
 *                                 con capacidad económica muy fuerte.
 * 
 * TWO-IN-ONE-COMBO: 
 * .................. 1) Una cuenta de ahorros en dólares,
 * .................. 2) Una cuenta de ahorros en euros,
 * .................. 3) Un bono -o regalo en efectivo- depositado en la cuenta en euros: 200 euros
 * .................. 4) Un bono -o regalo en millas- de aumento a los puntos de la cuenta en dólares: 500 millas:
 * 
 * SUPER-CREDIT-COMBO:   
 * .................. 1) Una cuenta de crédito en dólares,
 * .................. 2) Un regalo de 500 puntos a la cuenta de crédito en dólares
 * .................. 3) Una tarjeta tipo BLACK CARD que aumenta el crédito 4 veces lo regular para VIP
 * 
 * CREDIT-AND-SAVE-COMBO:   
 * .................. 1) Una cuenta de ahorros en dólares (la que no se va a tocar),
 * .................. 2) Una cuenta de crédito en euros (la que se va a usar preferentemente),
 * .................. 3) Regalo en dólares depositados en cuenta de ahorro (400 dólares)
 * .................. 4) Regalo en puntos a la cuenta de crédito en euros (500 puntos)
 * 
 */