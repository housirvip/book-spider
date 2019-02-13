package vip.housir.bookspider.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vip.housir.bookspider.entity.Chapter;
import vip.housir.bookspider.mapper.ChapterMapper;
import vip.housir.bookspider.service.ChapterService;
import vip.housir.bookspider.spider.SpiderCache;

/**
 * @author housirvip
 */
@Service
@RequiredArgsConstructor
public class ChapterServiceImpl implements ChapterService {

    private final ChapterMapper chapterMapper;

    private final SpiderCache spiderCache;

    @Override
    public Integer create(Chapter chapter) {

        chapter.setBookId(spiderCache.getBookId(chapter.getSiteId()));

        chapterMapper.insertSelective(chapter);

        return chapter.getId();
    }
}
