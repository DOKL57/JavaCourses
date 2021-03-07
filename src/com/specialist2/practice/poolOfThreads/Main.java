package com.specialist2.practice.poolOfThreads;

import java.util.ArrayList;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int nThreads = 5;

        ExecutorService exec = Executors.newFixedThreadPool(nThreads);
        ArrayList<Future<String>> results = new ArrayList<>();

        for (int i = 0; i < 12; i++) { // 12 задач (i<12) на 5 исполнителей (nThreads)
            results.add(
            exec.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " - done");
                    return Thread.currentThread().getName();
                }
            }));
        }

        for (Future<String> el: results
             ) {
            System.out.println("Got result " + el.get());
        }
        exec.shutdown(); // больше в исполнители задач передаваться не будет
        System.out.println("End of main");
    }

}
