
package com.easybanking.entity;
import com.easybanking.entity.BankAccount;
import com.easybanking.entity.Credit;
import com.easybanking.entity.Person;
import com.easybanking.entity.Savings;
import java.util.Calendar;

/**
 * NOTA IMPORTANTE:   Para conocer las características de cada uno de los tres combos para el tipo
 *                    de cliente COMPANY o sea EMPRESA (CompanyFactory), ver abajo. Allí se dan detalles según el
 *                    tipo de combo.
 * 
 *  public Credit(double maxCredit, double minPayment, double lastBalance, boolean isGoodForLoan, String id, Bank issuer, double amountBalance, Currency currency, Person owner, Calendar creationDate, Calendar expirationDate, int giftPoints) 
 *  public Savings(String id, Bank issuer, double amountBalance, Currency currency, Person owner, Calendar creationDate, Calendar expirationDate, int giftPoints, double interest, boolean isActive)
 * @author Glenn Benavides
 */
public class CompanyFactory extends ComboFactory {

    private final Currency CURRENCY_DOLLAR;
    private final Currency CURRENCY_EURO;
    private final Currency CURRENCY_COLON;
    private final double SPECIAL_EURO_BONUS;
    private final double SPECIAL_DOLLAR_BONUS;
    private final int SPECIAL_GIFTPOINTS_1000;
    private final int SPECIAL_GIFTPOINTS_500;
    private final int SPECIAL_GIFTPOINTS_100;
    private final double D_MAXCREDIT_REGULAR;
    private final double D_MAXCREDIT_COMPANY;
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

    public CompanyFactory(){
    
        CURRENCY_DOLLAR = new Currency("Dollar");
        CURRENCY_EURO = new Currency("Euro");
        CURRENCY_COLON = new Currency("Colon");
        SPECIAL_EURO_BONUS = 400.0;
        SPECIAL_DOLLAR_BONUS = 1000.0;
        SPECIAL_GIFTPOINTS_1000 = 1000;
        SPECIAL_GIFTPOINTS_500 = 500;
        SPECIAL_GIFTPOINTS_100 = 100;
        D_MAXCREDIT_REGULAR = 10000.0;
        D_MAXCREDIT_COMPANY = D_MAXCREDIT_REGULAR * 10.0;
        D_CR_MIN_PAYMENT_REGULAR = 100.0;
        D_CR_MIN_PAYMENT_COMPANY = 500.0;
        LAST_BALANCE = 0.0;
        INTEREST_SAVINGS = 0.12;
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
        String accNumber01 = account.createAccountNumber(issuer, 2); // ---> Autogenera número de cuenta
        BankAccount dollarAccount = new Savings(accNumber01, issuer, openingAmount, CURRENCY_DOLLAR, personOwner, TODAY, FIVE_YEARS_FROM_TODAY, SPECIAL_GIFTPOINTS_1000, INTEREST_SAVINGS, IS_ACTIVE);    
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
        String accNumber01 = account.createAccountNumber(issuer, 5); // ---> Autogenera número de cuenta
        BankAccount dollarCredit = new Credit(D_MAXCREDIT_COMPANY, LAST_BALANCE, accNumber01, issuer, D_MAXCREDIT_COMPANY, CURRENCY_DOLLAR, personOwner, TODAY, FIVE_YEARS_FROM_TODAY, SPECIAL_GIFTPOINTS_500);
        // Combo con las cuenta especial de crédito ya completa
        SuperCreditCombo combo = new SuperCreditCombo(dollarCredit);
        return combo;
    }

    @Override
    public UseCreditAndSaveCombo createUseCreditAndSave(Bank issuer, Person personOwner, double openingAmount) {
         // Cuenta de ahorro en dólares, la que no debe usarse según el trato del combo
        String accNumber01 = account.createAccountNumber(issuer, 2); // ---> Autogenera número de cuenta
        BankAccount dollarAccount = new Savings(accNumber01, issuer, (SPECIAL_DOLLAR_BONUS + openingAmount), CURRENCY_DOLLAR, personOwner, TODAY, FIVE_YEARS_FROM_TODAY, SPECIAL_GIFTPOINTS_500, INTEREST_SAVINGS, IS_ACTIVE);       
         // Cuenta de crédito en euros, la que el cliente se compromete a usar en vez de usar sus ahorros       
        String accNumber02 = account.createAccountNumber(issuer, 6); // ---> Autogenera número de cuenta
        BankAccount euroEuroCredit = new Credit(D_MAXCREDIT_COMPANY, LAST_BALANCE, accNumber02, issuer, D_MAXCREDIT_COMPANY, CURRENCY_EURO, personOwner, TODAY, FIVE_YEARS_FROM_TODAY, SPECIAL_GIFTPOINTS_100);
         // Combo
	UseCreditAndSaveCombo combo = new UseCreditAndSaveCombo(dollarAccount, euroEuroCredit);	
	return combo;
    }
    
}


/**
 *....................Propiedades de los tres combos dentro de CompanyFactory
 *                    Recordar que COMPANY_FACTORY
 *                                 va dirigido a la clase social EMPRESARIAL.
 *                                 Es para cliente de tipo PERSONA JURÍDICA o para el responsable de
 *                                 una persona jurídica.
 * 
 * TWO-IN-ONE-COMBO: 
 * .................. 1) Una cuenta de ahorros en dólares,
 * .................. 2) Una cuenta de ahorros en euros,
 * .................. 3) Un bono -o regalo en efectivo- depositado en la cuenta en dólares: 400 dólares
 * .................. 4) Un bono -o regalo en millas- de aumento a los puntos de la cuenta en dólares: 1000 millas:
 * 
 * SUPER-CREDIT-COMBO:   
 * .................. 1) Una cuenta de crédito en dólares,
 * .................. 2) Un bono de puntos de 500 puntos,
 * .................. 3) Una tarjeta tipo GOLD CARD que aumenta el crédito de la tarjeta a 100.000 dolares para nivel EMPRESARIAL_Ejecutivo
 * 
 * CREDIT-AND-SAVE-COMBO:   
 * .................. 1) Una cuenta de ahorros en dólares (la que no se va a tocar),
 * .................. 2) Una cuenta de crédito en euros (la que se va a usar preferentemente),
 * .................. 3) Regalo en dólares depositados en cuenta de ahorro (1000 dólares)
 * .................. 4) Regalo de 500 puntos en la cuenta de ahorro...
 * .................. 5) Regalo de 100 puntos en la cuenta de crédito...
 * 
 */