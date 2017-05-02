/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbTest;

import DB.DTO;
import entities.Customer;
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
public class DbTest {
    
    private DTO dto;
    
    public DbTest() {
    }
    
    @Before
    public void setUp() {
        dto = mock(DTO.class);
    }
    
    @Test
    public void testFindUser() {
        Customer customerMock = new Customer();
        customerMock.setFirstName("Alju");
        when(dto.findCustomerByFirstName("Alju")).thenReturn(customerMock);
        
        assertEquals(dto.findCustomerByFirstName("Alju"), customerMock);
    }
    
    public void testGetCustomerBalance() {
        short id = 1;
        when(dto.getCustomerBalanceForAllAccounts(id)).thenReturn(5000D);
        
        assertTrue(dto.getCustomerBalanceForAllAccounts(id) == 5000D);
    }
    
    public void testNumberOfCustomers() {
        when(dto.getCustomerCount()).thenReturn(10);
        
        assertTrue(dto.getCustomerCount() == 10);
    }
    
    @After
    public void tearDown() {
    }
    
}
