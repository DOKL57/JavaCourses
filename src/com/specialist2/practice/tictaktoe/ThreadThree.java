package com.specialist2.practice.tictaktoe;

public class ThreadThree implements Runnable
{
    private Object monitor;
    private Thread thread;

    public Thread getThread () {
        return thread;
    }

    public ThreadThree(Object monitor) {
        thread = new Thread (this);
        this.monitor = monitor;

    }

    public void run() {
        try {
            Thread.sleep(100);
            for (int i = 0; i < TicTakToe.num; i++) {
                synchronized (monitor) {
                    while (TicTakToe.fl!=3){
                        monitor.wait();
                    }
                    System.out.print(3+"\n");
                    TicTakToe.fl = 1;
                    monitor.notifyAll();
                    if (i < TicTakToe.num-1)
                        monitor.wait();
                }


            }
        }
        catch (InterruptedException e) { e.printStackTrace(); }
    }
}
