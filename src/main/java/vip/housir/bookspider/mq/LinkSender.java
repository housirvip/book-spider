package vip.housir.bookspider.mq;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

/**
 * @author housirvip
 */
@Component
@RequiredArgsConstructor
public class LinkSender {

    private final AmqpTemplate rabbitTemplate;

    public void send(String link) {

        this.rabbitTemplate.convertAndSend(RabbitConfig.LINK, link);
    }
}
