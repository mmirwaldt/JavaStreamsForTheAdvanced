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
import static java.util.Collections.emptyMap;
import static java.util.Collections.reverseOrder;
import static java.util.stream.Collectors.*;

/*
    This variation of Example_03_Top10 does not just take the first elements of the last word list and ignores the rest
    but includes all elements. This might lead to a top 10 with 11 elements because the 10th and 11th element have both
    the same frequency.
    E.g.
    ...
    top10={42=[the], 39=[swallowed], 38=[she], 23=[to], 21=[catch], 14=[a, fly, that], 13=[and], 12=[spider, wiggled]}
    top09={42=[the], 39=[swallowed], 38=[she], 23=[to], 21=[catch], 14=[a, fly, that], 13=[and]}
    top08={42=[the], 39=[swallowed], 38=[she], 23=[to], 21=[catch], 14=[a, fly, that]}
    top07={42=[the], 39=[swallowed], 38=[she], 23=[to], 21=[catch], 14=[a, fly, that]}
    top06={42=[the], 39=[swallowed], 38=[she], 23=[to], 21=[catch], 14=[a, fly, that]}
    top05={42=[the], 39=[swallowed], 38=[she], 23=[to], 21=[catch]}
    ...

    This was my first (flawed) attempt to find a solution.
 */
public class Example_03a_Top10 {
    public static void main(String[] args) throws IOException {
        // with one stream
        List<String> lines = Files.readAllLines(Path.of("rhyme.txt"));
        SortedMap<Long, List<String>> top10Plus = lines.stream()
                .filter(line -> !line.isEmpty())
                .map(line -> line.replaceAll("[\\!|\\.|\\-|\\,|\\;]", ""))
                .flatMap(line -> Arrays.stream(line.split("\\s+")))
                .collect(groupingBy(s -> s, () -> new TreeMap<>(CASE_INSENSITIVE_ORDER), counting()))
                .entrySet().stream()
                .collect(groupingBy(Map.Entry::getValue, () -> new TreeMap<>(reverseOrder()),
                        mapping(Map.Entry::getKey, toList())))
                .entrySet().stream()
                .map(entry -> Map.of(entry.getKey(), entry.getValue()))
                .collect(() -> new TreeMap<>(reverseOrder()),
                        (result, map) -> result.putAll((10 <= result.values().stream().mapToLong(List::size).sum())
                                ? emptyMap() : map),
                        TreeMap::putAll);
        System.out.println("top10=" + top10Plus);
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

        SortedMap<Long, List<String>> onlyTop10Plus =
                wordsByFrequency.entrySet().stream()
                        .map(entry -> Map.of(entry.getKey(), entry.getValue()))
                        .collect(() -> new TreeMap<>(reverseOrder()),
                                (result, map) ->
                                        result.putAll((10 <= result.values().stream().mapToLong(List::size).sum())
                                                ? emptyMap() : map),
                                TreeMap::putAll);
        System.out.println("onlyTop10=" + onlyTop10Plus);
        System.out.println();
    }
}
