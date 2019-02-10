package vip.housir.bookspider.spider;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import us.codecraft.webmagic.Spider;

/**
 * @author housirvip
 */
@Configuration
public class SpiderConfig {

    @Bean
    public Spider spider() {
        return Spider.create(new ChapterSpider());
    }
}
