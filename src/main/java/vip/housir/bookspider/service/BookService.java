package vip.housir.bookspider.service;

import vip.housir.bookspider.entity.Book;

/**
 * @author housirvip
 */
public interface BookService {

    /**
     * 新建书籍，返回主键
     *
     * @param book Book
     */
    void create(Book book);
}
