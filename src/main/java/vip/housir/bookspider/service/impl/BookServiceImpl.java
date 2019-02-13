package vip.housir.bookspider.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vip.housir.bookspider.entity.Book;
import vip.housir.bookspider.mapper.BookMapper;
import vip.housir.bookspider.service.BookService;
import vip.housir.bookspider.spider.SpiderCache;

/**
 * @author housirvip
 */
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;

    private final SpiderCache spiderCache;

    @Override
    public Integer create(Book book) {

        bookMapper.insertSelective(book);

        spiderCache.saveBookId(book.getSiteId(), book.getId());

        return book.getId();
    }
}
