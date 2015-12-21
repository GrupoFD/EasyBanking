
package com.easybanking.proxy;

import com.easybanking.entity.BankAccount;
import com.easybanking.entity.Transaction;

/**
 *
 * @author Glenn Benavides
 */
public interface InterfaceTRANSACTION {

    public double verifyAccBalance(String id);

    public boolean performDepositInDB(BankAccount account, double transAmount);

    public boolean saveTransactionInfoInDB(Transaction myTrans);

    public boolean isExistingAccountInDB(String accNumberSender);

    public void insertGiftPointsAcc(String accNumberRecip, int transGiftPoints);

    public double verifyCreditMinPayment(String creditAccNumber);

    public double verifyCreditMaxLoan(String creditAccNumber);

}
