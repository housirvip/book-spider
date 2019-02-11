package vip.housir.bookspider.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author housirvip
 */
@Configuration
public class RabbitConfig {

    static final String BOOK = "book";
    static final String CHAPTER = "chapter";

    @Bean
    public Queue book() {

        return new Queue(BOOK);
    }

    @Bean
    public Queue chapter() {

        return new Queue(CHAPTER);
    }
}
