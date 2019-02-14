package vip.housirvip.bookspider;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import vip.housir.bookspider.entity.Book;
import vip.housir.bookspider.utils.JsonUtils;
import vip.housir.bookspider.utils.StringUtils;

import java.util.concurrent.atomic.AtomicReference;

@Slf4j
public class StringUtilsTest {

    @Test
    public void test() {

        assert "第八八六章".replaceAll("[第章]", "").equals("八八六");

        assert StringUtils.chinese2Int("八八六") == 886;
        assert StringUtils.chinese2Int("三八") == 38;
        assert StringUtils.chinese2Int("一三四六") == 1346;
    }

    @Test
    public void testRegexp() {

        String res = "https://www.biqiuge.com/book/16513/".replaceAll("http.+/[a-z]+/([0-9]+)/?.*", "$1");

        log.info(res);
    }

    @Test
    public void testJson() {

        Book book = new Book();
        book.setName("asd");

        log.info(JsonUtils.convertToString(book));
    }

    @Test
    public void testClass() {

        AtomicReference<String> value = new AtomicReference<>("asd");

        String res = value.updateAndGet(v -> v.replace("a", "1"));

        log.info(res);
        log.info(value.get());
    }

    @Test
    public void testChineseInt() {

        log.info(String.valueOf(StringUtils.chinese2Int("1055")));
        log.info(String.valueOf(StringUtils.chinese2Int("三零四六")));
        log.info(String.valueOf(StringUtils.chinese2Int("奥术大师多一百")));
        log.info(String.valueOf(StringUtils.chinese2Int("奥术一千大师")));
        log.info(String.valueOf(StringUtils.chinese2Int("一千五百")));
        log.info(String.valueOf(StringUtils.chinese2Int("一千五百六十")));
        log.info(String.valueOf(StringUtils.chinese2Int("一千五百六十三")));
    }
}
