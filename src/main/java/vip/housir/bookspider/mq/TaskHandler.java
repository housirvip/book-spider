package vip.housir.bookspider.mq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import vip.housir.bookspider.entity.Domain;
import vip.housir.bookspider.entity.SpiderTask;
import vip.housir.bookspider.service.DomainService;
import vip.housir.bookspider.service.RuleService;
import vip.housir.bookspider.service.SpiderService;
import vip.housir.bookspider.spider.SpiderCache;
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
    private final DomainService domainService;
    private final RuleService ruleService;

    private final SpiderCache spiderCache;

    @RabbitHandler
    public void process(String payload) {

        SpiderTask spiderTask = JsonUtils.convertToObj(payload, SpiderTask.class);
        if (spiderTask.getDomainId() != null) {
            spiderCache.setDomainId(spiderTask.getDomainId());
        }

        Domain domain = domainService.oneById(spiderCache.getDomainId());
        spiderTask.setDomainUrl(domain.getUrl());
        spiderTask.setThread(domain.getThread() == null ? 1 : domain.getThread());

        spiderCache.setRules(ruleService.allByDomainId(domain.getId()));

        spiderService.crawl(spiderTask);
    }
}
