/**
 * @(#) QuickSort.java 1.0 2022-09-12
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.sort;

import com.util.PrintArray;

/**
 * @ClassName QuickSort
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/09/12 20:38
 * @Version 1.0
 **/
public class QuickSort {

    public static int[] sortArray(int[] nums) {
        return sort(nums, 0, nums.length - 1);
    }

    public static int[] sort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) {
            return null;
        }
        int zoneIndex = partition(array, start, end);
        if (zoneIndex > start) {
            sort(array, start, end);
        }
        if (zoneIndex < end) {
            sort(array, zoneIndex + 1, end);
        }
        return array;
    }

    private static int partition(int[] array, int start, int end) {
        if (start == end) return start;
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int zoneIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++) {
            if (array[i] <= array[end]) {
                zoneIndex++;
                if (i > zoneIndex)
                    swap(array, i, zoneIndex);
            }
        }
        return zoneIndex;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {86, 39, 77, 23, 32, 45, 58, 63, 93, 4, 37, 22};
        PrintArray.print(array);
        sortArray(array);
        PrintArray.print(array);
    }
}
