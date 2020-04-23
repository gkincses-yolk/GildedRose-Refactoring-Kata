package com.gildedrose.degrader;

import com.gildedrose.Item;

public class ConjuredItemDegrader extends EnforcingItemDegrader {
    public ConjuredItemDegrader(Item item) {
        super(item);
    }
    @Override
    public void degrade() {
        item.sellIn--;
        item.quality = item.sellIn < 0 ? item.quality - 4 : item.quality - 2;
        item.quality = Math.max(0, item.quality);
    }
}
