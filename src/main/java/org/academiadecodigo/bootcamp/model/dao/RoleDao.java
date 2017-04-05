package org.academiadecodigo.bootcamp.model.dao;

import org.academiadecodigo.bootcamp.model.Role;

/**
 * Created by codecadet on 23/03/17.
 */
public interface RoleDao extends InterfaceDao<Role> {

    Role readByName(String name);

}
