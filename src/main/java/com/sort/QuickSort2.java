/**
 * @(#) QuickSort2.java 1.0 2022-09-15
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.sort;

import com.util.PrintArray;

/**
 * @ClassName QuickSort2
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/09/15 20:14
 * @Version 1.0
 **/
public class QuickSort2 {

    static void quickSort(int[] s, int l, int r) {
        if (l < r) {
            int i = l, j = r, x = s[l];
            while (i < j) {
                while (i < j && s[j] >= x) {
                    j--;
                }
                if (i < j) {
                    s[i++] = s[j];
                }
                while (i < j && s[i] < x) {
                    i++;
                }
                if (i < j) {
                    s[j--] = s[i];
                }
            }
            s[i] = x;
            quickSort(s, l, i - 1);
            quickSort(s, i + 1, r);
        }
    }

    public static void main(String[] args) {
        int[] array = {86, 39, 77, 23, 32, 45, 58, 63, 93, 4, 37, 22};
        PrintArray.print(array);
        quickSort(array, 0, array.length - 1);
        PrintArray.print(array);
    }
}
