package vip.housir.bookspider.service.impl;

import com.github.pagehelper.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vip.housir.bookspider.entity.Chapter;
import vip.housir.bookspider.entity.PageDto;
import vip.housir.bookspider.mapper.ChapterMapper;
import vip.housir.bookspider.service.ChapterService;

import java.util.List;

/**
 * @author housirvip
 */
@Service
@RequiredArgsConstructor
public class ChapterServiceImpl implements ChapterService {

    private final ChapterMapper chapterMapper;

    @Override
    public void create(Chapter chapter) {

        chapterMapper.insertSelective(chapter);
    }

    @Override
    public List<Chapter> allByBookId(Integer bookId) {

        return chapterMapper.allByBookId(bookId);
    }

    @Override
    public Page<Chapter> pageByBookId(Integer bookId, PageDto pageDto) {

        return (Page<Chapter>) chapterMapper.allByBookId(bookId);
    }
}
