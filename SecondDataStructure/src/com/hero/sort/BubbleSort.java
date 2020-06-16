package com.hero.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        bubbleTest();
    }

    private static void bubbleTest() {
        int[] array = new int[]{4,3,2,5,3,6,7,845,22,34,34,23,65};

        for(int i=0;i<array.length;i++){
            for(int j=1;j<array.length-i;j++){
                if(array[j]>array[j-1]){
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }

            }
        }
        System.out.println(Arrays.toString(array));
    }
}
