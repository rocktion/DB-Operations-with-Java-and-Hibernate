package task1maven.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;
import task1maven.model.Phone;


public class PhoneDao {
	
	// Session factory oluşturuluyor
    private static SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Phone.class)
            .buildSessionFactory();

    // Telefon ekleme işlemi
    public void addPhone(Phone phone) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(phone);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Telefon güncelleme işlemi
    public void updatePhone(Phone phone) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(phone);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Telefon silme işlemi
    public void deletePhone(Phone phone) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(phone);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
 // Tüm telefonların listesi
    public List<Phone> getAllPhones() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Phone", Phone.class).list();
        }
    }

    // Telefon ID'sine göre telefon bilgisi alma
    public Phone getPhoneById(long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Phone.class, id);
        }
    }
}