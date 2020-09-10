package com.cobrick.model;

import java.util.Objects;

public class PublishResponse {
    private boolean published;

    public PublishResponse() {
    }

    public PublishResponse(boolean published) {
        this.published = published;
    }

    public boolean isPublished() {
        return published;
    }

    @Override
    public int hashCode() {
        return Objects.hash(published);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PublishResponse publishResponse = (PublishResponse) obj;
        return Objects.equals(this.published, publishResponse.published);
    }

    @Override
    public String toString() {
        return "PublishResponse{" +
                "published='" + published + '\'' +
                '}';
    }
}
