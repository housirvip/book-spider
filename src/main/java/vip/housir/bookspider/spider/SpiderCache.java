package vip.housir.bookspider.spider;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author housirvip
 */
public class SpiderCache {

    SpiderCache() {
        bookIdContrast = Maps.newHashMap();
    }

    private Map<Integer, Integer> bookIdContrast;

    public Integer getBookId(Integer siteId) {

        return bookIdContrast.get(siteId);
    }

    public Integer saveBookId(Integer siteId, Integer bookId) {

        return bookIdContrast.put(siteId, bookId);
    }
}
