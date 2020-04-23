package com.gildedrose.degrader;

import com.gildedrose.Item;

public class BackstagePassDegrader extends EnforcingItemDegrader {
    public BackstagePassDegrader(Item item) {
        super(item);
    }
    @Override
    public void degrade() {
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = 0;
        } else if (item.sellIn < 5) {
            item.quality += 3;
        } else if (item.sellIn < 10) {
            item.quality += 2;
        } else {
            item.quality += 1;
        }
        item.quality = Math.min(50, item.quality);
    }
}
