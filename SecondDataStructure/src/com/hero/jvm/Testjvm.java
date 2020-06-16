package com.hero.jvm;

import java.util.concurrent.atomic.AtomicInteger;

public class Testjvm {

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            System.out.println("-------------------");
            try {

                Thread.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
