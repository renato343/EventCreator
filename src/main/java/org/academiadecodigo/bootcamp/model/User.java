package org.academiadecodigo.bootcamp.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by codecadet on 07/03/17.
 */
public class User {

    private String password;
    private String email;
    private String name;
    private Set<Role> roleSet;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;

    public User() {
    }

    public User(String password, String email, String name) {
        this.password = password;
        this.email = email;
        this.name = name;
        roleSet = new HashSet<>();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addRole(Role role) {

        roleSet.add(role);
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }


    //TODO CHECAR OVERRIDE DE EQUALS E HASCODE
    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getPassword() != null ? !getPassword().equals(user.getPassword()) : user.getPassword() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(user.getEmail()) : user.getEmail() != null) return false;
        if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null)
            return false;
        if (getRoleSet() != null ? !getRoleSet().equals(user.getRoleSet()) : user.getRoleSet() != null) return false;
        return getId() != null ? getId().equals(user.getId()) : user.getId() == null;
    }

    @Override
    public int hashCode() {
        int result = getPassword() != null ? getPassword().hashCode() : 0;
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getRoleSet() != null ? getRoleSet().hashCode() : 0);
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        return result;
    }
}
