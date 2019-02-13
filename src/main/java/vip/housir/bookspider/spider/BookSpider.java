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
public class BookSpider implements PageProcessor {

    private final Site site;

    private final SpiderCache spiderCache;

    private static String ruleType = Constant.BOOK;

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
    }
}