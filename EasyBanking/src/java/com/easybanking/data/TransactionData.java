

package com.easybanking.data;
import com.easybanking.entity.BankAccount;
import com.easybanking.entity.Transaction;
import com.easybanking.proxy.InterfaceTRANSACTION;

/**
 * @author Glenn Benavides
 */
public class TransactionData implements InterfaceTRANSACTION {
    
    @Override
    public double verifyAccBalance(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean performDepositInDB(BankAccount account, double transAmount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveTransactionInfoInDB(Transaction myTrans) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isExistingAccountInDB(String accNumberSender) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertGiftPointsAcc(String accNumberRecip, int transGiftPoints) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double verifyCreditMinPayment(String creditAccNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double verifyCreditMaxLoan(String creditAccNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}