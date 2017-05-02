/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import DB.DTO;
import entities.Customer;

/**
 *
 * @author Dennis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Customer cust = new Customer();
//        cust.setFirstName("Alju");
//        cust.setLastName("Hara");
//        cust.setAge(18);
        
        DTO dto = new DTO();
//        dto.createCustomer(cust);
        short id = 1;
        dto.deleteCustomerById(id);
        System.out.println("Customer found: " + dto.findCustomerByFirstName("Alju"));
    }
    
}
