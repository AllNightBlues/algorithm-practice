/**
 * @(#) InsertionSort2.java 1.0 2022-09-18
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.sort;

import com.util.PrintArray;

/**
 * @ClassName InsertionSort2
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/09/18 10:33
 * @Version 1.0
 **/
public class InsertionSort2 {

    public static void insertionSort(int array[]) {
        int temp;
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {86, 39, 77, 23, 32, 45, 58, 63, 93, 4, 37, 22};
        PrintArray.print(array);
        insertionSort(array);
        PrintArray.print(array);
    }
}
