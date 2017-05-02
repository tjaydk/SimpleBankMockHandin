/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CurrencyUnitTest;

import DB.DTO;
import Services.LocalCurrency;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Dennis
 */
public class CurrencyUnitTest {
    
    public CurrencyUnitTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void testCustomerBalanceInDKCurrency() {
        DTO dto = mock(DTO.class);
        LocalCurrency lc = mock(LocalCurrency.class);
        
        short id = 1;
        double balance = 1000d;
        
        when(dto.getCustomerBalanceForAllAccounts(id)).thenReturn(balance);
        when(lc.getLocaleDisplayCountry()).thenReturn("Denmark");
        when(lc.getLocalCurrencyNominator()).thenCallRealMethod();
        when(lc.getCustomerBalanceInLocaleCurrency(id, dto)).thenCallRealMethod();
        
        assertEquals(lc.getCustomerBalanceInLocaleCurrency(id, dto), balance, 0.2);
        
    }
    
    @Test
    public void testCustomerBalanceInUSCurrency() {
        DTO dto = mock(DTO.class);
        LocalCurrency lc = mock(LocalCurrency.class);
        
        short id = 1;
        double balance = 1000d;
        
        when(dto.getCustomerBalanceForAllAccounts(id)).thenReturn(balance);
        when(lc.getLocaleDisplayCountry()).thenReturn("United States");
        when(lc.getLocalCurrencyNominator()).thenCallRealMethod();
        when(lc.getCustomerBalanceInLocaleCurrency(id, dto)).thenCallRealMethod();
        
        assertEquals(lc.getCustomerBalanceInLocaleCurrency(id, dto), 6250d, 0.2);
        
    }
    
    @After
    public void tearDown() {
    }
    
}
