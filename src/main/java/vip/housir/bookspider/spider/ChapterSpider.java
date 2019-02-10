package vip.housir.bookspider.spider;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.Optional;

/**
 * @author housirvip
 */
public class ChapterSpider implements PageProcessor {

    private Site site;

    @Override
    public Site getSite() {

        if (site == null) {
            site = Site.me().setRetryTimes(3).setSleepTime(1000);
        }
        return site;
    }

    @Override
    public void process(Page page) {

        Selectable chapter = page.getHtml().xpath("//div[@class='content']");

        String title = chapter.xpath("//h1/text()").get();
        String content = Optional.ofNullable(chapter.xpath("//div[@id='content']/text()").get())
                .map(text -> text.replace("请记住本书首发域名：www.biqiuge.com。笔趣阁手机版阅读网址：m.biqiuge.com", ""))
                .map(text -> text.replaceAll("https://www.biqiuge.com/book/[0-9]+/[0-9]+.html", ""))
                .map(text -> text.replaceAll("[ ]{3,}", "\n"))
                .get();

        page.putField("title", title);
        page.putField("content", content);
    }
}