package task1maven;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import task1maven.dao.AccountDao;
import task1maven.dao.AddressDao;
import task1maven.dao.CustomerDao;
import task1maven.dao.PhoneDao;
import task1maven.model.Account;
import task1maven.model.Address;
import task1maven.model.Customer;
import task1maven.model.Phone;

public class App 
{
	
    public static void main( String[] args )
    {
    	        // Örnek bir müşteri oluşturuyoruz
    	        Customer customer = new Customer("ılgın", "kırmızı", "35647054123", "ılgın@ılgın.com");
    	        
    	        // Müşteri DAO sınıfı
    	        CustomerDao customerDao = new CustomerDao();

    	        // Müşteri ekleme işlemi
    	        customerDao.addCustomer(customer);
    	        
    	        // Müşteri bilgilerinin güncellenmesi
    	        customer.setName("ılgoş");
    	        customerDao.updateCustomer(customer);
    	        
    	        // Tüm müşterilerin listelenmesi
    	        List<Customer> customers = customerDao.getAllCustomers();
    	        System.out.println("Tüm müşteriler:");
    	        for (Customer c : customers) {
    	            System.out.println(c);
    	        }
    	        
    	        // ID'ye göre müşteri bilgisi alma
    	        Customer customerById = customerDao.getCustomerById(customer.getId());
    	        System.out.println("Müşteri bilgisi (ID'ye göre): " + customerById);
    	        
    	        // Müşteri silme işlemi
//    	        customerDao.deleteCustomer(customer);
//    	        System.out.println("Müşteri silindi.");
    	        
    	        // Örnek bir adres oluşturuyoruz
    	        Address address = new Address("Bolu", "Merkez", 14100, "Atatürk Bulvarı", customer);

    	        // Adres DAO sınıfı
    	        AddressDao addressDao = new AddressDao();

    	        // Adres ekleme işlemi
    	        addressDao.addAddress(address);

    	        // Adres bilgilerinin güncellenmesi
    	        address.setCity("İstanbul");
    	        addressDao.updateAddress(address);

    	        // Tüm adreslerin listelenmesi
    	        List<Address> addresses = addressDao.getAllAddresses();
    	        System.out.println("Tüm adresler:");
    	        for (Address a : addresses) {
    	            System.out.println(a);
    	        }

    	        // ID'ye göre adres bilgisi alma
    	        Address addressById = addressDao.getAddressById(address.getId());
    	        System.out.println("Adres bilgisi (ID'ye göre): " + addressById);

    	        // Adres silme işlemi
//    	        addressDao.deleteAddress(address);
//    	        System.out.println("Adres silindi.");

    	        // Örnek bir telefon oluşturuyoruz
    	        Phone phone = new Phone("5551234567", customer);

    	        // Telefon DAO sınıfı
    	        PhoneDao phoneDao = new PhoneDao();

    	        // Telefon ekleme işlemi
    	        phoneDao.addPhone(phone);

    	        // Telefon bilgilerinin güncellenmesi
    	        phone.setNumber("5557654321");
    	        phoneDao.updatePhone(phone);

    	        // Tüm telefonların listelenmesi
    	        List<Phone> phones = phoneDao.getAllPhones();
    	        System.out.println("Tüm telefonlar:");
    	        for (Phone p : phones) {
    	            System.out.println(p);
    	        }

    	        // ID'ye göre telefon bilgisi alma
    	        Phone phoneById = phoneDao.getPhoneById(phone.getId());
    	        System.out.println("Telefon bilgisi (ID'ye göre): " + phoneById);
    	        
    	        // Telefon silme işlemi
//    	        phoneDao.deletePhone(phone);
//    	        System.out.println("Telefon silindi.");

    	        // Örnek bir hesap oluşturuyoruz
    	        Account account = new Account("TR000000000000000000000001", "TRY", 54000, LocalDate.now(),  customer);

    	        // Hesap DAO sınıfı
    	        AccountDao accountDao = new AccountDao();

    	        // Hesap ekleme işlemi
    	        accountDao.addAccount(account);

    	        // Hesap bilgilerinin güncellenmesi
    	        account.setBalance(2000);
    	        accountDao.updateAccount(account);

    	        // Tüm hesapların listelenmesi
    	        List<Account> accounts = accountDao.getAllAccounts();
    	        System.out.println("Tüm hesaplar:");
    	        for (Account a : accounts) {
    	            System.out.println(a);
    	        }

    	        // ID'ye göre hesap bilgisi alma
    	        Account accountById = accountDao.getAccountById(account.getId());
    	        System.out.println("Hesap bilgisi (ID'ye göre): " + accountById);

    	        // Hesap silme işlemi
//    	        accountDao.deleteAccount(account);
//    	        System.out.println("Hesap silindi.");
    	    }
    	}



    	
    	

    

