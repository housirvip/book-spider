package vip.housir.bookspider.mq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import vip.housir.bookspider.service.SpiderService;

/**
 * @author housirvip
 */
@Slf4j
@Component
@RequiredArgsConstructor
@RabbitListener(queues = RabbitConfig.LINK)
public class LinkHandler {

    private final SpiderService spiderService;

    @RabbitHandler
    public void process(String link) {

        spiderService.crawlByLink(link);
    }
}
