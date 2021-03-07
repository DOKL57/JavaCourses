package com.specialist2.practice.tictaktoe;

import com.specialist2.lab1.ex2.tictak.TicTak;
import com.specialist2.practice.tictaktoe.TicTakToe;

public class ThreadOne extends Thread {
    private Object monitor;
    private Thread thread;

    public ThreadOne(Object monitor) {
        this.monitor = monitor;
    }
    public Thread getThread () {
        return thread;
    }

    public void run () {
        try
        {
            for (int i = 0; i < TicTakToe.num; i++) {

                synchronized (monitor) {
                    while (TicTakToe.fl!=1){
                        monitor.wait();
                    }
                    System.out.print(1+" - ");
                    TicTakToe.fl = 2;
                    monitor.notifyAll();
                    if (i < TicTakToe.num-1)
                        monitor.wait();
                }


            }
        }
        catch (InterruptedException e) { e.printStackTrace(); }
    }
}
