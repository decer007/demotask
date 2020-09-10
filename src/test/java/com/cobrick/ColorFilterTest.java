package com.cobrick;

import com.cobrick.filter.ColorFilter;
import com.cobrick.model.MyColor;
import com.cobrick.model.RabbitColor;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@MicronautTest
public class ColorFilterTest {

    @Inject
    ColorFilter colorFilter;

    final List<MyColor> testColors = new ArrayList<>();

    @Test
    public void filterOutNoData() {
        testColors.clear();
        testColors.add(new MyColor(true, "255,0,0"));
        testColors.add(new MyColor(true, "0,255,0"));
        testColors.add(new MyColor(true, "0,0,255"));
        Stream<RabbitColor> filteredColors = colorFilter.filterColors(testColors);
        assertNotNull(filteredColors);
        assertEquals(3, filteredColors.count());
    }

    @Test
    public void filterOutSomeData() {
        testColors.clear();
        testColors.add(new MyColor(true, "255,0,0"));
        testColors.add(new MyColor(true, "0,255,0"));
        testColors.add(new MyColor(true, "0,0,255"));
        testColors.add(new MyColor(false, ""));
        testColors.add(new MyColor(true, ""));
        testColors.add(new MyColor(true, null));
        testColors.add(new MyColor(false, "0,0,255"));
        Stream<RabbitColor> filteredColors = colorFilter.filterColors(testColors);
        assertNotNull(filteredColors);
        assertEquals(3, filteredColors.count());
    }

    @Test
    public void filterOutAllData() {
        testColors.clear();
        testColors.add(new MyColor(false, ""));
        testColors.add(new MyColor(true, ""));
        testColors.add(new MyColor(true, null));
        testColors.add(new MyColor(false, "0,0,255"));
        Stream<RabbitColor> filteredColors = colorFilter.filterColors(testColors);
        assertNotNull(filteredColors);
        assertEquals(0, filteredColors.count());
    }
}
