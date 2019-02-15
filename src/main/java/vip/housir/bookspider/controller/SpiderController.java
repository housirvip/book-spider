package vip.housir.bookspider.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vip.housir.bookspider.entity.SpiderTask;
import vip.housir.bookspider.entity.TaskType;
import vip.housir.bookspider.service.SpiderService;

/**
 * @author housirvip
 */
@RestController
@RequestMapping(value = "/spider")
@RequiredArgsConstructor
public class SpiderController {

    private final SpiderService spiderService;

    @PostMapping(value = "/book")
    public SpiderTask book(@RequestParam Integer domainId, @RequestParam String url) {

        SpiderTask spiderTask = new SpiderTask();
        spiderTask.setUrl(url);
        spiderTask.setDomainId(domainId);
        spiderTask.setType(TaskType.Book);

        spiderService.add(spiderTask);

        return spiderTask;
    }

    @PostMapping(value = "/chapter")
    public SpiderTask chapter(@RequestParam Integer domainId, @RequestParam String url) {

        SpiderTask spiderTask = new SpiderTask();
        spiderTask.setUrl(url);
        spiderTask.setDomainId(domainId);
        spiderTask.setType(TaskType.Chapter);

        spiderService.add(spiderTask);

        return spiderTask;
    }
}
