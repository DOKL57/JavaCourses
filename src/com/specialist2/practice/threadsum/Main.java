package com.specialist2.practice.threadsum;

import java.util.Random;

class Main {
    public static void main(String[] args) throws InterruptedException {

        GlobalData.array = new int[GlobalData.ARRAY_LENGTH];
        GlobalData.results = new long[GlobalData.THREAD_COUNT];
        int i;
        Random rnd = new Random();

        for(i = 0; i< GlobalData.ARRAY_LENGTH; i++){
            GlobalData.array[i] = rnd.nextInt(10);
        }

        long sum1 = 0;
        long t1 = System.currentTimeMillis();
        for(i = 0; i< GlobalData.ARRAY_LENGTH;i++){
            sum1 += GlobalData.array[i];
        }
        long t2 = System.currentTimeMillis();
        System.out.println("sum1 = " + sum1 + ", working time = " + (t2-t1));

        SumThread[] threads = new SumThread[GlobalData.THREAD_COUNT];
        for(i = 0;i<GlobalData.THREAD_COUNT;i++){
            threads[i] = new SumThread(i);
        }

        long sum2 = 0;
        long t3 = System.currentTimeMillis();

        for(i = 0; i < GlobalData.THREAD_COUNT; i++){
            threads[i].start();
        }
        for(i = 0; i < GlobalData.THREAD_COUNT; i++){
            threads[i].join();
        }
        for(i = 0; i < GlobalData.THREAD_COUNT; i++){
            sum2 += GlobalData.results[i];
        }


        long t4 = System.currentTimeMillis();
        System.out.println("sum2 = " + sum2 + ", working time = " + (t4-t3));

    }

}

