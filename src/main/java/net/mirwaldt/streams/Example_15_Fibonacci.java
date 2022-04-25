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

public class Example_15_Fibonacci {
    public static void main(String[] args) {
        System.out.println("fibonacciByStream(6)=" + fibonacciByStream(6));
        System.out.println("fibonacciByLoop(6)=" + fibonacciByLoop(6));
    }

    public static long fibonacciByStream(int n) {
        long[] results = IntStream.rangeClosed(3, n)
                .boxed()
                .reduce(new long[]{0, 1, 1},
                        (fib, i) -> {
                            fib[i % 3] = fib[(i -1) % 3] + fib[(i - 2) % 3];
                            return fib;
                        },
                        (a, b) -> null);
        return results[n % 3];
    }

    public static long fibonacciByLoop(int n) {
        long[] fib = new long[]{0, 1, 1};
        for (int i = 3; i <= n; i++) {
            fib[i % 3] = fib[(i - 1) % 3] + fib[(i - 2) % 3];
        }
        return fib[n % 3];
    }
}
