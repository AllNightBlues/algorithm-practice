/**
 * @(#) GameBagV2.java 1.0 2022-09-27
 * Copyright (c) 2022, YUNXI. ALL right reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.dp;

import java.util.Set;

/**
 * @ClassName GameBagV2
 * @description: remove ArrayElement
 * @AUTHOR AllNightBlues
 * @Date 2022/09/27 15:47
 * @Version 1.0
 **/
public class GameBagV2 {

    private static class Element {
        private String name;
        private int value;
        private int cost;

        public Element(String name, int value, int cost) {
            this.name = name;
            this.value = value;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "name='" + name + '\'' +
                    ", value=" + value +
                    ", cost=" + cost +
                    '}';
        }
    }

    public void printArray(int arrayX, int arrayY, int[][] calcArray) {
        for (int i = 0; i < arrayX; i++) {
            for (int j = 0; j < arrayY; j++) {
                System.out.print("[i=" + i + "," + "j=" + j + "=" + calcArray[i][j]);
            }
            System.out.println();
        }
    }

    public void putBag(Element[] goods, int bagSize) {
        int arrayX = goods.length + 1;
        int arrayY = bagSize + 1;
        int[][] calcArray = new int[arrayX][arrayY];
        for (int i = 0; i < arrayX; i++) {
            for (int j = 0; j < arrayY; j++) {
                if (i == 0 || j == 0) {
                    //processing first data row
                    calcArray[i][j] = 0;
                } else {
                    //index of current goods
                    int goodsIndex = i - 1;
                    int preRow = i - 1;
                    int preRowValue = calcArray[preRow][j];
                    int spareSpace = j - goods[goodsIndex].cost;
                    if (spareSpace < 0) {
                        calcArray[i][j] = calcArray[preRow][j];
                    } else {
                        int currentGoodsValue = goods[goodsIndex].value;
                        currentGoodsValue += calcArray[preRow][spareSpace];
                        calcArray[i][j] = Math.max(preRowValue, currentGoodsValue);
                    }
                }
            }
        }
    }



}
