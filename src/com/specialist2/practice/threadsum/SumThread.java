package com.specialist2.practice.threadsum;

public class SumThread extends Thread{
    private int pos;

    public SumThread(int pos){
        this.pos = pos;
    }

    @Override
    public void run(){

        for(int i = pos;i < GlobalData.ARRAY_LENGTH; i += GlobalData.THREAD_COUNT){
            GlobalData.results[pos] += GlobalData.array[i];
        }

    }
}