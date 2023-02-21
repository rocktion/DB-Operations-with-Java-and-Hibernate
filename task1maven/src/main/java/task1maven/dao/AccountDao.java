package task1maven.dao;


import java.util.List;

import task1maven.model.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;


public class AccountDao {

    // Session factory oluşturuluyor
    private static SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Account.class)
            .buildSessionFactory();

    // Hesap ekleme işlemi
    public void addAccount(Account account) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(account);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Hesap güncelleme işlemi
    public void updateAccount(Account account) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(account);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Hesap silme işlemi
    public void deleteAccount(Account account) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(account);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Tüm hesapların listesi
    public List<Account> getAllAccounts() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Account", Account.class).list();
        }
    }

    // Hesap ID'sine göre hesap bilgisi alma
    public Account getAccountById(long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Account.class, id);
        }
    }
}