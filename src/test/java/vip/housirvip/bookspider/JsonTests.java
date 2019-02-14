package vip.housirvip.bookspider;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import vip.housir.bookspider.utils.JsonUtils;

import java.util.List;

@Slf4j
public class JsonTests {

    @Test
    public void test1() {

        String json = "[{\"key\":\"请记住本书首发域名.*[a-z.]+.*笔趣阁手机版阅读网址.*[a-z.]+\",\"value\":\"\"},{\"key\":\"http.?://[a-z.]+.*ht.*\",\"value\":\"\"},{\"key\":\"[ ]+\",\"value\":\"\\n\"}]";
        List list = JsonUtils.convertToList(json, Object.class);
        log.info(list.get(0).getClass().getName());
    }
}
