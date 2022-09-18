/**
 * @(#) InsertionSort.java 1.0 2022-09-18
 * Copyright (c) 2022, AllNightBlues. ALL right reserved.
 * AllNightBlues PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.sort;

import com.util.PrintArray;

/**
 * @ClassName InsertionSort
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/09/18 10:24
 * @Version 1.0
 **/
public class InsertionSort {

    public static int[] sortArray(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        int currentValue;
        for (int i = 0; i < nums.length - 1; i++) {
            int preIndex = i;
            currentValue = nums[preIndex + 1];
            while (preIndex >= 0 && currentValue < nums[preIndex]) {
                nums[preIndex + 1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex + 1] = currentValue;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] array = {86, 39, 77, 23, 32, 45, 58, 63, 93, 4, 37, 22};
        PrintArray.print(array);
        sortArray(array);
        PrintArray.print(array);
    }
}
