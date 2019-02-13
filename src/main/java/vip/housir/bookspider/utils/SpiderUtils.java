package vip.housir.bookspider.utils;

import us.codecraft.webmagic.Page;
import vip.housir.bookspider.common.Constant;
import vip.housir.bookspider.entity.Rule;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author housirvip
 */
public class SpiderUtils {

    public static void putField(Page page, Rule rule) {

        switch (rule.getKey()) {
            case Constant.URLS:
                page.putField(Constant.URLS, page.getHtml().xpath(rule.getXpath()).all());
                break;
            case Constant.NUM:
                break;
            default:
                AtomicReference<String> value = new AtomicReference<>(page.getHtml().xpath(rule.getXpath()).get());
                if (rule.getRegexp() != null) {
                    rule.getRegexp().forEach(regexp -> value.updateAndGet(v -> v.replaceAll(regexp, "")));
                }
                page.putField(rule.getKey(), value.get());
        }
    }
}
