package org.academiadecodigo.bootcamp.service.user;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.persistence.hibernate.HibernateSessionManager;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Created by codecadet on 22/03/17.
 */
public class HibernateUserService implements UserService {

    HibernateSessionManager hibernateSessionManager;

    public HibernateSessionManager getHibernateSessionManager() {
        return hibernateSessionManager;
    }

    public void setHibernateSessionManager(HibernateSessionManager hibernateSessionManager) {
        this.hibernateSessionManager = hibernateSessionManager;
    }




    @Override
    public String getName() {
        return UserService.class.getSimpleName();
    }

    @Override
    public boolean authenticate(String name, String pass) {

        if (findByName(name) == null) {
            return false;
        }

        if (findByName(name).getName().equals(name) &&
                findByName(name).getPassword().equals(pass)) {
            return true;
        }
        return false;
    }

    @Override
    public void addUser(User user) {
        try {
            Session session = hibernateSessionManager.beginTransaction();
            System.out.println("________________enter add user in HibernateUserservice");

            if (findByMail(user.getEmail()) == null) {
                System.out.println("_______________enter add user in HibernateUserservice - User null");
                session.save(user);
                hibernateSessionManager.commitTransaction();
            } else if (findByMail(user.getEmail()).getEmail().equals(user.getEmail())) {
                System.out.println("________________enter add user in HibernateUserservice - mail exists");
                return;
            } else {
                System.out.println("_________________enter add user in HibernateUserservice - mail doest exists");
                session.save(user);

            }

            hibernateSessionManager.commitTransaction();

        } catch (HibernateException ex) {
            hibernateSessionManager.roolBackTransaction();
        }

    }

    @Override
    public User findByName(String name) {

        Session session = hibernateSessionManager.beginTransaction();
        Query query = session.createQuery("from User where username = :username");
        query.setString("username", name);
        User user = (User) query.uniqueResult();
        hibernateSessionManager.commitTransaction();
        return user;
    }

    @Override
    public User findByMail(String email) {

        Session session = hibernateSessionManager.beginTransaction();
        Query query = session.createQuery("from User where email = :email");
        query.setString("email", email);
        User user = (User) query.uniqueResult();
        hibernateSessionManager.commitTransaction();
        return user;

    }

    @Override
    public void addRoleToUser(Role role, String username) {

    }

    @Override
    public int count() {

        int size = 0;

        try {
            Session session = hibernateSessionManager.beginTransaction();
            size = ((Long) session.createQuery("SELECT count (*) from User").uniqueResult()).intValue();
            hibernateSessionManager.commitTransaction();

        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
            hibernateSessionManager.roolBackTransaction();
        }

        return size;
    }
}
