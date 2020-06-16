package com.hero.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        //shellSortTest();
        shellSortTest1();
    }

    private static void shellSortTest1() {
        int[] array = {2, 3, 67, 34, 6, 2, 3, 65, 75, 3, 4, 23};
        //定义总循环次数
        for(int grap=array.length/2;grap>0;grap/=2){
            for(int i =grap;i< array.length;i++){
                int j  =i;
                int temp = array[j];
                if(array[j]<array[j-grap]){
                    //需要插入
                    while(j-grap>=0&&temp>array[j-grap]){
                        array[j] = array[j-grap];
                        j-=grap;
                    }
                array[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    private static void shellSortTest() {

        int[] array = {2, 3, 67, 34, 6, 2, 3, 65, 75, 3, 4, 23};

        //定义总循环次数
        for(int grap =array.length/2;grap>0;grap/=2){
            for(int i=grap;i<array.length;i++){
                for(int j=i-grap;j>=0;j-=grap){
                    if(array[j]>array[j+grap]){
                        int temp = array[j];
                        array[j] = array[j+grap];
                        array[j+grap] = temp;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }
}
