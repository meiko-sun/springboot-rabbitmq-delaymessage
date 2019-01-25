# springboot-rabbitmq-delaymessage

###rabbitmq版本必须为3.6x以上版本
    1.首先需要安装rabbitmq的插件
    关于RabbitMQ延迟消息的插件介绍可以查看官方网站：https://www.rabbitmq.com/blog/2015/04/16/scheduling-messages-with-rabbitmq/
    
    安装方式很简单，只需要在这个页面：http://www.rabbitmq.com/community-plugins.html 中找到rabbitmq_delayed_message_exchange插件，根据您使用的RabbitMQ版本选择对应的插件版本下载即可。
  
```jshelllanguage
    rabbitmq-plugins enable rabbitmq_delayed_message_exchange;
```
如果没有安装插件会在项目启动时候报错
```text
ERROR 159 --- [ 192.168.26.128:5672] o.s.a.r.c.CachingConnectionFactory : Channel shutdown: connection error; protocol method: #method(reply-code=503, reply-text=COMMAND_INVALID - unknown exchange type 'x-delayed-message', class-id=40, method-id=10)
```

安装好插件情况下运行该项目就可以实现rabbitmq的延时消息，实时消息可以传入的time为0即可。

#生产者在test中demo