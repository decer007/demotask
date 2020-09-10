package com.cobrick.model;

import java.util.Objects;

public class RabbitColor {
    private String color;

    public RabbitColor() {
    }

    public RabbitColor(final String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final RabbitColor rabbitColor = (RabbitColor) obj;
        return Objects.equals(this.color, rabbitColor.color);
    }

    @Override
    public String toString() {
        return "RabbitColor{" +
            "color='" + color + '\'' +
            '}';
    }
}
