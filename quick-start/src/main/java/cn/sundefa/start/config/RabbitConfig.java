package cn.sundefa.start.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: defa Sun
 * @Date: 2019/1/25 16:21
 */
//@Configuration
public class RabbitConfig {

    @Bean
    public Queue Queue() {
        Queue queue = new Queue("delay_message");
        return queue;
    }


    @Bean
    public CustomExchange delayExchange() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange("test_exchange", "x-delayed-message", true, false, args);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(Queue()).to(delayExchange()).with("delay_message").noargs();
    }
}
