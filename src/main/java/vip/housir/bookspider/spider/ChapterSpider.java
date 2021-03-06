package vip.housir.bookspider.spider;

import lombok.RequiredArgsConstructor;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import vip.housir.bookspider.common.Constant;
import vip.housir.bookspider.utils.SpiderUtils;

/**
 * @author housirvip
 */
@RequiredArgsConstructor
public class ChapterSpider implements PageProcessor {

    private final Site site;

    private final SpiderCache spiderCache;

    private static String ruleType = Constant.CHAPTER;

    @Override
    public Site getSite() {

        return site;
    }

    @Override
    public void process(Page page) {

        spiderCache.getRules().forEach(rule -> {
            if (ruleType.equals(rule.getType())) {
                SpiderUtils.putField(page, rule);
            }
        });
//        Selectable chapter = page.getHtml().xpath("//div[@class='content']");
//
//        final String h1 = chapter.xpath("//h1/text()").get();
//
//        final String content = Optional.of(chapter.xpath("//div[@id='content']/text()").get())
//                .map(text -> text.replace("请记住本书首发域名：www.biqiuge.com。笔趣阁手机版阅读网址：m.biqiuge.com", ""))
//                .map(text -> text.replaceAll("https://www.biqiuge.com/book/[0-9]+/[0-9]+.html", ""))
//                .map(text -> text.replaceAll("[ ]+", "\n"))
//                .map(String::trim)
//                .get();
//
//        final String title = Optional.of(h1)
//                .map(text -> text.replaceAll("第.+章", ""))
//                .map(String::trim)
//                .get();
//
//        final String numStr = Optional.of(h1)
//                .map(text -> text.replace(title, ""))
//                .map(text -> text.replaceAll("[第章]", ""))
//                .map(String::trim)
//                .get();
//
//        Integer num = StringUtils.chinese2Int(numStr);
//
//        page.putField("title", title);
//        page.putField("content", content);
//        page.putField("num", num);
    }
}