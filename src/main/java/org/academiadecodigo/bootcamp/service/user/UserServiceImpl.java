package org.academiadecodigo.bootcamp.service.user;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.model.dao.UserDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by codecadet on 23/03/17.
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private boolean isAuthenticate = false;
    private String userAuth;

    
    public UserServiceImpl( UserDao userDao) {
        this.userDao = userDao;
    }

    
    @Override
    public String getName() {
        return UserService.class.getSimpleName();
    }

    public String getUserAuth() {
        return userAuth;
    }

    @Transactional
    @Override
    public boolean authenticate(String name, String pass) {


        if (userDao.readByName(name).getName().equals(name) &&
                userDao.readByName(name).getPassword().equals(pass)) {

            isAuthenticate = true;
            userAuth=name;
        } else {
            isAuthenticate = false;
        }


        return isAuthenticate;
    }

    @Transactional
    @Override
    public void addUser(User user) {


        if (userDao.readByMail(user.getEmail()) == null) {
            userDao.create(user);

        }


    }

    @Transactional
    @Override
    public User findByName(String name) {

        User user;
        user = userDao.readByName(name);
        return user;

    }

    @Transactional
    @Override
    public User findByMail(String mail) {

        User user = userDao.readByMail(mail);
        return user;

    }

    @Transactional
    @Override
    public int count() {

        int count = 0;
        count = userDao.count();
        return count;
    }
    
}
