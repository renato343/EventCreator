package org.academiadecodigo.bootcamp.service.user;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.Service;

/**
 * Created by codecadet on 07/03/17.
 */
public interface UserService extends Service {

    boolean authenticate(String name, String pass);

    void addUser(User user);

    User findByName(String name);

    User findByMail(String name);


    int count();


}
