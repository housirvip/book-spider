package vip.housir.bookspider.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Spider;
import vip.housir.bookspider.entity.SpiderTask;
import vip.housir.bookspider.mq.MqSender;
import vip.housir.bookspider.service.SpiderService;

/**
 * @author housirvip
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SpiderServiceImpl implements SpiderService {

    private final Spider chapterSpider;
    private final Spider bookSpider;

    private final MqSender mqSender;

    @Override
    public void add(SpiderTask spiderTask) {

        mqSender.send(spiderTask);
    }

    @Override
    public void crawl(SpiderTask spiderTask) {

        Spider spider = getSpider(spiderTask);

        if (spiderTask.getUrl() != null) {
            spider.addUrl(spiderTask.getDomainUrl() + spiderTask.getUrl());
        }

        if (spiderTask.getUrls() != null) {
            spiderTask.getUrls().forEach(url -> spider.addUrl(spiderTask.getDomainUrl() + url));
        }

        spider.thread(spiderTask.getThread()).start();
    }

    private Spider getSpider(SpiderTask spiderTask) {

        switch (spiderTask.getType()) {
            case Chapter:
                return chapterSpider;
            case Book:
                return bookSpider;
            default:
                throw new RuntimeException("无效的 TaskType");
        }
    }
}
