package com.hero.queue.circle;

import java.util.Scanner;

/**
 * @author Arrow
 */
public class CircleQueue {
    public static void main(String[] args) {
        //1.使用数组创建队列
        CircleQueueT queue = new CircleQueueT(4);
        Scanner scanner = new Scanner(System.in);

        boolean loop = true;
        char key =' ';

        while (loop){
            key = scanner.next().charAt(0);

            switch (key){
                case 's':
                    queue.show();
                    break;
                case 'a':
                    System.out.println("输入数");
                    int value= scanner.nextInt();
                    queue.add(value);
                    break;
                case 'd':
                    queue.pop();
                    break;
                case 'h':
                    queue.showHeader();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    scanner.close();
                    break;

            }

        }
        System.out.println("程序退出");

    }
}

class CircleQueueT{
    //定义队列首部
    private int front;
    //定义队列尾部
    private int rear;
    //定义队列
    private int[] queue;
    //定义队列的最大容量
    private int maxsize;

    //初始化队列
    public CircleQueueT(int arrmaxsize) {
        maxsize = arrmaxsize;
        queue = new int[arrmaxsize] ;
    }

    //判断队列是否满
    public boolean isFull(){
        return rear == front;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return (rear+1)%maxsize == front;
    }

    //添加到队列
    public void  add(int num){
        //先判断队列是否已满
        if(isFull()){
            System.out.println("队列已满，无法加入");
            return;
        }
        rear++;//让rear后移
        queue[rear] = num;
    }

    //出队列
    public int pop(){
        //判断队列是否为空
        if(isEmpty()){
            throw new RuntimeException("队列已空");
        }
        front++;//front后移
        return queue[front];
    }

    //显示队列所有数据
    public void show(){
        if(isEmpty()){
            System.out.println("队列已空");
            return;
        }
        for(int i=0;i<queue.length;i++){
            System.out.printf("queue[%d]=%d\n",i,queue[i]);
        }
    }
    //显示队列头数据
    public int showHeader(){
        if(isEmpty()){
            throw new RuntimeException("队列已空");
        }
        return queue[front+1];
    }

}