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

    public boolean replace(int id, Item item) {
        boolean rsl = false;
        int index = indexOf(id);
        if (index >= 0) {
            item.setId(id);
            items[index] = item;
            rsl = true;
        }
        return rsl;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
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