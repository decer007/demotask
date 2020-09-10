package com.cobrick.filter;

import com.cobrick.model.ColorProperty;
import com.cobrick.model.MyColor;
import com.cobrick.model.RabbitColor;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

@Singleton
public class ColorFilter {

    final private List<ColorProperty> colorProperties;

    public ColorFilter(List<ColorProperty> colorProperties) {
        this.colorProperties = colorProperties;
    }

    public Stream<RabbitColor> filterColors(ArrayList<MyColor> colors) {
        return colors
            .parallelStream()
            .filter(color -> {
                if(color.getColor() == null || color.getColor().isBlank()) {
                    Logger.getGlobal().log(Level.WARNING, "Bad data received: " + color.toString());
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
