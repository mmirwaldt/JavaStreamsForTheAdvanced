/*
 * Copyright (c) 2022, Michael Mirwaldt. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">
 * <img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" />
 *  </a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">
 *  Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>.
 */

package net.mirwaldt.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Example_01_ForeachWrite {
    public static void main(String[] args) {
        Set<Integer> acceptable = Set.of(1, 2, 3, 5, 6, 7, 9, 11);
        Set<Integer> inputs = Set.of(0, 2, 3, 4, 8, 9);

        List<Integer> flawed = new ArrayList<>();
        inputs.stream()
                .filter(acceptable::contains) // OK
                .forEach(flawed::add); // NO!
        System.out.println(flawed);

        List<Integer> better = inputs.stream()
                .filter(acceptable::contains)
                .toList();
        System.out.println(better);
    }
}
