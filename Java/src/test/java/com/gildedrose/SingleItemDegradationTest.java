package com.gildedrose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SingleItemDegradationTest {

    @Test
    public void degradeNormalItem() {
        GildedRose app = new GildedRose(new Item[] { new Item("foo", 10, 20) });
        app.updateQuality();
        Assertions.assertEquals("foo", app.items[0].name);
        Assertions.assertEquals(9, app.items[0].sellIn);
        Assertions.assertEquals(19, app.items[0].quality);
    }

    @Test
    public void degradeNormalItemPassedSellBy() {
        GildedRose app = new GildedRose(new Item[] { new Item("foo", 0, 20) });
        app.updateQuality();
        Assertions.assertEquals("foo", app.items[0].name);
        Assertions.assertEquals(-1, app.items[0].sellIn);
        Assertions.assertEquals(18, app.items[0].quality);
    }

    @Test
    public void degradeNormalItemHitsFloor() {
        GildedRose app = new GildedRose(new Item[] { new Item("foo", 10, 0) });
        app.updateQuality();
        Assertions.assertEquals("foo", app.items[0].name);
        Assertions.assertEquals(9, app.items[0].sellIn);
        Assertions.assertEquals(0, app.items[0].quality);
    }

    @Test
    public void degradeNormalItemWithQualityCorrection() {
        GildedRose app = new GildedRose(new Item[] { new Item("foo", 10, 70) });
        app.updateQuality();
        Assertions.assertEquals("foo", app.items[0].name);
        Assertions.assertEquals(9, app.items[0].sellIn);
        Assertions.assertEquals(49, app.items[0].quality);

    }

    @Test
    public void degradeAgedBrie() {
        GildedRose app = new GildedRose(new Item[] { new Item("Aged Brie", 10, 30) });
        app.updateQuality();
        Assertions.assertEquals("Aged Brie", app.items[0].name);
        Assertions.assertEquals(9, app.items[0].sellIn);
        Assertions.assertEquals(31, app.items[0].quality);
    }

    @Test
    public void degradeAgedBriePassedSellBy() {
        GildedRose app = new GildedRose(new Item[] { new Item("Aged Brie", 0, 30) });
        app.updateQuality();
        Assertions.assertEquals("Aged Brie", app.items[0].name);
        Assertions.assertEquals(-1, app.items[0].sellIn);
        Assertions.assertEquals(31, app.items[0].quality);
    }

    @Test
    public void degradeAgedBrieAtMaxQuality() {
        GildedRose app = new GildedRose(new Item[] { new Item("Aged Brie", 10, 50) });
        app.updateQuality();
        Assertions.assertEquals("Aged Brie", app.items[0].name);
        Assertions.assertEquals(9, app.items[0].sellIn);
        Assertions.assertEquals(50, app.items[0].quality);
    }

    @Test
    public void degradeBackstagePasses() {
        GildedRose app = new GildedRose(new Item[] { new Item("Backstage passes", 11, 30) });
        app.updateQuality();
        Assertions.assertEquals("Backstage passes", app.items[0].name);
        Assertions.assertEquals(10, app.items[0].sellIn);
        Assertions.assertEquals(31, app.items[0].quality);
    }

    @Test
    public void degradeBackstagePassesLessThanOrEqual10Days() {
        GildedRose app = new GildedRose(new Item[] { new Item("Backstage passes", 10, 30) });
        app.updateQuality();
        Assertions.assertEquals("Backstage passes", app.items[0].name);
        Assertions.assertEquals(9, app.items[0].sellIn);
        Assertions.assertEquals(32, app.items[0].quality);
    }

    @Test
    public void degradeBackstagePassesLessThanOrEqual5Days() {
        GildedRose app = new GildedRose(new Item[] { new Item("Backstage passes", 5, 30) });
        app.updateQuality();
        Assertions.assertEquals("Backstage passes", app.items[0].name);
        Assertions.assertEquals(4, app.items[0].sellIn);
        Assertions.assertEquals(33, app.items[0].quality);
    }

    @Test
    public void degradeBackstagePassesOnExpiration() {
        GildedRose app = new GildedRose(new Item[] { new Item("Backstage passes", 0, 30) });
        app.updateQuality();
        Assertions.assertEquals("Backstage passes", app.items[0].name);
        Assertions.assertEquals(-1, app.items[0].sellIn);
        Assertions.assertEquals(0, app.items[0].quality);
    }

    @Test
    public void degradeSulfuras() {
        GildedRose app = new GildedRose(new Item[] { new Item("Sulfuras", 0, 0) });
        app.updateQuality();
        Assertions.assertEquals("Sulfuras", app.items[0].name);
        Assertions.assertEquals(Integer.MAX_VALUE, app.items[0].sellIn);
        Assertions.assertEquals(80, app.items[0].quality);
    }

    @Test
    public void degradeConjuredItem() {
        GildedRose app = new GildedRose(new Item[] { new Item("Conjured", 10, 20) });
        app.updateQuality();
        Assertions.assertEquals("Conjured", app.items[0].name);
        Assertions.assertEquals(9, app.items[0].sellIn);
        Assertions.assertEquals(18, app.items[0].quality);
    }

    @Test
    public void degradeConjuredItemPassedSellBy() {
        GildedRose app = new GildedRose(new Item[] { new Item("Conjured", 0, 20) });
        app.updateQuality();
        Assertions.assertEquals("Conjured", app.items[0].name);
        Assertions.assertEquals(-1, app.items[0].sellIn);
        Assertions.assertEquals(16, app.items[0].quality);
    }

    @Test
    public void degradeConjuredItemHitsFloor() {
        GildedRose app = new GildedRose(new Item[] { new Item("Conjured", 10, 0) });
        app.updateQuality();
        Assertions.assertEquals("Conjured", app.items[0].name);
        Assertions.assertEquals(9, app.items[0].sellIn);
        Assertions.assertEquals(0, app.items[0].quality);
    }

}
