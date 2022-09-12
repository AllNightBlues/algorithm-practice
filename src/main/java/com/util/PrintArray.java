/**
 * @(#) PrintArray.java 1.0 2022-09-12
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.util;

import java.util.Arrays;

/**
 * @ClassName PrintArray
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/09/12 21:31
 * @Version 1.0
 **/
public class PrintArray {
    public static void print(int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println("");
    }
}
