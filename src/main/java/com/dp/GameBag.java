/**
 * @(#) GameBag.java 1.0 2022-09-27
 * Copyright (c) 2022, YUNXI. ALL right reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.dp;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName GameBag
 * @description:
 * @AUTHOR AllNightBlues
 * @Date 2022/09/27 11:42
 * @Version 1.0
 **/
public class GameBag {

    private static class ArrayElement {
        private int value;
        private Set<Element> elements;

        public ArrayElement(int value, Set<Element> elements) {
            this.value = value;
            this.elements = elements;
        }

        public ArrayElement(int value, Element element) {
            this.value = value;
            this.elements = new HashSet<>();
            elements.add(element);
        }

        @Override
        public String toString() {
            return "ArrayElement{" +
                    "value=" + value +
                    ", elements=" + elements +
                    '}';
        }
    }

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

    public void printArray(Element[] goods, int bagSize, ArrayElement[][] calc) {
        for (int i = 0; i < goods.length; i++) {
            for (int j = 0; j < bagSize; j++) {
                System.out.print("i=" + i + ",j=" + j + "," + calc[i][j]);
            }
        }
    }

    public void printRow(int rowNo, int bagSize, ArrayElement[][] calc) {
        System.out.println("当前行号:" + rowNo);
        for (int j = 0; j < bagSize; j++) {
            if (calc[rowNo][j] != null) {
                System.out.println("j=" + j + "," + calc[rowNo][j] + " ");
            }
        }
        System.out.println();
    }

    public void putBag(Element[] goods, int bagSize) {
        ArrayElement[][] calcArray = new ArrayElement[goods.length][bagSize];
        for (int i = 0; i < goods.length; i++) {
            for (int j = 0; j < bagSize; j++) {
                if (i == 0) {
                    //processing first data row
                    calcArray[i][j] = new ArrayElement(goods[i].value, goods[i]);
                } else {
                    int spareSpace = j + 1 - goods[i].cost;
                    if (spareSpace < 0) {
                        calcArray[i][j] = calcArray[i - 1][j];
                    } else {
                        int preRow = i - 1;
                        int preRowValue = calcArray[i - 1][j].value;
                        int currentGoodsValue = goods[i].value;
                        if (spareSpace > 0) {
                            currentGoodsValue += calcArray[preRow][spareSpace - 1].value;
                        }
                        if (preRowValue >= currentGoodsValue) {
                            calcArray[i][j] = calcArray[preRowValue][j];
                        } else {
                            if (spareSpace == 0) {
                                calcArray[i][j] = new ArrayElement(currentGoodsValue, goods[i]);
                            } else {
                                //spareSpace bigger than zero then add the biggest value of spareSpace
                                Set<Element> newElement = calcArray[preRow][spareSpace - 1].elements;
                                newElement.add(goods[i]);
                                calcArray[i][j] = new ArrayElement(currentGoodsValue, newElement);

                            }
                        }
                    }
                }
            }
        }
    }
}
