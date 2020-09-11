package com.cobrick.configuration;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import io.micronaut.context.annotation.Value;
import io.micronaut.rabbitmq.connect.ChannelInitializer;

import javax.inject.Singleton;
import java.io.IOException;

@Singleton
public class RabbitMQConfig extends ChannelInitializer {

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.queue}")
    private String queue;

    @Override
    public void initialize(final Channel channel) throws IOException {
        channel.exchangeDeclare(exchange, BuiltinExchangeType.DIRECT, true);
        channel.queueDeclare(queue, true, false, false, null);
        channel.queueBind(queue, exchange, queue);
    }
}
