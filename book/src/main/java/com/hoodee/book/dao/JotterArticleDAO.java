package com.hoodee.book.dao;

import com.hoodee.book.pojo.JotterArticle;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Package: com.hoodee.book.pojo
 * Description：
 * Author: jianghao
 * Date:  2020.03.01 15:53
 * Modified By:
 */

public interface JotterArticleDAO extends JpaRepository<JotterArticle,Integer> {
    JotterArticle findById(int id);
}
