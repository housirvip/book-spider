package vip.housir.bookspider.mq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import vip.housir.bookspider.entity.Chapter;
import vip.housir.bookspider.service.SpiderService;
import vip.housir.bookspider.utils.JsonUtils;

/**
 * @author housirvip
 */
@Slf4j
@Component
@RequiredArgsConstructor
@RabbitListener(queues = RabbitConfig.CHAPTER)
public class ChapterHandler {

    private final SpiderService spiderService;

    @RabbitHandler
    public void process(String payload) {

        spiderService.crawl(JsonUtils.convertToObj(payload, Chapter.class));
    }
}
