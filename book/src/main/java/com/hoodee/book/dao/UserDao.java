package com.hoodee.book.dao;

import com.hoodee.book.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Package: com.hoodee.book.dao
 * Description：
 * Author: jianghao
 * Date:  2020.03.01 16:13
 * Modified By:
 */
public interface UserDao extends JpaRepository<User,Integer> {
    User findByUsername(String username);

    User getByUsernameAndPassword(String username,String password);
}
