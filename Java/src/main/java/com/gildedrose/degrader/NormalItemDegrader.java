package com.gildedrose.degrader;

import com.gildedrose.Item;

public class NormalItemDegrader extends EnforcingItemDegrader {
    public NormalItemDegrader(Item item) {
        super(item);
    }
    public void degrade() {
        item.sellIn--;
        item.quality = item.sellIn < 0 ? item.quality - 2 : item.quality - 1;
        item.quality = Math.max(0, item.quality);
    }
}
