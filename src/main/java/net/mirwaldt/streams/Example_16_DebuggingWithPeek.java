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

public class Example_16_DebuggingWithPeek {
    public static void main(String[] args) {
        var list = List.of(2, 3, 5, 7, 11, 13, 17, 19);
        var result = list.stream()
                .filter(i -> i < 14)
                .peek(i -> System.out.println("after filter(): " + i))
                .map(Integer::toBinaryString)
                .peek(i -> System.out.println("after map(): " + i))
                .toList();
        System.out.println(result);
    }
}
