package vip.housir.bookspider.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vip.housir.bookspider.common.Constant;

/**
 * @author housirvip
 */
@Configuration
public class RabbitConfig {

    static final String BOOK = Constant.BOOK;
    static final String CHAPTER = Constant.CHAPTER;
    static final String TASK = Constant.TASK;

    @Bean
    public Queue book() {
        return new Queue(BOOK);
    }

    @Bean
    public Queue chapter() {
        return new Queue(CHAPTER);
    }

    @Bean
    public Queue task() {
        return new Queue(TASK);
    }
}
