package com.cobrick.domain;

import io.micronaut.context.annotation.EachProperty;
import io.micronaut.context.annotation.Parameter;
import io.micronaut.context.env.Environment;

import java.util.Objects;

@EachProperty(ColorProperty.PREFIX)
public class ColorProperty {
    public static final String PREFIX = "mapping";

    private String name;
    private String value;

    public ColorProperty(@Parameter final String name, final Environment environment) {
        this.name = name;
        environment.getProperty(PREFIX.concat(".").concat(name), String.class).ifPresent(this::setValue);
    }

    public ColorProperty(final String name, final String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final ColorProperty colorProperty = (ColorProperty) obj;
        return Objects.equals(this.name, colorProperty.name) &&
                Objects.equals(this.value, colorProperty.value);
    }

    @Override
    public String toString() {
        return "ColorProperty{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
