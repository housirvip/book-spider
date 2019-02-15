package vip.housir.bookspider.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vip.housir.bookspider.entity.Book;
import vip.housir.bookspider.entity.Chapter;
import vip.housir.bookspider.entity.PageDto;
import vip.housir.bookspider.service.BookService;
import vip.housir.bookspider.service.ChapterService;

import java.util.List;

/**
 * @author housirvip
 */
@RestController
@RequestMapping(value = "/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final ChapterService chapterService;

    @GetMapping(value = "/{id}")
    public Book one(@PathVariable Integer id) {

        Book book = bookService.oneById(id);
        List<Chapter> chapters = chapterService.allByBookId(id);
        chapters.forEach(chapter -> chapter.setContent(null));
        book.setChapters(chapters);
        return book;
    }

    @GetMapping(value = "/{id}/content")
    public Book oneWithContent(@PathVariable Integer id,
                               @RequestParam Integer pageNum,
                               @RequestParam Integer pageSize) {

        Book book = bookService.oneById(id);
        book.setChapters(chapterService.pageByBookId(id, new PageDto(pageNum, pageSize)));
        return book;
    }
}
