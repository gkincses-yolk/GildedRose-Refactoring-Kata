package com.gildedrose.degrader;

import com.gildedrose.Item;

public class AgedBrieDegrader extends EnforcingItemDegrader {
    public AgedBrieDegrader(Item item) {
        super(item);
    }
    @Override
    public void degrade() {
        item.sellIn--;
        item.quality  = Math.max(0, item.quality);
        item.quality++;
        item.quality = Math.min(50, item.quality);
    }

}
