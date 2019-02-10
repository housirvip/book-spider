package vip.housir.bookspider.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author housirvip
 */
@Configuration
public class RabbitConfig {

    static final String LINK = "LINK";

    @Bean
    public Queue link() {
        return new Queue(LINK);
    }
}
