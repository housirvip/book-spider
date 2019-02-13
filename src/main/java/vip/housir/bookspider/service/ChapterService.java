package vip.housir.bookspider.service;

import vip.housir.bookspider.entity.Chapter;

/**
 * @author housirvip
 */
public interface ChapterService {

    /**
     * 插入章节，返回主键
     *
     * @param chapter Chapter
     */
    void create(Chapter chapter);
}
