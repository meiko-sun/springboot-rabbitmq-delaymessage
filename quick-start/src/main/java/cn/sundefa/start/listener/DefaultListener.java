package cn.sundefa.start.listener;

import cn.sundefa.start.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: defa Sun
 * @Date: 2019/1/25 16:19
 */
@Component
@Slf4j
//@RabbitListener(queues = ("delay_message"))
//声明定义queues
@RabbitListener(queuesToDeclare = {@Queue(name = "delayMessage")})
@RabbitListener(bindings = {@QueueBinding(value = @Queue(name = "delayMessage"),
        //exchange
        exchange = @Exchange(name = "testExchange", arguments = {@Argument(name = "x-delayed-type", value = "direct")}, type = "x-delayed-message")
        //routingKey
        , key = "delayMessage")})
public class DefaultListener {

    @RabbitHandler
    public void process(String msg) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        log.info("receive msg: {},执行时间：{}", msg, format);
    }


    @RabbitHandler
    public void process(User user) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        log.info("receive msg: {},执行时间：{}", user, format);
    }
}
