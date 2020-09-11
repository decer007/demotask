package com.cobrick.publisher;

import com.cobrick.domain.RabbitColor;
import io.micronaut.rabbitmq.annotation.Binding;
import io.micronaut.rabbitmq.annotation.RabbitClient;

@RabbitClient
public interface ColorPublisher {
    @Binding("${rabbitmq.queue}")
    void publishColor(final RabbitColor color);
}
