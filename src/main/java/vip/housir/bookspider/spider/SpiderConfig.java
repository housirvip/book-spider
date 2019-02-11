package vip.housir.bookspider.spider;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import vip.housir.bookspider.mq.MqSender;
import vip.housir.bookspider.service.BookService;
import vip.housir.bookspider.service.ChapterService;

/**
 * @author housirvip
 */
@Configuration
@RequiredArgsConstructor
public class SpiderConfig {

    private final BookService bookService;
    private final ChapterService chapterService;

    private final MqSender mqSender;

    @Bean
    public Spider chapterSpider() {

        return Spider.create(new ChapterSpider(site()))
                .addPipeline(new ChapterPipeline(chapterService, mqSender))
                .thread(2);
    }

    @Bean
    public Spider bookSpider() {

        return Spider.create(new BookSpider(site()))
                .addPipeline(new BookPipeline(bookService, mqSender))
                .thread(2);
    }

    private Site site() {

        return Site.me()
                .setRetryTimes(3)
                .setSleepTime(1000)
                .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.81 Safari/537.36")
                .setCharset("gbk");
    }
}
