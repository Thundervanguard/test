package com.hero.sort;

import java.util.Arrays;

public class IntertionSort {
    public static void main(String[] args) {
        intertionSortTest();
    }

    private static void intertionSortTest() {

        int[] array = {2, 3, 67, 34, 6, 2, 3, 65, 75, 3, 4, 23};

        int insertIndex = 0;
        int insertValue = 0;
        for(int i=1;i<array.length;i++){
            insertValue = array[i];
            insertIndex = i-1;
            while(insertIndex>=0&&insertValue<array[insertIndex]){
                //插入值小于待插入点的值，将待插入点的值后移，留下一个坑
                array[insertIndex+1] = array[insertIndex];
                insertIndex--;

            }
            //需要坑中插入
            if(insertIndex+1!=i){
                //将插入值插入到空位
                 array[insertIndex+1] = insertValue;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
