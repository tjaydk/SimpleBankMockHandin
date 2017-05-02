/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import entities.Account;
import entities.Customer;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Dennis
 */
public class DTO {

    private String PU_NAME = "SimpleBankPU";

    public void createCustomer(Customer cust) {
        DBConnector conn = new DBConnector();
        EntityManagerFactory emf = conn.getConnection();
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(cust);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }

    public Customer findCustomerById(short custId) {
        DBConnector conn = new DBConnector();
        EntityManagerFactory emf = conn.getConnection();
        EntityManager em = emf.createEntityManager();

        Customer cust = new Customer();

        try {
            cust = em.find(Customer.class, custId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
        return cust;
    }
    
    public Customer findCustomerByFirstName(String firstName) {
        DBConnector conn = new DBConnector();
        EntityManagerFactory emf = conn.getConnection();
        EntityManager em = emf.createEntityManager();

        Customer cust = new Customer();

        try {
            TypedQuery<Customer> query = em.createNamedQuery("Customer.findByFirstName", Customer.class);
            query.setParameter("firstName", firstName);
            cust = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
        return cust;
    }
    
    public void deleteCustomerById(short custId) {
        DBConnector conn = new DBConnector();
        EntityManagerFactory emf = conn.getConnection();
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Customer cust = em.find(Customer.class, custId);
            em.remove(cust);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
    
    public double getCustomerBalanceForAllAccounts(short custId) {
        DBConnector conn = new DBConnector();
        EntityManagerFactory emf = conn.getConnection();
        EntityManager em = emf.createEntityManager();

        double balance = 0;
        
        try {
            Customer cust = em.find(Customer.class, custId);
            Collection<Account> accounts = cust.getAccountCollection();
            for (Account account : accounts) {
                balance += account.getBalance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
        
        return balance;
    }
    
    public int getCustomerCount() {
        DBConnector conn = new DBConnector();
        EntityManagerFactory emf = conn.getConnection();
        EntityManager em = emf.createEntityManager();

        int count = 0;
        
        try {
            TypedQuery<Customer> query = em.createNamedQuery("Customer.Customer.findAll", Customer.class);
            List<Customer> custList = query.getResultList();
            count = custList.size();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
        
        return count;
    }
}
