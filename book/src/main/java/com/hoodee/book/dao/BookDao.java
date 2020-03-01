package com.hoodee.book.dao;

import com.hoodee.book.pojo.Book;
import com.hoodee.book.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Package: com.hoodee.book.dao
 * Description：
 * Author: wude
 * Date:  2020.03.01 18:50
 * Modified By:
 */
public interface BookDao extends JpaRepository<Book,Integer> {
    List<Book> findAllByCategory(Category category);
    List<Book> findAllByTitleLikeOrAuthorLike(String keyword1, String keyword2);
}
