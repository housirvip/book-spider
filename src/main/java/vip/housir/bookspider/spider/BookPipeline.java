package vip.housir.bookspider.spider;

import lombok.RequiredArgsConstructor;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import vip.housir.bookspider.entity.Book;
import vip.housir.bookspider.entity.SpiderTask;
import vip.housir.bookspider.entity.TaskType;
import vip.housir.bookspider.mq.MqSender;

import java.util.List;
import java.util.Map;

/**
 * @author housirvip
 */
@RequiredArgsConstructor
public class BookPipeline implements Pipeline {

    private final MqSender mqSender;

    @Override
    public void process(ResultItems resultItems, Task task) {

        Map<String, Object> map = resultItems.getAll();

        Book book = new Book();
        book.setName((String) map.get("name"));
        book.setCover((String) map.get("cover"));
        mqSender.send(book);

        SpiderTask spiderTask = new SpiderTask();
        spiderTask.setType(TaskType.Chapter);
        spiderTask.setUrls((List<String>) map.get("urls"));
        mqSender.send(spiderTask);
    }
}
