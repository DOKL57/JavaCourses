package com.specialist1.lab1.ex3;

public class Main {

    public static void main(String[] args) {
        int m = 5;
        System.out.println(getBinary(m));

    }

    private static String getBinary(int m) {
        StringBuilder sb = new StringBuilder();
        int i;
        for(i=0; i<32; i++){
            if((m&1)==1){
                sb.append("1");
            }
            else{
                sb.append("0");
            }
            m>>=1;
            if(i==15 || i == 7 || i == 23){ sb.append(" "); }

        }
        sb.reverse();
        return sb.toString();

    }
}
