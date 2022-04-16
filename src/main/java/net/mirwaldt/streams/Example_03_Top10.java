/*
 * Copyright (c) 2022, Michael Mirwaldt. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">
 * <img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" />
 *  </a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">
 *  Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>.
 */

package net.mirwaldt.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static java.lang.String.CASE_INSENSITIVE_ORDER;
import static java.util.Collections.reverseOrder;
import static java.util.stream.Collectors.*;

public class Example_03_Top10 {
    public static void main(String[] args) throws IOException {
        // with one stream
        List<String> lines = Files.readAllLines(Path.of("rhyme.txt"));
        SortedMap<Long, List<String>> top10byOneStream = lines.stream()
                .filter(line -> !line.isEmpty())
                .map(line -> line.replaceAll("[\\!|\\.|\\-|\\,|\\;]", ""))
                .flatMap(line -> Arrays.stream(line.split("\\s+")))
                .collect(groupingBy(s -> s, () -> new TreeMap<>(CASE_INSENSITIVE_ORDER), counting()))
                .entrySet().stream()
                .sorted((left, right) -> -Long.compare(left.getValue(), right.getValue()))
                .limit(10)
                .collect(groupingBy(Map.Entry::getValue, () -> new TreeMap<>(reverseOrder()),
                        mapping(Map.Entry::getKey, toList())));
        System.out.println("top10byOneStream=" + top10byOneStream);
        System.out.println();

        // with several streams
        Map<String, Long> frequenciesByWord = lines.stream()
                .filter(line -> !line.isEmpty())
                .map(line -> line.replaceAll("[\\!|\\.|\\-|\\,|\\;]", ""))
                .flatMap(line -> Arrays.stream(line.split("\\s+")))
                .collect(groupingBy(s -> s, () -> new TreeMap<>(CASE_INSENSITIVE_ORDER), counting()));
        System.out.println("frequenciesByWord=" + frequenciesByWord);
        System.out.println();

        SortedMap<Long, List<String>> wordsByFrequency =
                frequenciesByWord.entrySet()
                        .stream()
                        .collect(groupingBy(Map.Entry::getValue, () -> new TreeMap<>(reverseOrder()),
                                mapping(Map.Entry::getKey, toList())));
        System.out.println("wordsByFrequency=" + wordsByFrequency);
        System.out.println();

        SortedMap<Long, List<String>> top10byMaps =
                wordsByFrequency.entrySet().stream()
                        .flatMap(entry -> entry.getValue().stream().map(value -> Map.of(entry.getKey(), value)))
                        .flatMap(map -> map.entrySet().stream())
                        .limit(10)
                        .collect(groupingBy(Map.Entry::getKey, () -> new TreeMap<>(reverseOrder()),
                                mapping(Map.Entry::getValue, toList())));
        System.out.println("top10byMaps=" + top10byMaps);
        System.out.println();

        // with several streams and a record
        record WordEntry(long frequency, String word) {
        }

        SortedMap<Long, List<String>> top10byRecord = wordsByFrequency.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream()
                        .map(value -> new WordEntry(entry.getKey(), value)))
                .limit(10)
                .collect(groupingBy(WordEntry::frequency,
                        () -> new TreeMap<>(reverseOrder()),
                        mapping(WordEntry::word, toList())));
        System.out.println("top10byRecord=" + top10byRecord);
    }
}
