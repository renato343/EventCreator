package org.academiadecodigo.bootcamp.model.dao.hibernate;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.model.dao.UserDao;
import org.academiadecodigo.bootcamp.persistence.TransactionException;
import org.academiadecodigo.bootcamp.persistence.hibernate.HibernateSessionManager;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Created by codecadet on 23/03/17.
 */
public class HibernateUserDao extends AbstractDao<User> implements UserDao{

    public HibernateUserDao() {

        this.classType = User.class;

    }

    public User readByName(String name) {

        Session session = getHibernateSessionManager().getSession();
        Query query = session.createQuery("from User where name = :name");
        query.setString("name", name);
        User object = (User) query.uniqueResult();
        return object;
    }

    public User readByMail(String email) {

        Session session = getHibernateSessionManager().getSession();
        Query query = session.createQuery("from User where email = :email");
        query.setString("email", email);
        User user = (User) query.uniqueResult();
        return user;
    }

}
