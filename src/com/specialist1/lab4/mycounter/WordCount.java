package com.specialist1.lab4.mycounter;

import java.io.*;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class WordCount {
    private String inFile;
    private String outFile;
    public static String testString = "abcdefghijklmnopqrstuvwxyz";
    Hashtable words = new Hashtable();

    public Hashtable getWords(){
        return words;
    }

    public WordCount(String inFile, String outFile) {
        this.inFile = inFile;
        this.outFile = outFile;
    }

    public void countWords() throws IOException {
        Reader reader;

        if(inFile==null){
            reader = new StringReader(testString);
        }
        else {
            reader = new FileReader(inFile);
        }

        BufferedReader br =new BufferedReader(reader);
        for (String line = br.readLine(); line != null; line = br.readLine()){
            StringTokenizer st = new StringTokenizer(line, " \t\n\r\f.,;:\"\\");
            while(st.hasMoreTokens()){
                String token = st.nextToken();
                if(!(words.containsKey(token))){
                    words.put(token, 1);
                }
                else{
                    Object val = words.get(token);
                    int n=(int) val;
                    n++;
                    words.put(token,n);

                }
            }
        }
        br.close();

    }
}
