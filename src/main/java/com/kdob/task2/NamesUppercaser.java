package com.kdob.task2;

import java.util.Arrays;
import java.util.List;

public class NamesUppercaser {

    public List<String> uppercase(String[] extraNames) {
        return Arrays.stream(extraNames)
                .map(String::toUpperCase)
                .toList();
    }
}
