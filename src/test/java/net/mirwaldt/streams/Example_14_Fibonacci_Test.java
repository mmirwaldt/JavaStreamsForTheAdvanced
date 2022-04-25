/*
 * Copyright (c) 2022, Michael Mirwaldt. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">
 * <img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" />
 *  </a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">
 *  Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>.
 */

package net.mirwaldt.streams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example_14_Fibonacci_Test {
    @Test
    void test_fibonacciByLoop() {
        Assertions.assertEquals(0, Example_15_Fibonacci.fibonacciByLoop(0));
        Assertions.assertEquals(1, Example_15_Fibonacci.fibonacciByLoop(1));
        Assertions.assertEquals(1, Example_15_Fibonacci.fibonacciByLoop(2));
        Assertions.assertEquals(2, Example_15_Fibonacci.fibonacciByLoop(3));
        Assertions.assertEquals(3, Example_15_Fibonacci.fibonacciByLoop(4));
        Assertions.assertEquals(5, Example_15_Fibonacci.fibonacciByLoop(5));
        Assertions.assertEquals(8, Example_15_Fibonacci.fibonacciByLoop(6));
    }

    @Test
    void test_fibonacciByStream() {
        Assertions.assertEquals(0, Example_15_Fibonacci.fibonacciByStream(0));
        Assertions.assertEquals(1, Example_15_Fibonacci.fibonacciByStream(1));
        Assertions.assertEquals(1, Example_15_Fibonacci.fibonacciByStream(2));
        Assertions.assertEquals(2, Example_15_Fibonacci.fibonacciByStream(3));
        Assertions.assertEquals(3, Example_15_Fibonacci.fibonacciByStream(4));
        Assertions.assertEquals(5, Example_15_Fibonacci.fibonacciByStream(5));
        Assertions.assertEquals(8, Example_15_Fibonacci.fibonacciByStream(6));
    }
}
