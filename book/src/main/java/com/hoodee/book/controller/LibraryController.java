package com.hoodee.book.controller;

import com.hoodee.book.pojo.Book;
import com.hoodee.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * Package: com.hoodee.book.controller
 * Description：图书controller层  全部返回json格式
 * Author: jianghao
 * Date:  2020.03.01 19:01
 * Modified By:
 */
@RestController
public class LibraryController {
    @Autowired
    BookService bookService;

    /**
     * 查询出所有图书
     * @return
     * @throws Exception
     */
    @GetMapping("/api/books")
    public List<Book> list() throws Exception{
        return bookService.list();
    }

    /**
     * 新增或更新图书
     * @param book
     * @return
     * @throws Exception
     */
    @PostMapping("/api/books")
    public Book addOrUpdate(@RequestBody Book book) throws Exception{
        bookService.addOrUpdate(book);
        return book;
    }

    /**
     * 根据ID删除图书
     * @param book
     * @throws Exception
     */
    @PostMapping("/api/delete")
    public void delete(@RequestBody Book book) throws Exception{
        bookService.deleteById(book.getId());
    }

    /**
     * 更具图书种类查询相应的图书
     * @param cid
     * @return
     * @throws Exception
     */
    @GetMapping("/api/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") int cid) throws Exception {
        if (0 != cid) {
            return bookService.listByCategory(cid);
        } else {
            return list();
        }
    }

    /**
     * 图书搜索功能
     * @param keywords
     * @return
     */
    @GetMapping("/api/search")
    public List<Book> searchResult(@RequestParam("keywords") String keywords) {
        // 关键词为空时查询出所有书籍
        if ("".equals(keywords)) {
            return bookService.list();
        } else {
            return bookService.Search(keywords);
        }
    }

    public String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 图片上传功能
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("api/covers")
    public String coversUpload(MultipartFile file) throws Exception {
        String folder = "D:/Vueworkspace/img";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8443/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}
