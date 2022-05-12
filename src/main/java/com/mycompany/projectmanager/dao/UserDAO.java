package com.mycompany.projectmanager.dao;

import com.mycompany.projectmanager.entities.User;

import java.util.List;

/**
 *
 * @author Hugues
 */
public interface UserDAO extends GenericDAO<User, String>{
    public List<User>findAll();
    public User findByUsernameAndPassword(String username, String password);
    public User findByUsername(String username);
    public User findByEmail(String email);
    public User findUserById(int id);
    public long usersSize();
}
