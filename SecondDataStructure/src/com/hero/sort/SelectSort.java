package com.hero.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        selectSortTest();
    }

    private static void selectSortTest() {
        int[] array = {2, 3, 67, 34, 6, 2, 3, 65, 75, 3, 4, 23};

        for(int i=0;i<array.length;i++){
           int minIndex  =i;
           int min = array[i];
           for(int j=i+1;j<array.length;j++){
               if(min>array[j]){
                   minIndex = j;
                   min = array[j];
               }
           }
           if(minIndex!=i){
               array[minIndex] = array[i];
               array[i]=min;

           }

        }
        System.out.println(Arrays.toString(array));
    }
}
