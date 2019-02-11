package vip.housir.bookspider.spider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import vip.housir.bookspider.entity.Book;
import vip.housir.bookspider.entity.Chapter;
import vip.housir.bookspider.mq.MqSender;
import vip.housir.bookspider.service.BookService;

import java.util.List;
import java.util.Map;

/**
 * @author housirvip
 */
@Slf4j
@RequiredArgsConstructor
public class BookPipeline implements Pipeline {

    private final BookService bookService;

    private final MqSender mqSender;

    @Override
    public void process(ResultItems resultItems, Task task) {

        Map<String, Object> map = resultItems.getAll();

        Book book = new Book();
        book.setName((String) map.get("name"));
        book.setCover((String) map.get("cover"));
        bookService.create(book);

        log.info("下载书籍：" + book.getName());

        Chapter chapter = new Chapter();
        chapter.setBookId(book.getId());
        chapter.setUrls((List<String>) map.get("urls"));
        mqSender.send(chapter);
    }
}
