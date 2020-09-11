package com.cobrick;

import com.cobrick.filter.ColorFilter;
import com.cobrick.domain.MyColor;
import com.cobrick.domain.RabbitColor;
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

    private final String RED = "255,0,0";
    private final String GREEN = "0,255,0";
    private final String BLUE = "0,0,255";

    final List<MyColor> testColors = new ArrayList<>();

    @Test
    public void filterOutNoData() {
        testColors.clear();
        testColors.add(new MyColor(true, RED));
        testColors.add(new MyColor(true, GREEN));
        testColors.add(new MyColor(true, BLUE));
        Stream<RabbitColor> filteredColors = colorFilter.filterColors(testColors);
        assertNotNull(filteredColors);
        assertEquals(3, filteredColors.count());
    }

    @Test
    public void filterOutSomeData() {
        testColors.clear();
        testColors.add(new MyColor(true, RED));
        testColors.add(new MyColor(true, GREEN));
        testColors.add(new MyColor(true, BLUE));
        testColors.add(new MyColor(false, ""));
        testColors.add(new MyColor(true, ""));
        testColors.add(new MyColor(true, null));
        testColors.add(new MyColor(false, BLUE));
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
        testColors.add(new MyColor(false, BLUE));
        Stream<RabbitColor> filteredColors = colorFilter.filterColors(testColors);
        assertNotNull(filteredColors);
        assertEquals(0, filteredColors.count());
    }
}
