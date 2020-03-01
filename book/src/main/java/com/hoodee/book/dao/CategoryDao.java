package com.hoodee.book.dao;

import com.hoodee.book.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Package: com.hoodee.book.dao
 * Description：
 * Author: jianghao
 * Date:  2020.03.01 18:50
 * Modified By:
 */
public interface CategoryDao extends JpaRepository<Category,Integer> {
}
