package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.SQLGrammarException;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        try {
            Session session = Util.HibernateUtil.getSessionFactory().openSession();
            session.createSQLQuery(createTableSQL).executeUpdate();
            session.close();
        } catch (SQLGrammarException ex) {

        }
    }

    @Override
    public void dropUsersTable() {
        try {
            Session session = Util.HibernateUtil.getSessionFactory().openSession();
            session.createSQLQuery(dropTableSQL).executeUpdate();
            session.close();
        } catch (SQLGrammarException ex) {

        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = Util.HibernateUtil.getSessionFactory().openSession();
        User user = new User(name, lastName, age);
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        Session session = Util.HibernateUtil.getSessionFactory().openSession();
        User user = (User) session.load(User.class, id);
        session.delete(user);
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        Session session = Util.HibernateUtil.getSessionFactory().openSession();
        List<User> userList = session.createQuery("from User").list();
        session.close();
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.HibernateUtil.getSessionFactory().openSession();
        session.createQuery("delete from User").executeUpdate();
        session.close();
    }
}
