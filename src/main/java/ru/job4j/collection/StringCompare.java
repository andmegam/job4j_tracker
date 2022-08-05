package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int minLen = Math.min(left.length(), right.length());
        int rst = 0;
        for (int i = 0; i < minLen; i++) {
            char chl = left.charAt(i);
            char chr = right.charAt(i);
            if (chl != chr) {
                rst = Character.compare(chl, chr);
                break;
            }
        }
        return rst == 0 ? Integer.compare(left.length(), right.length()) : rst;
    }
}
