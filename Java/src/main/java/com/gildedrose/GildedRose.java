package com.gildedrose;

import com.gildedrose.degrader.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
class GildedRose {
    Item[] items;
    private List<ItemDegrader> itemDegraders = new ArrayList<>();

    public GildedRose(Item[] items) {
        this.items = items;
        this.itemDegraders = Arrays.stream(this.items).map(Factory::createItemDegrader).collect(Collectors.toList());
    }

    public void updateQuality() {
        itemDegraders.forEach(ItemDegrader::degrade);
    }

    private static class Factory {
        private static ItemDegrader createItemDegrader(Item item) {
            if (item.name.equals("Aged Brie")) {
                return new AgedBrieDegrader(item);
            }
            if (item.name.equals("Sulfuras")) {
                return new SulfurasDegrader(item);
            }
            if (item.name.equals("Backstage passes")) {
                return new BackstagePassDegrader(item);
            }
            if (item.name.equals("Conjured")) {
                return new ConjuredItemDegrader(item);
            }
            return new NormalItemDegrader(item);
        }
    }
}