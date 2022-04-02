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
import java.util.function.IntConsumer;

public class Example_09_MapMulti {
    public static void main(String[] args) {
        List<Object> intTree = List.of(1, List.of(2, 3), List.of(List.of(4, 5)));
        List<Integer> intList = intTree.stream()
                .mapMultiToInt(Example_09_MapMulti::visit)
                .limit(4)
                .boxed()
                .toList();
        System.out.println(intList);
    }

    public static void visit(Object node, IntConsumer downStream) {
        if (node instanceof Iterable<?> iterable) {
            for (Object e : iterable) {
                visit(e, downStream);
            }
        } else if (node instanceof Integer i) {
            downStream.accept(i);
        }
    }
}
