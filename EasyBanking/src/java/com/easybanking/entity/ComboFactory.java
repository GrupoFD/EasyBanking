package com.easybanking.entity;
import com.easybanking.entity.Person;
import java.util.Calendar;

/**
 *
 * @author Glenn Benavides
 */
public abstract class ComboFactory {
    

    public abstract TwoInOneCombo createTwoInOne(Bank issuer, Person personOwner, double openingAmount);
    
    public abstract SuperCreditCombo createSuperCredit(Bank issuer,Person person);
	
    public abstract UseCreditAndSaveCombo createUseCreditAndSave(Bank issuer, Person personOwner, double openingAmount);

}
