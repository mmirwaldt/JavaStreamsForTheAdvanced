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

public class Example_11_BadForeach {
    public static void main(String[] args) {
        List<Integer> ints = List.of(1,2,3,5,6,8,9);

        // flawed
        System.out.println("-".repeat(120));
        ints.stream().forEach(i -> {
            System.out.println(i);
            System.out.println("-".repeat(120));
        });

        // better
        System.out.println("-".repeat(120));
        for (Integer i : ints) {
            System.out.println(i);
            System.out.println("-".repeat(120));
        }
    }
}
