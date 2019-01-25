package cn.sundefa.start.service;

import cn.sundefa.start.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestServiceTest {

    @Autowired
    AmqpTemplate amqpTemplate;

    @Test
    public void mqTest() {

        for (int i = 0; i < 10; i++) {
            String a = "this is a string delay message,key:" + i;
            Integer time = i * 5000;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = sdf.format(new Date());
            amqpTemplate.convertAndSend("test_exchange", "delay_message", a, (MessagePostProcessor) message -> {
                message.getMessageProperties().setHeader("x-delay", time);
                return message;
            });
            System.out.println("发送消息成功第" + i + "条消息时间：" + format);
        }
    }


    @Test
    public void mqEntityTest() {

        for (int i = 0; i < 10; i++) {

            Integer time = i * 5000;
            User user = User.builder().userId("123").age("23").creatTime(new Date()).name("44444").build();
            amqpTemplate.convertAndSend("test_exchange", "delay_message", user, (MessagePostProcessor) message -> {
                message.getMessageProperties().setHeader("x-delay", time);
                return message;
            });
        }
    }
}