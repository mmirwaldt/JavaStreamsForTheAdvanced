/*
 * Copyright (c) 2022, Michael Mirwaldt. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">
 * <img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" />
 *  </a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">
 *  Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>.
 */

package net.mirwaldt.streams;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

public class Example_05_CamelCase {
    public static void main(String[] args) {
        String moduleName = "project-process-create-account";
        String camelCaseName = Arrays.stream(moduleName.split("-"))
                .skip(2)
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .collect(joining()) + "Process"; // CreateAccountProcess
        System.out.println(camelCaseName);
    }
}
