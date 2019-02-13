package vip.housir.bookspider.mq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import vip.housir.bookspider.entity.Chapter;
import vip.housir.bookspider.service.ChapterService;
import vip.housir.bookspider.spider.SpiderCache;
import vip.housir.bookspider.utils.JsonUtils;

/**
 * @author housirvip
 */
@Slf4j
@Component
@RequiredArgsConstructor
@RabbitListener(queues = RabbitConfig.CHAPTER)
public class ChapterHandler {

    private final ChapterService chapterService;

    private final SpiderCache spiderCache;

    @RabbitHandler
    public void process(String payload) {

        Chapter chapter = JsonUtils.convertToObj(payload, Chapter.class);
        chapter.setBookId(spiderCache.getBookId());

        chapterService.create(chapter);

        log.info("下载章节：[第" + chapter.getNum() + "章 " + chapter.getTitle() + "] 完成，编号：" + chapter.getId());
    }
}
