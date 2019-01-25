package cn.sundefa.start.listener;

import cn.sundefa.start.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
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
@RabbitListener(queues = ("delay_message"))
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
