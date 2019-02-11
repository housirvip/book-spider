package vip.housir.bookspider.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vip.housir.bookspider.entity.Book;
import vip.housir.bookspider.mapper.BookMapper;
import vip.housir.bookspider.service.BookService;

/**
 * @author housirvip
 */
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;

    @Override
    public Integer create(Book book) {

        bookMapper.insertSelective(book);

        return book.getId();
    }
}
