package vip.housir.bookspider.mq;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;
import vip.housir.bookspider.entity.Book;
import vip.housir.bookspider.entity.Chapter;
import vip.housir.bookspider.entity.SpiderTask;
import vip.housir.bookspider.utils.JsonUtils;

/**
 * @author housirvip
 */
@Component
@RequiredArgsConstructor
public class MqSender {

    private final AmqpTemplate rabbitTemplate;

    public void send(Book book) {

        this.rabbitTemplate.convertAndSend(RabbitConfig.BOOK, JsonUtils.convertToString(book));
    }

    public void send(Chapter chapter) {

        this.rabbitTemplate.convertAndSend(RabbitConfig.CHAPTER, JsonUtils.convertToString(chapter));
    }

    public void send(SpiderTask spiderTask) {

        this.rabbitTemplate.convertAndSend(RabbitConfig.TASK, JsonUtils.convertToString(spiderTask));
    }
}
