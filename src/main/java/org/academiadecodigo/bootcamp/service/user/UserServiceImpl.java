package org.academiadecodigo.bootcamp.service.user;

import org.academiadecodigo.bootcamp.model.Role;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.model.dao.RoleDao;
import org.academiadecodigo.bootcamp.model.dao.UserDao;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by codecadet on 23/03/17.
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private RoleDao roleDao;
    private boolean isAuthenticate = false;

    public UserServiceImpl( UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }



    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public RoleDao getRoleDao() {
        return roleDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public String getName() {
        return UserService.class.getSimpleName();
    }

    @Transactional
    @Override
    public boolean authenticate(String name, String pass) {


        if (userDao.readByName(name).getName().equals(name) &&
                userDao.readByName(name).getPassword().equals(pass)) {

            isAuthenticate = true;
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

        User user = null;
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
    public void addRoleToUser(Role role, String username) {


        if (userDao.readByName(username) != null) {
            userDao.readByName(username).addRole(role);
        }
    }

    @Transactional
    @Override
    public int count() {

        int count = 0;
        count = userDao.count();
        return count;
    }
}
