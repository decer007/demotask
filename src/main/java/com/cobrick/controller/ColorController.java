package com.cobrick.controller;

import com.cobrick.publisher.ColorPublisher;
import com.cobrick.filter.ColorFilter;
import com.cobrick.domain.MyColor;
import com.cobrick.domain.PublishResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import java.util.List;

@Controller("/publish")
public class ColorController {

    private final ColorFilter colorFilter;
    private final ColorPublisher colorPublisher;

    public ColorController(final ColorFilter colorFilter, final ColorPublisher colorPublisher) {
        this.colorFilter = colorFilter;
        this.colorPublisher = colorPublisher;
    }

    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PublishResponse publish(@Body final List<MyColor> colors) {
        this.colorFilter.filterColors(colors)
            .forEach(colorPublisher::publishColor);
        return new PublishResponse(true);
    }
}
