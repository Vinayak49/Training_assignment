package com.company;
import java.io.*;
import java.util.Scanner;
import java.net.*;


public class Problem_statement_1 {
    public static void main(String[] args) {
        String[] a = new String[3];
        try {
            File obj1 = new File("url.txt");
            Scanner r = new Scanner(obj1);
            File f = new  File("words.txt");
            Scanner sc = new Scanner(f);
            int j=0;
            while (sc.hasNextLine()){
//                System.out.println(sc.nextLine());
                a[j] = sc.nextLine();
                j+=1;
            }
            while (r.hasNextLine()) {
                String data = r.nextLine();
                URL x = new URL(data);
                BufferedReader in = new BufferedReader(new InputStreamReader(x.openStream()));
                String inputLine;

                int v=0,w=0,y=0;
                while ((inputLine = in.readLine()) != null) {
                    String result = inputLine.replaceAll("<[^>]*>", "");
                    int count = (result.split(a[0]).length) - 1;
                    int count1 = (result.split(a[1]).length) - 1;
                    int count2 = (result.split(a[2]).length) - 1;
                    v += count;
                    w += count1;
                    y += count2;
                }
                System.out.println("Word "+a[0]+" has occurred "+v+" times");
                System.out.println("Word "+a[1]+" has occurred "+w+" times");
                System.out.println("Word "+a[2]+" has occurred "+y+" times");

                in.close();
            }
            r.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
