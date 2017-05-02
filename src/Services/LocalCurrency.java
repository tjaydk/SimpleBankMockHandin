/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DB.DTO;
import java.util.Locale;

/**
 *
 * @author Dennis
 */
public class LocalCurrency {
    
    public double getCustomerBalanceInLocaleCurrency(short custId, DTO dto) {
        double balance = dto.getCustomerBalanceForAllAccounts(custId);
        double nominator = getLocalCurrencyNominator();
        
        return balance * nominator;
    }
    
    public double getLocalCurrencyNominator() {
        String locale = getLocaleDisplayCountry();
        if(locale == "Denmark") {
            return 1;
        } else if (locale == "United States") {
            return 6.25;
        } else if (locale == "England") {
            return 10.24;
        }
        
        return 0d;
    }
    
    public String getLocaleDisplayCountry() {
        Locale currentLocale = Locale.getDefault();
        return currentLocale.getDisplayCountry();
    }
}
