package vip.housir.bookspider.service;

import vip.housir.bookspider.entity.SpiderTask;

/**
 * @author housirvip
 */
public interface SpiderService {

    /**
     * 开始抓取
     *
     * @param spiderTask SpiderTask
     */
    void crawl(SpiderTask spiderTask);
}
