package interfaces;

import entities.Customer;

/**
 *
 * @author Dennis
 */
public interface BankInterface {
    public double checkBalance(short accountId);
    public void withdraw(short accountId, double amount);
    public void insert(short accountId, double amount);
    public Customer getCustomerInformationFromAccount(short accountId);
}
