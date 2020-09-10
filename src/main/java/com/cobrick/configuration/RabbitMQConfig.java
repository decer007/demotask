package com.cobrick.configuration;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import io.micronaut.rabbitmq.connect.ChannelInitializer;

import javax.inject.Singleton;
import java.io.IOException;

@Singleton
public class RabbitMQConfig extends ChannelInitializer {

    @Override
    public void initialize(Channel channel) throws IOException {
        channel.exchangeDeclare("cobrick", BuiltinExchangeType.DIRECT, true);
        channel.queueDeclare("colors", true, false, false, null);
        channel.queueBind("colors", "cobrick", "colors");
    }
}
