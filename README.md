# SimpleBankMockHandin
#### By Dennis Andersen

This application is a simple bank that uses JPA with a MySQL database. It consists of a class to create, find and delete customers
and a class that can collect the balance of a customers accounts. Furthermore there is a class that converts the users balance to
the clients local currency. At the moment only supporting DK, US Dollars and UK Pound.

To check the database i've used the Mockito framework to mock out the database in order to test on simulated data instead of live data,
for the simple CRUD operations the mocking is not that interesting as it only does a simulation of the creation etc. but it is useful
for the currency test.

In the currency converter test we mock out the DTO in order to simulate a customer and return a balance of 1000, then use the mock
on the LocalCurrenc.class in order to determine the system locale so we insure that the test will not fail if run on a client of 
different locale. Thereby we can make an test and insure that the calculations function is working correctly without using data
from the database or having to be on a specific client.

The mockito framework works with mocking choosen methods in a class, and by using the callRealMethod function we are able to insure
that only parts of the class is mocked.
