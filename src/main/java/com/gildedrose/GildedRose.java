package com.gildedrose;

class GildedRose {
    public static final String TAFKAL_80_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) updateQuality(item);
    }

    private static void updateQuality(Item item) {
        if (!item.name.equals(AGED_BRIE)
                && !item.name.equals(TAFKAL_80_CONCERT)) {
            decreaseQualityIfNotSulfuras(item);
        } else {
            if (item.quality < 50) {
                increaseQualityIfLessThan50(item);

                if (item.name.equals(TAFKAL_80_CONCERT)) {
                    increaseQualityDependsOnSellIn(item, 11);
                    increaseQualityDependsOnSellIn(item, 6);
                }
            }
        }

        if (!item.name.equals(SULFURAS)) {
            item.sellIn--;
        }

        if (item.sellIn < 0) {
            if (!item.name.equals(AGED_BRIE)) {
                if (!item.name.equals(TAFKAL_80_CONCERT)) {
                    decreaseQualityIfNotSulfuras(item);
                } else {
                    item.quality = 0;
                }
            } else {
                increaseQualityIfLessThan50(item);
            }
        }
    }

    private static void increaseQualityDependsOnSellIn(Item item, int num) {
        if (item.sellIn < num) {
            increaseQualityIfLessThan50(item);
        }
    }

    private static void decreaseQualityIfNotSulfuras(Item item) {
        if (item.quality > 0) {
            if (!item.name.equals(SULFURAS)) {
                item.quality--;
            }
        }
    }

    private static void increaseQualityIfLessThan50(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }
}