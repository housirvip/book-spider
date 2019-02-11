package vip.housir.bookspider.spider;

import lombok.RequiredArgsConstructor;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

/**
 * @author housirvip
 */
@RequiredArgsConstructor
public class BookSpider implements PageProcessor {

    private final Site site;

    @Override
    public Site getSite() {

        return site;
    }

    @Override
    public void process(Page page) {

        Selectable info = page.getHtml().xpath("//div[@class='info']");

        final String cover = info.xpath("//img/@src").get();
        final String name = info.xpath("//h2/text()").get();

        Selectable list = page.getHtml().xpath("//div[@class='listmain']");

        List<String> urls = list.xpath("//a/@href").all();

        page.putField("cover", cover);
        page.putField("name", name);
        page.putField("urls", urls);
    }
}