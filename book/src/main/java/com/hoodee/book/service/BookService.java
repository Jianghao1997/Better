package com.hoodee.book.service;

import com.hoodee.book.dao.BookDao;
import com.hoodee.book.pojo.Book;
import com.hoodee.book.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Package: com.hoodee.book.service
 * Description：这个 Service 提供了四个功能，分别是查出所有书籍、增加或更新书籍、通过 id 删除书籍和通过分类查出书籍。
 *              这里注意一下 save() 方法的作用是，当主键存在时更新数据，当主键不存在时插入数据。
 *              这也就是核心的业务逻辑了。
 * Author: jianghao
 * Date:  2020.03.01 18:57
 * Modified By:
 */
@Service
public class BookService {

    @Autowired
    BookDao bookDao;
    @Autowired
    CategoryService categoryService;

    public List<Book> list(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return bookDao.findAll(sort);
    }

    public void addOrUpdate(Book book){
        bookDao.save(book);
    }

    public void deleteById(int id){
        bookDao.deleteById(id);
    }

    public List<Book> listByCategory(int cid) {
        Category category = categoryService.get(cid);
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return bookDao.findAllByCategory(category);
    }

    public List<Book> Search(String keywords) {
        return bookDao.findAllByTitleLikeOrAuthorLike('%' + keywords + '%', '%' + keywords + '%');
    }

}
