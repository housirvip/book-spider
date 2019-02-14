package vip.housir.bookspider.utils;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.selector.Selectable;
import vip.housir.bookspider.common.Constant;
import vip.housir.bookspider.entity.KeyValue;
import vip.housir.bookspider.entity.Rule;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author housirvip
 */
public class SpiderUtils {

    public static void putField(Page page, Rule rule) {

        Selectable selectable = page.getHtml().xpath(rule.getXpath());
        switch (rule.getName()) {
            case Constant.URLS:
                page.putField(Constant.URLS, selectable.all());
                break;
            case Constant.NUM:
                page.putField(Constant.NUM, StringUtils.chinese2Int(handleString(selectable.get(), rule)));
                break;
            default:
                page.putField(rule.getName(), handleString(selectable.get(), rule));
        }
    }

    private static String handleString(String input, Rule rule) {

        AtomicReference<String> value = new AtomicReference<>(input);
        if (rule.getPattern() != null) {
            List<KeyValue> list = JsonUtils.convertToList(rule.getPattern(), KeyValue.class);
            list.forEach(regexp -> value.updateAndGet(v -> v.replaceAll(regexp.getKey(), regexp.getValue())));
        }
        return value.get().trim();
    }
}
