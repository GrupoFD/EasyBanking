package com.easybanking.entity;

import java.util.ArrayList;
import java.util.Calendar;
import javax.transaction.Transaction;

/**
 *
 * @author Glenn
 */
public class BankAccount implements AvailableCurrencies {

    private String id;
    private Currency currency;
    private double amountBalance;
    private ArrayList<Transaction> listOfTransactions = new ArrayList<>();
    private int giftPoints;
    private Calendar creationDate;
    private Calendar expirationDate;

    public BankAccount() {
    }

    public BankAccount(String id, Currency currency, double amountBalance, Calendar creationDate, Calendar expirationDate) {
        this.id = id;
        this.currency = currency;
        this.amountBalance = amountBalance;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amountBalance;
    }

    public void setAmount(double amountBalance) {
        this.amountBalance = amountBalance;
    }

    public ArrayList<Transaction> getListOfTransactions() {
        return listOfTransactions;
    }

    public void setListOfTransactions(ArrayList<Transaction> listOfTransactions) {
        this.listOfTransactions = listOfTransactions;
    }

    public Calendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    public Calendar getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Calendar expirationDate) {
        this.expirationDate = expirationDate;
    }

//    public String createNewAccountNumber(String typeOfAccount) {
//
//        UserData ud = new UserData();
//        Bank bank = ud.bank;
//        String newIdNumber = "";
//        String lastIdCheck = "";
//        String lastNumberString = "";
//        int lastNumberInt = 0;
//        int lastBiggestNumber = 0;
//
//        switch (typeOfAccount) {
//            case "colon":
//                newIdNumber = "100-"; // New Colon Account
//                break;
//            case "dolar":
//                newIdNumber = "200-"; // New Dollar Account
//                break;
//            case "euro":
//                newIdNumber = "300-"; // New Euro Account 
//                break;
//            case "credito":
//                newIdNumber = "400-"; // New Dollar Account 
//                break;
//        }
//
//        for (Person p : bank.getListOfPersons()) {
//            for (BankAccount b : p.getListOfBankAccounts()) {
//                lastIdCheck = b.getId();
//                lastNumberString = lastIdCheck.substring(4, 10);
//                lastNumberInt = Integer.parseInt(lastNumberString);
//                if (lastNumberInt > lastBiggestNumber) {
//                    lastBiggestNumber = lastNumberInt;
//                }
//            }
//        }
//
//        if (lastBiggestNumber < 9) {
//            newIdNumber += "00000" + String.valueOf(lastBiggestNumber + 1);
//        } else if (lastBiggestNumber >= 9 && lastBiggestNumber < 99) {
//            newIdNumber += "0000" + String.valueOf(lastBiggestNumber + 1);
//        } else if (lastBiggestNumber >= 99 && lastBiggestNumber < 1000) {
//            newIdNumber += "000" + String.valueOf(lastBiggestNumber + 1);
//        }
//
//        return newIdNumber;
//    }

    public String currencyFormat(int currency) {

        String c = "";

        switch (currency) {

            case 1:
                c = "Colones";
                break;
            case 2:
                c = "Dolares";
                break;

            case 3:
                c = "Euros";
                break;

            case 4:
                c = "Dolares";
                break;

        }
        return c;
    }

        public Calendar expirationDate() {

        Calendar myCalendar = Calendar.getInstance();

        int thisMonth = myCalendar.get(Calendar.MONTH);
        int thisDay = myCalendar.get(Calendar.DAY_OF_MONTH);
        int yearAgo = myCalendar.get(Calendar.YEAR);
        int expirationYear = yearAgo + 2;

        myCalendar.set(expirationYear, thisMonth, thisDay);

        return myCalendar;
    }

    
    public int currencyToInt(String currencyString) {

        int currencyInt = 0;

        if (currencyString.equals("dolar")) {
            currencyInt = 2;
        } else if (currencyString.equals("colon")) {
            currencyInt = 1;
        } else if (currencyString.equals("euro")) {
            currencyInt = 3;
        } else if (currencyString.equals("credito")) {
            currencyInt = 4;
        }
        return currencyInt;
    }

    @Override
    public String toString() {

        return "Cuenta: " + id + ", Moneda:" + currency + ", Total: " + amountBalance + ", listOfTransactions=" + listOfTransactions + ", registeredDate=" + creationDate + ", expirationDate=" + expirationDate + '}';

    }

}
