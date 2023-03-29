package net.oleksin.kata.kyu7.listfiltering;

import java.util.List;
import java.util.stream.Collectors;

public class ListFiltering {
    public static List<Object> filterList(final List<Object> list) {
        return list.stream()
                .filter(o -> o.getClass() != String.class)
                .collect(Collectors.toList());
    }
}
