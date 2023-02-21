package task1maven.dao;

import task1maven.model.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class AddressDao {

    // Session factory oluşturuluyor
    private static SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Address.class)
            .buildSessionFactory();

    // Adres ekleme işlemi
    public void addAddress(Address address) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(address);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Adres güncelleme işlemi
    public void updateAddress(Address address) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(address);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Adres silme işlemi
    public void deleteAddress(Address address) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(address);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Tüm adreslerin listesi
    public List<Address> getAllAddresses() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Address", Address.class).list();
        }
    }

    // Adres ID'sine göre adres bilgisi alma
    public Address getAddressById(long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Address.class, id);
        }
    }
}
