package com.cobrick.model;

import io.micronaut.context.annotation.EachProperty;
import io.micronaut.context.annotation.Parameter;
import io.micronaut.context.env.Environment;

@EachProperty(ColorProperty.PREFIX)
public class ColorProperty {
    public static final String PREFIX = "mapping";

    private String name;
    private String value;

    public ColorProperty(@Parameter String name, Environment environment) {
        this.name = name;
        environment.getProperty(PREFIX.concat(".").concat(name), String.class).ifPresent(this::setValue);
    }

    public ColorProperty(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
