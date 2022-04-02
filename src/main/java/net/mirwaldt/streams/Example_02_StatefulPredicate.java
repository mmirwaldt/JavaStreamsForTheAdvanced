/*
 * Copyright (c) 2022, Michael Mirwaldt. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">
 * <img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" />
 *  </a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">
 *  Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>.
 */

package net.mirwaldt.streams;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Example_02_StatefulPredicate {
    public static void main(String[] args) {
        List<Integer> lineNumbers = List.of(1, 2, 3, 5, 6, 8, 9);
        List<Integer> flawedThirds = lineNumbers.stream()
                .filter(new Predicate<>() {
                    int counter = 1;

                    public boolean test(Integer value) {
                        return counter++ % 3 == 0;
                    }
                })
                .toList();
        System.out.println(flawedThirds);

        List<Integer> betterThirds = lineNumbers.stream()
                .filter(elem -> (lineNumbers.indexOf(elem) + 1) % 3 == 0)
                .collect(Collectors.toList());
        System.out.println(betterThirds);
    }
}
