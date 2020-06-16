package com.hero.sparsearray;

import java.io.*;

public class MySparseArray {

    public static void main(String[] args) throws IOException {
        //1.定义一个二维数组
        int[][] array  = new int[8][8];
        //2.添加一些数据
        array[0][3] = 4;
        array[3][3] = 5;
        array[5][7] = 2;
        array[7][3] = 6;
        //将原始数组输出
        for(int[] row:array){
            for(int col:row){
                System.out.printf("%d\t",col);
            }
            System.out.println();
        }
        //将二维数组转换为稀疏数组
        int[][] sparsearray = changeSparseArray(array);
        FileWriter writer =null;
        try {
            //将数组存入磁盘中
            File file  = new File("D:\\mom.txt");
            writer = new FileWriter(file);

            for(int[] row:sparsearray){
                for(int col:row){
                    writer.write(col+"\t");
                    System.out.printf("%d\t",col);
                }
                writer.write("\r\n");
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            writer.close();
        }

        //从文件将数组读出
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("D:\\mom.txt")));
        int[][] fileread = new int[sparsearray.length][3];
        String line ;
        int row = 0;
        while(( line = bufferedReader.readLine())!=null){
            String[] split = line.split("\t");
            for(int i=0;i<split.length;i++){
                fileread[row][i]=Integer.parseInt(split[i]);
            }
            row++;
        }
        bufferedReader.close();

        for(int[] roow :fileread){
            for(int col:roow){
                System.out.printf("%d\t",col);
            }
            System.out.println();
        }
        System.out.println("文件读取成功");
        //将稀疏数组转换为二维数组
        int[][] normal = changenormal(sparsearray);
        //输出
        for(int[] roow :normal){
            for(int col:roow){
                System.out.printf("%d\t",col);
            }
            System.out.println();
        }
    }


    private static int[][] changenormal(int[][] sparsearray) {
        //1.根据稀疏数组的首行创建二维数组
        int[][] array = new int[sparsearray[0][1]][sparsearray[0][1]];
        //2.遍历输出
        for(int i=1;i<=sparsearray[0][2];i++){
            array[sparsearray[i][0]][sparsearray[i][1]] = sparsearray[i][2];
        }
        return array;
    }

    private static int[][] changeSparseArray(int[][] array) {



        //1.遍历二维数组，获得数组中存在不同元素的数量
        int sum = 0 ;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(array[i][j]!=0){
                    sum++;
                }
            }
        }
        //2.创建稀疏数组
        int[][] sparse = new int[sum+1][3];
        //3.第一行存放二维数组的行列数及不同元素数
        sparse[0][0] = 8;
        sparse[0][1] = 8;
        sparse[0][2] = sum;
        //4.除首行其他行都存放不同元素的 行 列 值
        int m = 1;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(array[i][j]!=0){
                   sparse[m][0] = i;
                   sparse[m][1] = j;
                   sparse[m][2] = array[i][j];
                    m++;
                }

            }

        }
        return sparse;
    }
}
