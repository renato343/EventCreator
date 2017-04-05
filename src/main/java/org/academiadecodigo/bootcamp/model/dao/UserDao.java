package org.academiadecodigo.bootcamp.model.dao;

import org.academiadecodigo.bootcamp.model.User;

/**
 * Created by codecadet on 23/03/17.
 */
public interface UserDao extends InterfaceDao<User> {


    User readByName(String name);

    User readByMail(String mail);

}
