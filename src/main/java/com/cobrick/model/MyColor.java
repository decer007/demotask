package com.cobrick.model;

import java.util.Objects;

public class MyColor {
    private boolean publish;
    private String color;

    public MyColor() {
    }

    public MyColor(boolean publish, String color) {
        this.publish = publish;
        this.color = color;
    }

    public boolean isPublish() {
        return publish;
    }

    public String getColor() {
        return color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(publish, color);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyColor color = (MyColor) obj;
        return Objects.equals(this.publish, color.publish) &&
                Objects.equals(this.color, color.color);
    }

    @Override
    public String toString() {
        return "MyColor{" +
            "publish='" + publish + '\'' +
            ", color='" + color + '\'' +
            '}';
    }
}
