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

public class Example_13_TransposeMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println(Arrays.deepToString(matrix)
                .replace("], ", "]\n")
                .replace("[[", "[")
                .replace("]]", "]"));

        for (int r = 1; r < matrix.length; r++) {
            for (int c = 0; c < r; c++) {
                int temp = matrix[c][r];
                matrix[c][r] = matrix[r][c];
                matrix[r][c] = temp;
            }
        }

        System.out.println("-".repeat(120));

        System.out.println(Arrays.deepToString(matrix)
                .replace("], ", "]\n")
                .replace("[[", "[")
                .replace("]]", "]"));
    }
}
