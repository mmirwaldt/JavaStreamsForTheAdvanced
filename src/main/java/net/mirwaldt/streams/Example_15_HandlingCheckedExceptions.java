/*
 * Copyright (c) 2022, Michael Mirwaldt. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">
 * <img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" />
 *  </a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">
 *  Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>.
 */

package net.mirwaldt.streams;

import java.net.URL;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Example_15_HandlingCheckedExceptions {
    public static void main(String[] args) {
        List<URL> urlsFromSneakyThrow = Stream.of("http://www.wikipedia.de", "http://www.mozilla.org/")
                .map(sneakyThrow(URL::new))
                .toList();
        System.out.println(urlsFromSneakyThrow);

        System.out.println("-".repeat(120));

        List<URL> urls = Stream.of("http://www.wikipedia.de", "http://www.mozilla.org/")
                .map(unchecked(URL::new))
                .toList();
        System.out.println(urls);
    }

    public interface ExceptionFunction<T, R> {
        R apply(T t) throws Exception;
    }

    static <T, R> Function<T, R> unchecked(ExceptionFunction<T, R> f) {
        return t -> {
            try {
                return f.apply(t);
            } catch (RuntimeException ex) {
                throw ex;
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }

    static <T, R> Function<T, R> sneakyThrow(TFunction<T, R> f) {
        return t -> {
            try {
                return f.apply(t);
            } catch (Exception ex) {
                return sneaky(ex);
            }
        };
    }

    public interface TFunction<T, R> {
        R apply(T t) throws Exception;
    }

    static <T extends Exception, R> R sneaky(Exception t) throws T {
        throw (T) t;
    }
}
