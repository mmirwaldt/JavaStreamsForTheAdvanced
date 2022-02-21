/*
 * Copyright (c) 2022, Michael Mirwaldt. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">
 * <img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" />
 *  </a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">
 *  Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>.
 */

package net.mirwaldt.alles.im.fluss;

import org.junit.jupiter.api.Test;

import static net.mirwaldt.alles.im.fluss.Example_14_Fibonacci.fibonacciByLoop;
import static net.mirwaldt.alles.im.fluss.Example_14_Fibonacci.fibonacciByStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example_14_Fibonacci_Test {
    @Test
    void test_fibonacciByLoop() {
        assertEquals(0, fibonacciByLoop(0));
        assertEquals(1, fibonacciByLoop(1));
        assertEquals(1, fibonacciByLoop(2));
        assertEquals(2, fibonacciByLoop(3));
        assertEquals(3, fibonacciByLoop(4));
        assertEquals(5, fibonacciByLoop(5));
        assertEquals(8, fibonacciByLoop(6));
    }

    @Test
    void test_fibonacciByStream() {
        assertEquals(0, fibonacciByStream(0));
        assertEquals(1, fibonacciByStream(1));
        assertEquals(1, fibonacciByStream(2));
        assertEquals(2, fibonacciByStream(3));
        assertEquals(3, fibonacciByStream(4));
        assertEquals(5, fibonacciByStream(5));
        assertEquals(8, fibonacciByStream(6));
    }
}
