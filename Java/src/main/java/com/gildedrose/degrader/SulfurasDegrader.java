package com.gildedrose.degrader;

import com.gildedrose.Item;

public class SulfurasDegrader extends EnforcingItemDegrader {
    public SulfurasDegrader(Item item) {
        super(item);
        item.quality = 80;
        item.sellIn = Integer.MAX_VALUE;
    }
    @Override
    public void degrade() {
        // never changes
    }
}
