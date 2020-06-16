package com.hero.sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[]{23,77,5,3,2,24,23,55,23,33,52,3,525,3,45,234};
        radixSortTest(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void radixSortTest(int[] arr) {

        //1.获得待排序元素的最大元素的长度  以确定最大循环的次数
        int max = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        int length = (max+"").length();
        //定义二维数组表示10个桶
        int[][] bucket = new int[10][arr.length];

        //定义一维数组表示相应桶存放的数据的个数
        int[] bucketCount = new int[10];
        for(int j = 0,n=1;j <length;j++,n*=10){

            for(int m = 0;m<arr.length;m++){
                //获得当前元素的相应位的数值
                int  digitalnum = arr[m]/n%10;

                //将其放入相应的桶中
                bucket[digitalnum][bucketCount[digitalnum]] = arr[m];
                bucketCount[digitalnum]++;
            }

            //将本轮桶中的数据按序号取出
            int index = 0;
            for(int s=0;s<10;s++){
                if(bucketCount[s]>0){
                    for(int k=0;k<bucketCount[s];k++){
                        arr[index++] = bucket[s][k];
                    }
                }
                //将桶置空
                bucketCount[s]=0;

            }
        }



   }
}
