package vip.housir.bookspider.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vip.housir.bookspider.entity.Book;
import vip.housir.bookspider.mq.MqSender;

/**
 * @author housirvip
 */
@RestController
@RequestMapping(value = "/book")
@RequiredArgsConstructor
public class BookController {

    private final MqSender mqSender;

    @PostMapping(value = "/add")
    public Book add(@RequestParam String url) {

        Book book = new Book();
        book.setUrl(url);

        mqSender.send(book);

        return book;
    }
}
