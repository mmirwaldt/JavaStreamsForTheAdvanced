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
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Example_13_Iterator {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 6, 8, 9));
        ListIterator<Integer> iterator = ints.listIterator();
        int i = 1;
        while (iterator.hasNext()) {
            iterator.next();
            if(i % 3 == 0) { iterator.remove(); }
            i++;
        }
        System.out.println(ints);
    }
}
