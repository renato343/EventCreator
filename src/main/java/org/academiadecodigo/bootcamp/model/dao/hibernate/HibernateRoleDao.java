package org.academiadecodigo.bootcamp.model.dao.hibernate;

import org.academiadecodigo.bootcamp.model.Role;
import org.academiadecodigo.bootcamp.model.dao.RoleDao;
import org.academiadecodigo.bootcamp.persistence.hibernate.HibernateSessionManager;
import org.hibernate.Query;
import org.hibernate.Session;


/**
 * Created by codecadet on 23/03/17.
 */
public class HibernateRoleDao extends AbstractDao<Role> implements RoleDao {


    public HibernateRoleDao(HibernateSessionManager hibernateSessionManager) {
        super(Role.class,hibernateSessionManager);
    }

    public Role readByName(String name) {

        Session session = hibernateSessionManager.getSession();
        Query query = session.createQuery("from " + classType.getSimpleName() + " where name = :name");
        query.setString("name", name);
        Role object = (Role) query.uniqueResult();
        return object;
    }

    public Role readById(Integer id) {

        Session session = hibernateSessionManager.getSession();
        Query query = session.createQuery("from Role where id = :id");
        query.setString("id", String.valueOf(id));
        Role role = (Role) query.uniqueResult();
        return role;
    }


}
