/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectmanager.dao.impl;

import com.mycompany.projectmanager.dao.UserDAO;
import com.mycompany.projectmanager.entities.User;
import java.util.List;
import javax.persistence.NoResultException;

import jdk.internal.dynalink.support.NameCodec;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDAO")
@Transactional
public class UserDAOImpl extends GenericDAOImpl<User, String> implements UserDAO {

    public UserDAOImpl() {
        super(User.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<User> findAll() {
        return em.createNamedQuery("User.findAll").getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true, propagation
            = Propagation.SUPPORTS)
    public User findByUsernameAndPassword(String username, String password) {
        List<User> users = em.createNamedQuery("User.findByUsernameAndPassword")
                .setParameter("username", username)
                .setParameter("password", password)
                .getResultList();
        return (users.size() == 1 ? users.get(0) : null);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public User findByUsername(String username) {
        return (User) em.createNamedQuery("User.findByUsername")
                .setParameter("username", username)
                .getSingleResult();
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public User findByEmail(String email) {
        User user = null;
        try {
            user = (User) em.createNamedQuery("User.findByEmail")
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException nre) {
            System.out.println(nre);
        }
        return user;
    }

    @Override
    public User findUserById(int id) {
        return null;
    }

    @Override
    public long usersSize() {
        return ((long)em.createNamedQuery("User.size").getSingleResult());
    }

//    @Override
//    @Transactional(readOnly = false)
//    public User saveUser(User user) {
//        try {
//            NameCodec bCryptPasswordEncoder;
//            if (null == user.getId()) {
////                User.adminRole(user);
//                user.setPassword(NameCodec.encode(user.getPassword()));
//            } else {
//
//                Optional<User> userFromDB = findUserById(Integer.parseInt(user.getId()));
//                if (!NameCodec.matches(user.getPassword(), userFromDB.get().getPassword())) {
//                    user.setPassword(NameCodec.encode(user.getPassword()));
//                } else {
//
//                    user.setPassword(userFromDB.get().getPassword());
//                }
//            }
//
//        }
//    }
}
