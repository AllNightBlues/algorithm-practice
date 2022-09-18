/**
 * @(#) ShellSort.java 1.0 2022-09-18
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.sort;

import com.util.PrintArray;

/**
 * @ClassName ShellSort
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/09/18 10:39
 * @Version 1.0
 **/
public class ShellSort {

    public static void shellSort(int[] array) {
        int temp;
        int length = array.length;
        int incre = length;

        do {
            incre = incre / 2;
            for (int k = 0; k < incre; k++) {
                for (int i = k + incre; i < length; i += incre) {
                    for (int j = i; j > k; j -= incre) {
                        if (array[j] < array[j - incre]) {
                            temp = array[j - incre];
                            array[j - incre] = array[j];
                            array[j] = temp;
                        } else {
                            break;
                        }
                    }

                }
            }
        } while (incre != 1);
    }

    public static void main(String[] args) {
        int[] array = {86, 39, 77, 23, 32, 45, 58, 63, 93, 4, 37, 22};
        PrintArray.print(array);
        shellSort(array);
        PrintArray.print(array);
    }
}
