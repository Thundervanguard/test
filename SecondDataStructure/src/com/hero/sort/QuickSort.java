package com.hero.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {2, 3, 67, 34, 6, 2, 3, 65, 75, 3, 4, 23};
        quickSortTest(array,0,array.length-1);
    }

    private static void quickSortTest(int[] array, int left, int right) {


 /*       int l = left;
        int r = right;
        //定义中轴值pivot
        int pivot = arr[(left+right)/2];
        //定义临时变量，在交换时使用
        int temp = 0;
        //当左边的下标小于右边的下边时，循环
        while(l<r){
            //找到左边比中轴值大的数
            while(arr[l]<pivot){
                l++;
            }
            //找到右边比中轴值小的数
            while(arr[r]>pivot){
                r--;
            }
            //l>r说明左边的都比中轴值小，右边的都比中轴值大
            if(l>=r){
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if(arr[l]==pivot){
                r--;
            }
            if(arr[r]==pivot){
                l++;
            }
        }
        //如果l=r，必须l++,r--,否则就会栈溢出
        if(l==r){
            l++;
            r--;
        }
        //递归左侧
        if(left<r){
            quickSortTest(arr,left,r);
        }
        //递归右边
        if(right>l){
            quickSortTest(arr,l,right);
        }

        System.out.println(Arrays.toString(arr));*/

        int  l = left;
        int r = right;
        //选择中轴值
        int axis = array[(left+right)/2];
        //定义临时值用于交换
        int temp=0;
        while(l<r){
            //找到左边大于中轴值得数
            while(array[l]<axis){
                l++;
            }
            //找到右边大于中轴值得数
            while(array[r]>axis){
                r--;
            }

            if(l>=r){
            //说明左边都比右边小
                break;
            }
            //交换
            temp = array[l];
            array[l] = array[r];
            array[r] =  temp;
            if(array[l]==axis){
                r--;
            }
            if(array[r] ==axis){
                l++;
            }

        }
        if(l==r){
            l++;
            r--;
        }
        //向左递归
        if(left<r){
            quickSortTest(array,left,r);
        }
        //向右递归
        if(right>l){
            quickSortTest(array,l,right);
        }
    }
}
