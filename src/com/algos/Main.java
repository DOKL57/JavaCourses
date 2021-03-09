package com.algos;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // System.out.println(BitCounting.countBits(1234));
        // System.out.println(SquareDigit.squareDigits(5569));
        //System.out.println(Kata.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
        //System.out.println(XO.getXO("oxox"));
        //System.out.println(FindOdd.findIt(new int[]{1, 2, 3, 4, 5}));
        //System.out.println(isogram.isIsogram("Dermatoglyphics"));
        //System.out.println(MinMax.minMax(new int[]{1,2,3,4,5}));
        //System.out.println(TriangleTester.isTriangle(1,2,2));
        //System.out.println(Accumul.accum("RqaEzty"));
        //System.out.println(BinaryArrayToNumber.ConvertBinaryArrayToInt(new ArrayList<>(Arrays.asList(0,1,1,1))));
        //System.out.println(GetSum(5,3));
        //System.out.println(greedy(new int[]{1, 1, 1, 3, 1}));


    }





    public static int greedy(int[] dice) {
        int[] numbers = new int[]{0, 0, 0, 0, 0, 0};
        int ans = 0;
        for (int el : dice
        ) {
            switch (el) {
                case (1):
                    numbers[0]++;
                    break;
                case (2):
                    numbers[1]++;
                    break;
                case (3):
                    numbers[2]++;
                    break;
                case (4):
                    numbers[3]++;
                    break;
                case (5):
                    numbers[4]++;
                    break;
                case (6):
                    numbers[5]++;
                    break;

            }
        }
        for (int i = 0; i < numbers.length; i++) {
            while (numbers[i] / 3 > 0) {
                switch (i+1) {
                    case (1):
                        ans += 1000;
                        numbers[i] -= 3;
                        break;
                    case (2):
                        ans += 200;
                        numbers[i] -= 3;
                        break;
                    case (3):
                        ans += 300;
                        numbers[i] -= 3;
                        break;
                    case (4):
                        ans += 400;
                        numbers[i] -= 3;
                        break;
                    case (5):
                        ans += 500;
                        numbers[i] -= 3;
                        break;
                    case (6):
                        ans += 600;
                        numbers[i] -= 3;
                        break;
                }

            }
            while (numbers[i] > 0) {
                switch (i) {
                    case (0):
                        ans += 100;
                        numbers[i]--;
                        break;
                    case (4):
                        ans += 50;
                        numbers[i]--;
                        break;
                    default:
                        numbers[i]--;
                        break;
                }
            }

        }
        return ans;
    }
    static public int nextHappyYear(int year) {
        ++year;
        while (!(year % 10 != (year % 100) / 10 && year % 10 != (year / 100) % 10 && year % 10 != year / 1000 && (year % 100) / 10 != (year / 100) % 10 && (year % 100) / 10 != year / 1000 && (year / 100) % 10 != year / 1000)) {
            year++;
        }
        return year;
    }

}
class BitCounting {
    public static int countBits(int n){
        StringBuilder sb = new StringBuilder();
        int i;
        int count = 0;

        for(i=0; i<32; i++){
            if((n&1)==1){
                sb.append("1");
            }
            else{
                sb.append("0");
            }
            n>>=1;
        }
        sb.reverse();
        for (char el: sb.toString().toCharArray()
        ) {
            if(el == '1')
                count++;
        }
        return count;
    }
}
class SquareDigit {

    public static int squareDigits(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        StringBuilder sb1 = new StringBuilder();
        for (char ch: sb.toString().toCharArray()
             ) {
            int square = (ch - '0') * (ch - '0');
            sb1.append(square);

        }
        return Integer.parseInt(sb1.toString());
    }

}
class Kata {
    public static String createPhoneNumber(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        sb.append(Arrays.toString(numbers));

        StringBuilder sb1 = new StringBuilder(sb.toString().replaceAll("[\\[\\], ]" ,""));
        sb1.insert(3,") ");
        sb1.insert(0,"(");
        sb1.insert(9,"-");
        return sb1.toString();

    }
}
class XO {

    public static boolean getXO (String str) {
        int x = 0;
        int o = 0;
        for (char c:str.toLowerCase(Locale.ROOT).toCharArray()
             ) {
            if(c == 'x'){
                x++;
            }
            else if(c=='o'){
                o++;
            }
        }
        return (x==o);
    }
}
class FindOdd {
    public static int findIt(int[] a) {
        int[] counter = new int[a.length];
        int i;
        for(i = 0; i<a.length;i++){
            counter[a[i]]++; //это говно работает, только если элементы до 10.
        }
        int max = counter[0];
        int maxindex = 0;
        for(i = 0; i< a.length;i++){
            if(max < counter[i]){
                max = counter[i];
                maxindex = i;
            }
        }

        return counter[maxindex];
    }
}
class isogram {

    public static boolean  isIsogram(String str) {

        for (char ch:str.toLowerCase().toCharArray()
             ) {
            int repeated = 0;
            for(int i = 0; i<str.length();i++){
                if(ch==str.toLowerCase().toCharArray()[i]){
                    repeated++;
                    if(repeated>1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
class MinMax {
    public static int[] minMax(int[] arr) {
        int[] minmax = new int[2];
        minmax[0] = arr[0];
        minmax[1] = arr[0];
        for(int i = 0; i< arr.length; i++){
            if(arr[i] < minmax[0]){minmax[0] = arr[i];}
            if(arr[i] > minmax[1]){minmax[1] = arr[i];}

        }
        return minmax;
    }
}
class TriangleTester{
    public static boolean isTriangle(int a, int b, int c){
        return ((a+b>c) && (a+c>b) && (b+c>a));
    }
}
class Square {
    public static boolean isSquare(int n) {
        return ((int) Math.sqrt(n)*(int)Math.sqrt(n) == n);
    }
}
class Accumul {

    public static String accum(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.toCharArray().length;i++){
            sb.append(s.toUpperCase().toCharArray()[i]);
            for (int k = 0; k< i; k++) {
                sb.append(s.toLowerCase().toCharArray()[i]);
            }
            if(i!=(s.toCharArray().length - 1))
                sb.append("-");
        }
        return sb.toString();
    }
}
class BinaryArrayToNumber {

    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        int ans = 0;
        for(int i = 0; i<binary.size(); i++){
            ans+=binary.get(i)*Math.pow(2, binary.size() - 1 - i);
        }
        return ans;
    }
}
