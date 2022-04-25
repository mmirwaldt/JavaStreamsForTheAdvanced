/*
 * Copyright (c) 2022, Michael Mirwaldt. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">
 * <img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" />
 *  </a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">
 *  Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>.
 */

package net.mirwaldt.streams;

import java.util.stream.IntStream;

public class Example_09_First100Primes {
    public static void main(String[] args) {
        var first100Primes = IntStream.iterate(2, i -> i + 1)
                .filter(i -> isPrime(i))
                .limit(100)
                .boxed().toList();
        System.out.println(first100Primes);
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return 1 < n;
    }
}
