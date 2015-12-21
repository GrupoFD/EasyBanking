
package com.easybanking.entity;

import java.util.Calendar;

/**
 * NOTA IMPORTANTE:   Para conocer las características de cada uno de los tres combos para el tipo
 *                    de cliente POPULAR (PopularFactory), ver abajo. Allí se dan detalles según el
 *                    tipo de combo.
 * 
 * @author Glenn Benavides
 */
public class PopularFactory extends ComboFactory {

    private final Currency CURRENCY_DOLLAR;
    private final Currency CURRENCY_EURO;
    private final Currency CURRENCY_COLON;
    private final double SPECIAL_COLON_BONUS;
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

    public PopularFactory() {

        CURRENCY_DOLLAR = new Currency("Dollar");
        CURRENCY_EURO = new Currency("Euro");
        CURRENCY_COLON = new Currency("Colon");
        SPECIAL_COLON_BONUS = 100000.0;
        SPECIAL_DOLLAR_BONUS = 100.0;
        SPECIAL_GIFTPOINTS_1000 = 1000;
        SPECIAL_GIFTPOINTS_500 = 500;
        SPECIAL_GIFTPOINTS_100 = 100;
        D_MAXCREDIT_REGULAR = 10000.0;
        D_MAXCREDIT_SPECIAL = D_MAXCREDIT_REGULAR * 2.0;
        D_CR_MIN_PAYMENT_REGULAR = 25.0;
        D_CR_MIN_PAYMENT_COMPANY = 100.0;
        LAST_BALANCE = 0.0;
        INTEREST_SAVINGS = 0.15;
        INTEREST_CREDIT = 0.22;
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
        String accNumber01 = account.createAccountNumber(issuer, 1); // ---> Autogenera número de cuenta
        BankAccount localAccount = new Savings(accNumber01, issuer, openingAmount, CURRENCY_COLON, personOwner, TODAY, FIVE_YEARS_FROM_TODAY, SPECIAL_GIFTPOINTS_100, INTEREST_SAVINGS, IS_ACTIVE);
        // Cuenta en euros con sus propiedades y las ventajas del combo:
        // Esta cuenta se abre con el premio de 100 dólares de parte del banco
        String accNumber02 = account.createAccountNumber(issuer, 2); // ---> Autogenera número de cuenta
        BankAccount dollarAccount = new Savings(accNumber02, issuer, SPECIAL_DOLLAR_BONUS, CURRENCY_DOLLAR, personOwner, TODAY, FIVE_YEARS_FROM_TODAY, 0, INTEREST_SAVINGS, IS_ACTIVE);
        TwoInOneCombo combo = new TwoInOneCombo();
        return combo;
    }

    @Override
    public SuperCreditCombo createSuperCredit(Bank issuer, Person personOwner) {
        // Cuenta en dólares, única del combo con trato especial incluido
        String accNumber01 = account.createAccountNumber(issuer, 4); // ---> Autogenera número de cuenta
        BankAccount dollarCredit = new Credit(D_MAXCREDIT_SPECIAL,  LAST_BALANCE,  accNumber01, issuer, D_MAXCREDIT_SPECIAL, CURRENCY_DOLLAR, personOwner, TODAY, FIVE_YEARS_FROM_TODAY, SPECIAL_GIFTPOINTS_100);
        // Combo
        SuperCreditCombo combo = new SuperCreditCombo(dollarCredit);
        return combo;
    }

    @Override
    public UseCreditAndSaveCombo createUseCreditAndSave(Bank issuer, Person personOwner, double openingAmount) {
        // Cuenta de ahorro en dólares, la que no debe usarse según el trato del combo
        String accNumber01 = account.createAccountNumber(issuer, 1); // ---> Autogenera número de cuenta
        BankAccount localAccount = new Savings(accNumber01, issuer, (SPECIAL_COLON_BONUS + openingAmount), CURRENCY_COLON, personOwner, TODAY, FIVE_YEARS_FROM_TODAY, SPECIAL_GIFTPOINTS_100, INTEREST_SAVINGS, IS_ACTIVE);
        // Cuenta de crédito en dólares, la que el cliente se compromete a usar en vez de los ahorros       
        String accNumber02 = account.createAccountNumber(issuer, 4); // ---> Autogenera número de cuenta
        BankAccount dollarCredit = new Credit(D_MAXCREDIT_SPECIAL,  LAST_BALANCE,  accNumber02, issuer, D_MAXCREDIT_SPECIAL, CURRENCY_DOLLAR, personOwner, TODAY, FIVE_YEARS_FROM_TODAY, SPECIAL_GIFTPOINTS_100);
        // Combo
        UseCreditAndSaveCombo combo = new UseCreditAndSaveCombo(localAccount, dollarCredit);
        return combo;
    }


}

/**
 *....................Propiedades de los tres combos dentro de PopularFactory
 *                    Recordar que POPULAR_FACTORY
 *                                 va dirigido a la clase popular, para clientes con recursos
 *                                 económicos limitados, pero que consuman a menudo.
 * 
 * TWO-IN-ONE-COMBO: 
 * .................. 1) Una cuenta de ahorros en una moneda local,
 * .................. 2) Una cuenta de ahorros en dólares,
 * .................. 3) Un bono -o regalo en efectivo- de 100 dólares depositado en la cuenta en dólares, y
 * .................. 4) Un bono -o regalo en millas- de 100 puntos aumento a los puntos de la cuenta en dólares.
 * 
 * SUPER-CREDIT-COMBO:   
 * .................. 1) Una cuenta de crédito en dólares,
 * .................. 2) Un regalo de 100 puntos a los puntos de la cuenta de crédito,
 * .................. 3) Una tarjeta SUPER POPULAR que aumenta el crédito AL DOBLE de lo regular
 * 
 * CREDIT-AND-SAVE-COMBO:   
 * .................. 1) Una cuenta de ahorros en moneda local (la cuenta que no se va a tocar),
 * .................. 2) Una cuenta de crédito en dólares,
 * .................. 3) Regalo en dólares depositados en cuenta de ahorro en colones (100 mil colones)
 * .................. 4) Regalo de 100 puntos en la cuenta de ahorro...
 * .................. 5) Regalo de 100 puntos en la cuenta de crédito...
 * 
 */