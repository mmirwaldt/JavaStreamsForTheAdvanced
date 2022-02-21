/*
 * Copyright (c) 2022, Michael Mirwaldt. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">
 * <img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" />
 *  </a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">
 *  Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>.
 */

package net.mirwaldt.alles.im.fluss;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class Example_07_MergeMapsByMin {
    public static void main(String[] args) {
        SortedMap<Integer, Integer> leftMap = new TreeMap<>(Map.of(1, 3, 2, 1, 3, 4));
        SortedMap<Integer, Integer> rightMap = new TreeMap<>(Map.of(1, 2, 2, 3, 3, 4));
        SortedMap<Integer, Integer> mergedByMin =
                Stream.of(leftMap, rightMap)
                        .flatMap(map -> map.entrySet().stream())
                        .collect(toMap(Map.Entry::getKey,
                                Map.Entry::getValue,
                                Math::min,
                                TreeMap::new)
                        ); // result : {1=2, 2=1, 3=4}
        System.out.println(mergedByMin);
    }
}
