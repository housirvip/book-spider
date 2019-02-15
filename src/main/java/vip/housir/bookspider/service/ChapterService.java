package vip.housir.bookspider.service;

import com.github.pagehelper.Page;
import vip.housir.bookspider.entity.Chapter;
import vip.housir.bookspider.entity.PageDto;

import java.util.List;

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

    /**
     * 根据 bookId，返回所有结果
     *
     * @param bookId Integer
     * @return List
     */
    List<Chapter> allByBookId(Integer bookId);

    /**
     * 根据 bookId，返回所有结果，支持分页
     *
     * @param bookId  Integer
     * @param pageDto PageDto
     * @return List
     */
    Page<Chapter> pageByBookId(Integer bookId, PageDto pageDto);
}
