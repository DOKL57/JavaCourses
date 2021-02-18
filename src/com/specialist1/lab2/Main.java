package com.specialist1.lab2;

public class Main {
    public static void main(String[] args){
        String[] keys = {"?","r","w" };
        ComLineParser pars = new ComLineParser(keys);
        pars.Parse(args);
    }
}
