package vip.housir.bookspider.spider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import vip.housir.bookspider.entity.Chapter;
import vip.housir.bookspider.mq.MqSender;

import java.util.Map;

/**
 * @author housirvip
 */
@Slf4j
@RequiredArgsConstructor
public class ChapterPipeline implements Pipeline {

    private final MqSender mqSender;

    @Override
    public void process(ResultItems resultItems, Task task) {

        Map<String, Object> map = resultItems.getAll();

        Chapter chapter = new Chapter();
        chapter.setTitle((String) map.get("title"));
        chapter.setContent((String) map.get("content"));
        chapter.setNum((Integer) map.get("num"));
        chapter.setSiteId((Integer) map.get("siteId"));

        mqSender.send(chapter);
    }
}
