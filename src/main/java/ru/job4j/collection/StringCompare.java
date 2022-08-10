package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int minLen = Math.min(left.length(), right.length());
        int rst = 0;
        for (int i = 0; i < minLen; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                rst = Character.compare(left.charAt(i), right.charAt(i));
                break;
            }
        }
        return rst == 0 ? Integer.compare(left.length(), right.length()) : rst;
    }
}
