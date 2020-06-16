package com.hero.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
   /*     int[] arr = {3,4,3,54,345};

        int len = arr.length;
        int[] temp = new int[len];
        mergedivide(arr,0,len-1,temp);
        System.out.println(Arrays.toString(arr));*/
        int[] arr = {1,2,4,7,4,3,5,4,64,6,443,3};
        int[] temp = new int[arr.length];
        mergedivide(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }

    //分-治的过程
    public static void mergedivide(int[] arr, int left, int right, int[] temp) {

        if(left<right){

            //获取中间值
            int mid = (right+left)/2;
            
            //向左递归
            mergedivide(arr,left,mid,temp);
            
            //向右递归
            mergedivide(arr,mid+1,right,temp);
            
            //合并的过程
            merge(arr,left,mid,right,temp);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {

        //初始化左边序列的索引
        int i = left;
        //初始化右边序列的索引
        int j = mid +1;

        //初始化临时序列的索引
        int tmp = 0;

        while(i<=mid&&j<=right){
            //左边序列比右边序列大
            if(arr[i]<arr[j]){
                temp[tmp] = arr[i];
                i+=1;
                tmp+=1;
            }else{
                temp[tmp] = arr[j];
                j+=1;
                tmp+=1;
            }
        }

        //如果左边序列有剩余，直接填充到temp中
        while(i<=mid){
            temp[tmp] = arr[i];
            i+=1;
            tmp+=1;
        }
        //如果右边序列有剩余，直接填充到temp中
        while(j<=right){
            temp[tmp] = arr[j];
            j+=1;
            tmp+=1;
        }


        //将temp拷贝到原数组中,
        // 从最底层分开后开始第一次拷贝（最终会分成两个数，将这两个拍过序的数拷贝至原数组），
        //直至最后一次将排序完全的temp拷贝到原数组中
        tmp = 0;
        int templeft = left;
        while(templeft<=right){
            arr[templeft] = temp[tmp];
            tmp+=1;
            templeft+=1;
        }

    }
}
