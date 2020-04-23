package com.gildedrose.degrader;

import com.gildedrose.Item;
import lombok.Data;

@Data
public abstract class EnforcingItemDegrader implements ItemDegrader {
    protected Item item;
    protected EnforcingItemDegrader(Item item) {
        item.quality = Math.min(50, item.quality);
        item.quality = Math.max(0, item.quality);
        this.item = item;
    }
}
