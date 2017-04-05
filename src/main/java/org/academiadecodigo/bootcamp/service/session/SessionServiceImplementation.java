package org.academiadecodigo.bootcamp.service.session;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.model.dao.UserDao;
import org.academiadecodigo.bootcamp.persistence.TransactionManager;

/**
 * Created by Renato on 24/03/17.
 */
public class SessionServiceImplementation implements SessionService {

    //TODO Class to check role to change the views...
    private UserDao userDao;
    private TransactionManager tx;
    private Integer userID;

    public SessionServiceImplementation(UserDao userDao, TransactionManager tx) {
        this.userDao = userDao;
        this.tx = tx;
    }


    @Override
    public boolean login(String userName, String passWord) {

        tx.beginTransaction();
        User user = userDao.readByName(userName);
        this.userID = user.getId();

        return false;
    }
}
