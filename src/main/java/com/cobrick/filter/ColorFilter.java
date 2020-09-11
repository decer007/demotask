package com.cobrick.filter;

import com.cobrick.domain.ColorProperty;
import com.cobrick.domain.MyColor;
import com.cobrick.domain.RabbitColor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Stream;

@Singleton
public class ColorFilter {

    final private List<ColorProperty> colorProperties;
    private static final Logger LOG = LoggerFactory.getLogger(ColorFilter.class);

    public ColorFilter(final List<ColorProperty> colorProperties) {
        this.colorProperties = colorProperties;
    }

    public Stream<RabbitColor> filterColors(final List<MyColor> colors) {
        return colors
            .parallelStream()
            .filter(color -> {
                if(color.getColor() == null || color.getColor().isBlank()) {
                    LOG.warn("Bad data received: " + color.toString());
                    return false;
                }
                return color.isPublish();
            }
        ).map(color -> new RabbitColor(
            colorProperties
                .parallelStream()
                .filter(colorProperty -> colorProperty.getValue().equals(color.getColor()))
                .findFirst()
                .orElse(new ColorProperty("unknown", color.getColor()))
                .getName()
                .toUpperCase()
            ));
    }
}
