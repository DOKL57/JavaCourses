package com.specialist1.lab4.mycounter;

import java.io.IOException;
import java.util.Enumeration;

public class MyCounter {

    public static void main(String[] args) throws IOException {
        SimpleParser sp=new SimpleParser();
        sp.Parse(args);

        WordCount wc=new WordCount("radme.txt",null);
        //WordCounter wc=new WordCounter(sp.getInFile(), null);
        wc.countWords();

        Enumeration keys = wc.getWords().keys();
        while(keys.hasMoreElements()){
           String w=keys.nextElement().toString();
           int n= (int)wc.getWords().get(w);
           System.out.println(w+"   "+n);
        }
    }
}
