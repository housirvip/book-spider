package vip.housir.bookspider.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vip.housir.bookspider.entity.Chapter;
import vip.housir.bookspider.mapper.ChapterMapper;
import vip.housir.bookspider.service.ChapterService;

import java.util.Map;

/**
 * @author housirvip
 */
@Service
@RequiredArgsConstructor
public class ChapterServiceImpl implements ChapterService {

    private final ChapterMapper chapterMapper;

    @Override
    public int createByMap(Map<String, Object> map) {

        Chapter chapter = new Chapter();
        chapter.setTitle((String) map.get("title"));
        chapter.setContent((String) map.get("content"));

        return chapterMapper.insert(chapter);
    }
}
