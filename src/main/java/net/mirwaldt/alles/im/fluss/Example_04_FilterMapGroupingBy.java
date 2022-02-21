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

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class Example_04_FilterMapGroupingBy {
    public static void main(String[] args) {
        var names = List.of("Heinz", "Michael", "Brian", "Marc", "Kurt");
        var selectedUpperCaseNamesByFirstLetter = names.stream()
                        .filter(name -> 'J' <= name.charAt(0)) // range J-Z
                        .map(String::toUpperCase)
                        .collect(groupingBy(name -> name.substring(0, 1), toList()));
        System.out.println(selectedUpperCaseNamesByFirstLetter);
    }
}
