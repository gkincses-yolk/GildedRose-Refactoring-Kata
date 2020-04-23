package com.gildedrose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MultipleItemDegradationTest {

    @Test
    public void degradeTwoItems() {
        GildedRose app = new GildedRose(
                new Item[] {
                        new Item("Normal", 0, 20),
                        new Item("Conjured", 0, 20)
                }
            );
        app.updateQuality();
        Assertions.assertEquals(2, app.items.length);
        Assertions.assertEquals("Normal", app.items[0].name);
        Assertions.assertEquals(-1, app.items[0].sellIn);
        Assertions.assertEquals(18, app.items[0].quality);
        Assertions.assertEquals("Conjured", app.items[1].name);
        Assertions.assertEquals(-1, app.items[1].sellIn);
        Assertions.assertEquals(16, app.items[1].quality);
    }

}
