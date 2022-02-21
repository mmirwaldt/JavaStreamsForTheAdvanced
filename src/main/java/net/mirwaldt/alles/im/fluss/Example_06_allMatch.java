/*
 * Copyright (c) 2022, Michael Mirwaldt. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">
 * <img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" />
 *  </a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">
 *  Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>.
 */

package net.mirwaldt.alles.im.fluss;

import java.util.List;

public class Example_06_allMatch {
    public static void main(String[] args) {
        var numbersAsStrings = List.of("1", "2", "3", "5", "6", "8", "11");
        System.out.println(String.join(" + ", numbersAsStrings) + " = " + parseAndSum(numbersAsStrings));
    }

    public static int parseAndSum(List<String> numbersAsStrings) {
        if (numbersAsStrings.stream().allMatch(str -> str.matches("-?\\d+"))) {
            return numbersAsStrings.stream()
                    .mapToInt(Integer::parseInt)
                    .sum();
        } else {
            String nonInt = numbersAsStrings.stream()
                    .filter(str -> !str.matches("-?\\d+"))
                    .findFirst().get();
            throw new IllegalArgumentException("'" + nonInt + "' is not an integer.");
        }
    }
}
