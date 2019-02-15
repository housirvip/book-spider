package vip.housir.bookspider.service;

import vip.housir.bookspider.entity.SpiderTask;

/**
 * @author housirvip
 */
public interface SpiderService {

    /**
     * 向任务队列中增加任务
     *
     * @param spiderTask SpiderTask
     */
    void add(SpiderTask spiderTask);

    /**
     * 开始抓取
     *
     * @param spiderTask SpiderTask
     */
    void crawl(SpiderTask spiderTask);
}
