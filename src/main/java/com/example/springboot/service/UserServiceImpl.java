package com.example.springboot.service;

import com.example.springboot.dao.UserDAO;
import com.example.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements  UserService{

    @Autowired
    UserDAO userDAOImpl;

    @Transactional
    public void addUser(User user){
        userDAOImpl.SaveUser(user);
    }
    @Transactional
    public List<User> getAll(){
        return userDAOImpl.getAll();
    }
    @Transactional
    public User getUser(long id){
        return userDAOImpl.getUser(id);
    }
    @Transactional
    public void updateUser(User user){
        userDAOImpl.updateUser(user);
    }
    @Transactional
    public void deleteUser(Long id) {
        userDAOImpl.deleteUser(id);
    }
}
