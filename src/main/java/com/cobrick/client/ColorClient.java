package com.cobrick.client;

import com.cobrick.model.RabbitColor;
import io.micronaut.rabbitmq.annotation.Binding;
import io.micronaut.rabbitmq.annotation.RabbitClient;

@RabbitClient
public interface ColorClient {
    @Binding("colors")
    void publishColor(RabbitColor color);
}
