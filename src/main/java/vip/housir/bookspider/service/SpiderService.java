package vip.housir.bookspider.service;

import vip.housir.bookspider.entity.Book;
import vip.housir.bookspider.entity.Chapter;

/**
 * @author housirvip
 */
public interface SpiderService {

    /**
     * 抓取章节
     *
     * @param chapter Chapter
     */
    void crawl(Chapter chapter);

    /**
     * 抓取书籍
     *
     * @param book Book
     */
    void crawl(Book book);
}
