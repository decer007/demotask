package com.cobrick.controller;

import com.cobrick.client.ColorClient;
import com.cobrick.filter.ColorFilter;
import com.cobrick.model.MyColor;
import com.cobrick.model.PublishResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import java.util.ArrayList;

@Controller("/publish")
public class ColorController {

    private final ColorFilter colorFilter;
    private final ColorClient colorClient;

    public ColorController(ColorFilter colorFilter, ColorClient colorClient) {
        this.colorFilter = colorFilter;
        this.colorClient = colorClient;
    }

    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PublishResponse publish(@Body ArrayList<MyColor> colors) {
        this.colorFilter.filterColors(colors)
            .forEach(colorClient::publishColor);
        return new PublishResponse(true);
    }
}
