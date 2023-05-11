package DAOs;

import DataBase.HibernateClass;
import Pojoes.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDao {

    public Users findById(int id) {
        return (Users) HibernateClass.getSessionFactory().openSession().get(Users.class, id);
    }

    public List<Users> findByLogin(String login) {
        List<Users> users = (List<Users>) HibernateClass.getSessionFactory().openSession().createQuery("From Users WHERE UserLogin='" + login + "'").list();
        return users;
    }

    public void save(Users user) {
        Session session = HibernateClass.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(Users user) {
        Session session = HibernateClass.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(Users user) {
        Session session = HibernateClass.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }


    public List<Users> findAll() {
        List<Users> users = (List<Users>)  HibernateClass.getSessionFactory().openSession().createQuery("From Users").list();
        return users;
    }
}
