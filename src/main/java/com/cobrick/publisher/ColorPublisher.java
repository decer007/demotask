package com.cobrick.publisher;

import com.cobrick.domain.RabbitColor;
import io.micronaut.rabbitmq.annotation.Binding;
import io.micronaut.rabbitmq.annotation.RabbitClient;

@RabbitClient
public interface ColorPublisher {
    @Binding("colors")
    void publishColor(final RabbitColor color);
}
