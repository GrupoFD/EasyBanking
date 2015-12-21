
package com.easybanking.business;

import com.easybanking.data.TransactionData;
import com.easybanking.data.TransactionDataProxy;
import com.easybanking.entity.Bank;
import com.easybanking.entity.BankAccount;
import com.easybanking.entity.Person;
import com.easybanking.entity.Transaction;
import java.util.Calendar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Glenn Benavides
 */
@ManagedBean
@RequestScoped
public class TransactionBean {

    Bank bank;
    BankAccount recipientAcc;
    BankAccount senderAcc;
    Person transactor;
    double transAmount;
    int transGiftPoints = (int)(this.transAmount * 0.01);
    String result = "";
    TransactionDataProxy trnData = new TransactionDataProxy();
    Calendar thisDate = Calendar.getInstance();

    
    public TransactionBean() {
    }

    public TransactionBean(Bank bank, BankAccount recipientAcc, BankAccount senderAcc, Person transactor, double transAmount) {
        this.bank = bank;
        this.recipientAcc = recipientAcc;
        this.senderAcc = senderAcc;
        this.transactor = transactor;
        this.transAmount = transAmount;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public BankAccount getRecipientAcc() {
        return recipientAcc;
    }

    public void setRecipientAcc(BankAccount recipientAcc) {
        this.recipientAcc = recipientAcc;
    }

    public BankAccount getSenderAcc() {
        return senderAcc;
    }

    public void setSenderAcc(BankAccount senderAcc) {
        this.senderAcc = senderAcc;
    }

    public Person getTransactor() {
        return transactor;
    }

    public void setTransactor(Person transactor) {
        this.transactor = transactor;
    }

    public double getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(double transAmount) {
        this.transAmount = transAmount;
    }
    
    
    
    public String performDeposit() {

        this.result = "";
        BankAccount account = this.recipientAcc;
        int idRecipAccNum = Integer.parseInt(account.getOwner().getId());
        int transPerson = idRecipAccNum;
        String accNumberSender = account.getId();
        String accNumberRecip = accNumberSender;
        Transaction myTrans = new Transaction(0, "Debit", thisDate, transPerson, idRecipAccNum, accNumberSender, accNumberRecip, this.transAmount);

        if (trnData.isExistingAccountInDB(accNumberSender)) {  // Si la cuenta del que envía existe
            if (trnData.performDepositInDB(account, this.transAmount) == true) { // Si logra depositar en la cuenta
                if (trnData.saveTransactionInfoInDB(myTrans)) { // Si logra guardar el registro de la transacción en la tabla Transaction
                    trnData.insertGiftPointsAcc(accNumberRecip, this.transGiftPoints); // Por fin, inserta los gift points correspondientes a la transacción
                    account.setAmountBalance(account.getAmountBalance() + getTransAmount());
                    setTransAmount(0.0);
                    this.recipientAcc = account;
                    this.result = "";
                } else {
                    this.result = "Se hizo el depósito, pero no se pudo guardar registro de la transacción";
                }
            } else {
                this.result = "No se pudo realizar el depósito en la cuenta indicada";
            }
        } else {
            this.result = "La cuenta receptora del depósito no existe";
        }

        return this.result;
    }
    
    public String performWithdrawal() {

        this.result = "";
        BankAccount accountWithdr = this.recipientAcc;  // ---> Cuenta a la que se le resta la cantidad
        int idRecipAccNum = Integer.parseInt(accountWithdr.getOwner().getId());
        int transPerson = idRecipAccNum;
        String accNumberWithdr = accountWithdr.getId();
        double withdrawalAmount = this.transAmount * (-1);

        Transaction myTrans = new Transaction(0, "Debit", thisDate, transPerson, idRecipAccNum, accNumberWithdr, accNumberWithdr, withdrawalAmount);

        if (trnData.isExistingAccountInDB(accNumberWithdr)) {   // Si la cuenta existe,
            if (this.transAmount <= trnData.verifyAccBalance(accNumberWithdr)) {  // Si el balance de la cuenta es mayor o igual al monto de la transacción
                if (trnData.performDepositInDB(accountWithdr, withdrawalAmount) == true) { // Si logra insertar en la cuenta la suma en negativo
                    if (trnData.saveTransactionInfoInDB(myTrans)) { // Si, después, logra insertar los datos en la tabla Transaction
                        trnData.insertGiftPointsAcc(accNumberWithdr, this.transGiftPoints); // Por fin, inserta los gift points correspondientes a la transacción
                        accountWithdr.setAmountBalance(accountWithdr.getAmountBalance() + withdrawalAmount);
                        setTransAmount(0.0);
                        this.recipientAcc = accountWithdr;
                        this.result = "";
                    } else {
                        this.result = "Se hizo el retiro, pero no se pudo guardar registro de la transacción";
                    }
                } else {
                    this.result = "No se pudo realizar el retiro de la cuenta indicada";
                }
            } else {
                this.result = "El monto de retiro indicado supera el saldo de la cuenta";
            }
        } else {
            this.result = "La cuenta indicada para el retiro no existe";
        }

        return this.result;
    }
        
    public String performTransfer() {

        this.result = "";
        BankAccount accountSender = this.senderAcc;    // -- > Cuenta que envía    
        BankAccount accountRecip = this.recipientAcc;   // -- > Cuenta que recibe
        int transPerson = Integer.parseInt(accountSender.getOwner().getId());  // -- > Persona que envía
        int idRecipAccNum = Integer.parseInt(accountRecip.getOwner().getId());  // -- > Persona que recibe
        String accNumberSender = accountRecip.getId(); // -- > Id de cuenta que envía
        String accNumberRecip = accountSender.getId(); // -- > Id de cuenta que recibe
        Transaction myTrans = new Transaction(0, "Debit", thisDate, transPerson, idRecipAccNum, accNumberSender, accNumberRecip, this.transAmount);

        if (trnData.isExistingAccountInDB(accNumberSender)) { // Si la cuenta del que envía existe
            if (trnData.isExistingAccountInDB(accNumberRecip)) { // Si la cuenta del que recibe existe
                if (accountSender.getAmountBalance() >= trnData.verifyAccBalance(accountSender.getId())) { // Si la cuenta del que envía tiene suficientes fondos
                    if ((trnData.performDepositInDB(accountSender, (this.transAmount * -1)) == true) && (trnData.performDepositInDB(accountRecip, this.transAmount) == true)) { // Si se logra restar el dinero al la cuenta que hace el envío y si logra hacer el depósito en la cuenta del beneficiario
                        if (trnData.saveTransactionInfoInDB(myTrans)) { // Si se logra guardar el registro en la tabla Transaction
                            trnData.insertGiftPointsAcc(accNumberSender, this.transGiftPoints); // Por fin, inserta los gift points correspondientes a la transacción
                            accountSender.setAmountBalance(accountSender.getAmountBalance() - this.transAmount);
                            accountRecip.setAmountBalance(accountRecip.getAmountBalance() + this.transAmount);
                            setTransAmount(0.0);
                            this.senderAcc = accountSender;
                            this.recipientAcc = accountRecip;
                            this.result = "";
                        } else {
                            this.result = "Se hizo la tranferencia, pero no se pudo guardar registro de la transacción";
                        }
                    } else {
                        this.result = "No se ha podido hacer la transferencia";
                    }
                } else {
                    this.result = "La cuenta que envía no tiene suficientes fondos";
                }
            } else {
                this.result = "La cuenta que recibe la transferencia no existe";
            }
        } else {
            this.result = "La cuenta que realiza la transferencia no existe";
        }

        return this.result;
    }
    
    
    public String executeLoan(){
        
        this.result = "";
        BankAccount accountCredit = this.recipientAcc;  // ---> Cuenta de crédito de la transacción
        int idCreditUser = Integer.parseInt(accountCredit.getOwner().getId());
        String creditAccNumber = accountCredit.getId();
        double loanAmount = this.transAmount * (-1);

        Transaction myTrans = new Transaction(0, "Credit", thisDate, idCreditUser, idCreditUser, creditAccNumber, creditAccNumber, loanAmount);


        if (trnData.isExistingAccountInDB(creditAccNumber)) {   // Si la cuenta existe,
            if (this.transAmount <= trnData.verifyCreditMaxLoan(creditAccNumber)) {  // Si el monto que se pide prestado es menor o igual al máximo de crédito total
                if (trnData.performDepositInDB(accountCredit, loanAmount) == true) { // Si logra insertar la cantidad en negativo (o sea si logra sacar el préstamo)
                    if (trnData.saveTransactionInfoInDB(myTrans)) { // Si, después, logra insertar los datos en la tabla Transaction
                        trnData.insertGiftPointsAcc(creditAccNumber, this.transGiftPoints); // Por fin, inserta los gift points correspondientes a la transacción
                        accountCredit.setAmountBalance(accountCredit.getAmountBalance() + loanAmount);
                        setTransAmount(0.0);
                        this.recipientAcc = accountCredit;
                        this.result = "";
                    } else {
                        this.result = "Se completó el préstamo, pero no se pudo guardar registro de la transacción";
                    }
                } else {
                    this.result = "No se pudo obtener el préstamo de parte de la cuenta indicada";
                }
            } else {
                this.result = "El monto solicitado es mayor al máximo permitido";
            }
        } else {
            this.result = "La cuenta de crédito indicada no existe";
        }
        
      return this.result;
    }
    
        
    public String executePayment(){
    
        this.result = "";
        BankAccount accountCredit = this.recipientAcc;  // ---> Cuenta de crédito de la transacción
        int idCreditUser = Integer.parseInt(accountCredit.getOwner().getId());
        String creditAccNumber = accountCredit.getId();
        double paymentToLoan = this.transAmount;

        Transaction myTrans = new Transaction(0, "Credit", thisDate, idCreditUser, idCreditUser, creditAccNumber, creditAccNumber, paymentToLoan);


        if (trnData.isExistingAccountInDB(creditAccNumber)) {   // Si la cuenta existe,
            if (this.transAmount >= trnData.verifyCreditMinPayment(creditAccNumber)) {  // Si el monto del abono es mayor o igual al mínimo permitido
                if (trnData.performDepositInDB(accountCredit, paymentToLoan) == true) { // Si logra insertar el pago a la cuenta (o sea si logra depositar en positivo)
                    if (trnData.saveTransactionInfoInDB(myTrans)) { // Si, después, logra insertar los datos en la tabla Transaction
                        trnData.insertGiftPointsAcc(creditAccNumber, this.transGiftPoints); // Por fin, inserta los gift points correspondientes a la transacción
                        accountCredit.setAmountBalance(accountCredit.getAmountBalance() + paymentToLoan);
                        setTransAmount(0.0);
                        this.recipientAcc = accountCredit;
                        this.result = "";
                    } else {
                        this.result = "Se completó el abono, pero no se pudo guardar registro de la transacción";
                    }
                } else {
                    this.result = "No se pudo realizar el abono a la cuenta indicada";
                }
            } else {
                this.result = "El monto del abono es menor al mínimo permitido";
            }
        } else {
            this.result = "La cuenta de crédito indicada no existe";
        }
        
      return this.result;
    }
    
        

    
    
}
