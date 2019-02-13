package vip.housir.bookspider.mq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import vip.housir.bookspider.entity.Book;
import vip.housir.bookspider.service.BookService;
import vip.housir.bookspider.spider.SpiderCache;
import vip.housir.bookspider.utils.JsonUtils;

/**
 * @author housirvip
 */
@Slf4j
@Component
@RequiredArgsConstructor
@RabbitListener(queues = RabbitConfig.BOOK)
public class BookHandler {

    private final BookService bookService;

    private final SpiderCache spiderCache;

    @RabbitHandler
    public void process(String payload) {

        Book book = JsonUtils.convertToObj(payload, Book.class);

        bookService.create(book);

        spiderCache.saveBookId(book.getSiteId(), book.getId());

        log.info("下载书籍：[" + book.getName() + "] 完成，编号：" + book.getId());
    }
}
