package vip.housir.bookspider.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vip.housir.bookspider.entity.SpiderTask;
import vip.housir.bookspider.entity.TaskType;
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
    public SpiderTask add(@RequestParam Integer domainId, @RequestParam String book) {

        SpiderTask spiderTask = new SpiderTask();
        spiderTask.setUrl(book);
        spiderTask.setDomainId(domainId);
        spiderTask.setType(TaskType.Book);

        mqSender.send(spiderTask);

        return spiderTask;
    }
}
