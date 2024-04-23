package com.gildedrose;

import static com.gildedrose.GildedRoseItem.AGED_BRIE;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) gildedRoseItem(item).updateQuality();
    }

    private static GildedRoseItem gildedRoseItem(Item item) {
        if (item.name.equals(AGED_BRIE)) {
            return new AgedBrie(item);
        }
        return new GildedRoseItem(item);
    }


}