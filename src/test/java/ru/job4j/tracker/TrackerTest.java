package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenTestFindById() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        Item item = tracker.add(bug);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenTestFindAll() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        Item result = tracker.findAll().get(0);
        assertThat(result.getName(), is(first.getName()));
    }

    @Test
    public void whenTestFindByNameCheckArrayLength() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        List<Item> result = tracker.findByName(first.getName());
        assertThat(result.size(), is(3));
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        List<Item> result = tracker.findByName(second.getName());
        assertThat(result.get(1).getName(), is(second.getName()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenTestItemAscByName() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("1-Первый"));
        items.add(new Item("3-Третий"));
        items.add(new Item("2-Второй"));
        items.add(new Item("5-Пятый"));
        items.add(new Item("4-Четвертый"));
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = new ArrayList<Item>();
        expected.add(new Item("1-Первый"));
        expected.add(new Item("2-Второй"));
        expected.add(new Item("3-Третий"));
        expected.add(new Item("4-Четвертый"));
        expected.add(new Item("5-Пятый"));
        assertEquals(expected, items);
    }

    @Test
    public void whenTestItemDescByName() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("1-Первый"));
        items.add(new Item("3-Третий"));
        items.add(new Item("2-Второй"));
        items.add(new Item("5-Пятый"));
        items.add(new Item("4-Четвертый"));
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = new ArrayList<Item>();
        expected.add(new Item("5-Пятый"));
        expected.add(new Item("4-Четвертый"));
        expected.add(new Item("3-Третий"));
        expected.add(new Item("2-Второй"));
        expected.add(new Item("1-Первый"));
        assertEquals(expected, items);
    }
}