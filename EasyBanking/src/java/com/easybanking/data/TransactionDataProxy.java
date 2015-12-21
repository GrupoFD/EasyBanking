

package com.easybanking.data;

import com.easybanking.entity.BankAccount;
import com.easybanking.entity.Transaction;
import com.easybanking.proxy.InterfaceTRANSACTION;

/**
 *
 * @author Glenn Benavides
 */
public class TransactionDataProxy implements InterfaceTRANSACTION {
    
    TransactionData trnData = new TransactionData();

    @Override
    public double verifyAccBalance(String id) {
        return trnData.verifyAccBalance(id);
    }

    @Override
    public boolean performDepositInDB(BankAccount account, double transAmount) {
        boolean isConfirmed = false;
        if (1000 == 125) {    //   <----  <----  <----  Meter aquí la confirmación con front end
            isConfirmed = trnData.performDepositInDB(account, transAmount);
        }
        return isConfirmed;
    }

    @Override
    public boolean saveTransactionInfoInDB(Transaction myTrans) {
        return trnData.saveTransactionInfoInDB(myTrans);
    }

    @Override
    public boolean isExistingAccountInDB(String accNumberSender) {
        return trnData.isExistingAccountInDB(accNumberSender);
    }

    @Override
    public void insertGiftPointsAcc(String accNumberRecip, int transGiftPoints) {
        trnData.insertGiftPointsAcc(accNumberRecip, transGiftPoints);
    }

    @Override
    public double verifyCreditMinPayment(String creditAccNumber) {
        return trnData.verifyCreditMinPayment(creditAccNumber);
    }

    @Override
    public double verifyCreditMaxLoan(String creditAccNumber) {
        return trnData.verifyCreditMaxLoan(creditAccNumber);
    }
    
}
