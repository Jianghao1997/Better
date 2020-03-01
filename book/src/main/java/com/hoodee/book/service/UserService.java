package com.hoodee.book.service;

import com.hoodee.book.dao.UserDao;
import com.hoodee.book.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Package: com.hoodee.book.service
 * Description：
 * Author: wude
 * Date:  2020.03.01 16:17
 * Modified By:
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public boolean isExist(String username){
        User user = getByUserName(username);
        return null != user;
    }

    public User getByUserName(String username){
        return userDao.findByUsername(username);
    }

    public User get(String username, String password){
        return userDao.getByUsernameAndPassword(username,password);
    }

    public void addOrUpdate(User user){
        userDao.save(user);
    }
}

