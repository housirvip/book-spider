package vip.housir.bookspider.mq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import vip.housir.bookspider.entity.Book;
import vip.housir.bookspider.entity.Chapter;
import vip.housir.bookspider.entity.SpiderTask;
import vip.housir.bookspider.service.SpiderService;
import vip.housir.bookspider.utils.JsonUtils;

/**
 * @author housirvip
 */
@Slf4j
@Component
@RequiredArgsConstructor
@RabbitListener(queues = RabbitConfig.TASK)
public class TaskHandler {

    private final SpiderService spiderService;

    @RabbitHandler
    public void process(String payload) {

        SpiderTask spiderTask = JsonUtils.convertToObj(payload, SpiderTask.class);

        switch (spiderTask.getType()) {
            case Book:

                Book book = new Book();
                book.setUrl(spiderTask.getUrl());
                book.setThread(spiderTask.getThread());
                spiderService.crawl(book);

                break;
            case Chapter:

                Chapter chapter = new Chapter();
                chapter.setUrl(spiderTask.getUrl());
                chapter.setUrls(spiderTask.getUrls());
                chapter.setThread(spiderTask.getThread());
                spiderService.crawl(chapter);

                break;
            default:

                log.error("未知的 TaskType");
        }
    }
}
