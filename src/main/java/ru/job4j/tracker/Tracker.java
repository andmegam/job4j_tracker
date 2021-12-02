package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.size);
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[size];
        int resultPos = 0;
        for (int i = 0; i < items.length; i++) {
            Item currItem = items[i];
            if (currItem != null && currItem.getName().toLowerCase().contains(key.toLowerCase())) {
                result[resultPos] = currItem;
                resultPos++;
            }
        }
        return Arrays.copyOf(result, resultPos);
    }
}