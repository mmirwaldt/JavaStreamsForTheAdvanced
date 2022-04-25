/*
 * Copyright (c) 2022, Michael Mirwaldt. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">
 * <img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" />
 *  </a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">
 *  Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>.
 */

package net.mirwaldt.streams;

import java.util.stream.Stream;

public class Example_12_EmptyStream {
    public static void main(String[] args) {
        Stream<String> stream = Stream.<Integer>empty()
                .filter(i -> i < 3)
                .map(Integer::toBinaryString);
        System.out.println(stream); // ReferencePipeline is created although useless for the empty stream
    }
}
