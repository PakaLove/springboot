package com.example.springboot.service;

import com.example.springboot.dao.UserDAO;
import com.example.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public interface UserService {
    public void addUser(User user);

    public List<User> getAll();

    public User getUser(long id);

    public void updateUser(User user);

    public void deleteUser(Long id);
}
