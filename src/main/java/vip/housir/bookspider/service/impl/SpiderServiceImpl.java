package vip.housir.bookspider.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Spider;
import vip.housir.bookspider.service.ChapterService;
import vip.housir.bookspider.service.SpiderService;

/**
 * @author housirvip
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SpiderServiceImpl implements SpiderService {

    private final Spider spider;

    private final ChapterService chapterService;

    @Override
    public void crawlByLink(String link) {

        ResultItems result = spider.get(link);
        if (result == null) {
            return;
        }

        chapterService.createByMap(result.getAll());
    }
}
