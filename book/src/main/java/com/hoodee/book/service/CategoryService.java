package com.hoodee.book.service;

import com.hoodee.book.dao.CategoryDao;
import com.hoodee.book.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Package: com.hoodee.book.service
 * Description：
 * Author: wude
 * Date:  2020.03.01 18:52
 * Modified By:
 */
@Service
public class CategoryService {

    @Autowired
    CategoryDao categoryDao;

    public List<Category> list(){
        //这里对查询的结果做了个排序以及条件判断。
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return categoryDao.findAll(sort);
    }

    public Category get(int id){
        Category category = categoryDao.findById(id).orElse(null);
        return category;
    }
}
