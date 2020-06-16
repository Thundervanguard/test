package com.hero.search;

public class BinarySearch {
    public static int a = 0;

    public static void main(String[] args) {

        int[] arr = new int[]{12,15,45,67,77,78,99,167,225,666,898};
        //    int index1 = binaryQuery(arr,0,arr.length-1,77);
   int index = insertQuery(arr,0,arr.length-1,77);
      System.out.println(index+"insert次数"+a);
        //    System.out.println(index1+"binary次数"+a);
    }
    private static int binaryQuery(int[] arr,int left,int right, int num) {
        if(left>right){
            return -1;
        }
a++;
       int mid = (left+right)/2;

        int midValue = arr[mid];


            if(num>midValue){
                //向左查找
               return binaryQuery(arr,mid+1,right,num);
            }else  if(num<midValue){
                //向右查找
                return  binaryQuery(arr,left,mid,num);
            }else{
                //相等，找到返回
                return mid;
            }

    }
    private static int insertQuery(int[] arr,int left,int right, int num) {
        if(left>right||num<arr[0]||num>arr[arr.length-1]){
            return -1;
        }
a++;
       // int mid = (left+right)/2;
        int mid = left+(right-left)*(num-arr[left])/(arr[right]-arr[left]);
        int midValue = arr[mid];


            if(num>midValue){
                //向左查找
               return binaryQuery(arr,mid+1,right,num);
            }else  if(num<midValue){
                //向右查找
                return  binaryQuery(arr,left,mid-1,num);
            }else{
                //相等，找到返回
                return mid;
            }

    }

}
