package vip.housir.bookspider.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Spider;
import vip.housir.bookspider.entity.Book;
import vip.housir.bookspider.entity.Chapter;
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

    @Value(value = "https://www.biqiuge.com")
    private String rootUrl;

    @Override
    public void crawl(Chapter chapter) {

        if (chapter.getUrl() != null) {
            chapterSpider.addUrl(rootUrl + chapter.getUrl());
        }

        if (chapter.getUrls() != null) {
            chapter.getUrls().forEach(url -> chapterSpider.addUrl(rootUrl + url));
        }

        chapterSpider.thread(chapter.getThread()).start();
    }

    @Override
    public void crawl(Book book) {

        if (book.getUrl() != null) {
            bookSpider.addUrl(rootUrl + book.getUrl());
        }

        if (book.getUrls() != null) {
            book.getUrls().forEach(url -> bookSpider.addUrl(rootUrl + url));
        }

        bookSpider.thread(book.getThread()).start();
    }
}
