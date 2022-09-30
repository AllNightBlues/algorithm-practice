/**
 * @(#) GameBagV3.java 1.0 2022-09-28
 * Copyright (c) 2022, YUNXI. ALL right reserved.
 * YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.dp;

/**
 * @ClassName GameBagV3
 * @description: use 1D array only
 * @AUTHOR AllNightBlues
 * @Date 2022/09/28 09:37
 * @Version 1.0
 **/
public class GameBagV3 {

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

    public void putBag(Element[] goods, int bagSize) {
        int[] calcArray = new int[bagSize + 1];
        calcArray[0] = 0;
        for (int goodsIndex = 0; goodsIndex < goods.length; goodsIndex++) {
            int goodsCost = goods[goodsIndex].cost;
            for (int currentSize = bagSize; currentSize > 0; currentSize--) {
                if (currentSize >= goodsCost) {
                    calcArray[currentSize] = Math.max(calcArray[currentSize - goodsCost] + goods[goodsIndex].value,
                            calcArray[currentSize]);
                }
            }
        }
    }
}
