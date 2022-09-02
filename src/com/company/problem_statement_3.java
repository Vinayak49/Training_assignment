package com.company;
import java.io.*;
import java.util.Scanner;

class Employee{
    String name;
    String email;
    int age;
    String dob;

    void add(String n, String e, int a, String d){
        name = n;
        email = e;
        age = a;
        dob = d;

        try{
            int count=0;
            FileWriter mw  = new FileWriter("employee.txt",true);
            File obj = new File("employee.txt");
            Scanner reader = new Scanner(obj);
            BufferedWriter out = new BufferedWriter(mw);
            while(reader.hasNextLine()) {
                String data = reader.nextLine();
                count = (data.split("," + e + ",").length) - 1;
            }
            if (count<1){
                out.write(name+","+email+","+age+","+dob+"\n");
                System.out.println("written");
            }

            else{
                System.out.println("email already exists.");
            }
            out.close();


        }
        catch (IOException er){
            System.out.println("some errr occurred");
            er.printStackTrace();
        }
    }
    void SearchRec(String e){
        email =e;
        try {
            File obj = new File("employee.txt");
            Scanner reader = new Scanner(obj);
            int i =0;
            while(reader.hasNextLine()){
                String data = reader.nextLine();
                int count = (data.split(","+e+",").length) - 1;
                if (count>0)
                    System.out.println(data + "at line number : "+ i);
                i+=1;
            }
            reader.close();
        }
        catch (FileNotFoundException er){
            System.out.println("error found");
            er.printStackTrace();
        }
    }
    void DeleteRec(String e){
        email = e;
        try {
            FileWriter mw  = new FileWriter("employee1.txt",true);
            File obj = new File("employee.txt");
            BufferedWriter out = new BufferedWriter(mw);
            Scanner reader = new Scanner(obj);
            while(reader.hasNextLine()){
                String data = reader.nextLine();
                out.write(data);
                System.out.println(data);
            }

            reader.close();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}

public class problem_statement_3 {
    public static void main(String[] args) {
        Employee eobj2 = new Employee();

        eobj2.add("vina","vin@vinay",12,"123");
        eobj2.SearchRec("vin@vin");eobj2.SearchRec("vin@vin");
//        eobj2.DeleteRec("vin@vin");
    }
}
