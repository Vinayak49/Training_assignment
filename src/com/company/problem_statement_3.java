package com.company;
import java.io.*;
import java.util.Scanner;

class Employee {
    private String name;
    private String email;
    private int age;
    private String dob;

    void add(String n, String e, int a, String d) {
        name = n;
        email = e;
        age = a;
        dob = d;

        try {
            int count = 0;
            FileWriter mw = new FileWriter("employee.txt", true);
            File obj = new File("employee.txt");
            Scanner reader = new Scanner(obj);
            BufferedWriter out = new BufferedWriter(mw);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                count = (data.split("," + e + ",").length) - 1;
            }
            if (count < 1) {
                out.write(name + "," + email + "," + age + "," + dob + "\n");
                System.out.println("written");
            } else {
                System.out.println("email already exists.");
            }
            out.close();


        } catch (IOException er) {
            System.out.println("some errr occurred");
            er.printStackTrace();
        }
    }

    void SearchRec(String e) {
//        email =e;
        try {
            File obj = new File("employee.txt");
            Scanner reader = new Scanner(obj);
            int i = 0;
            int flag = 0;
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                int count = (data.split("," + e + ",").length) - 1;
                if (count > 0) {
                    flag = 1;
                }
                i += 1;
            }
            reader.close();
            if (flag == 1) {
                System.out.println("Found at line " + i);

            } else {
                System.out.println("Not Found");
            }
        } catch (FileNotFoundException er) {
            System.out.println("error found");
            er.printStackTrace();
        }
    }

    void DeleteRec(String e) {
        String tempFile = "employee1.txt";
        File oldf = new File("employee.txt");
        File newf = new File("employee1.txt");

        String current;
        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader("employee.txt");
            BufferedReader br = new BufferedReader(fr);
//            int count = (data.split("," + e + ",").length) - 1;
            while ((current = br.readLine()) == null) {
                if (current.split("," + e + ",").length != 1) {
                    pw.println(current);
                }

            }
            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();

            oldf.delete();
            File dump = new File("employee.txt");
            newf.renameTo(dump);
        } catch (Exception em) {

        }
    }

}
    public class problem_statement_3 {
        public static void main(String[] args) {
            Employee eobj2 = new Employee();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a to add \nEnter s to search \nEnter d to delete a record ");
            String operation = sc.next();

        switch (operation){
            case "a":
                System.out.print("Enter name :");
                String name = sc.next();
                System.out.print("Enter email :");
                String email = sc.next();
                System.out.print("Enter age :");
                int age = sc.nextInt();
                System.out.print("Enter dob :");
                String dob = sc.next();
                eobj2.add(name, email,age,dob);
                break;

            case "s":
                System.out.print("Enter email :");
                String email1 = sc.next();
                eobj2.SearchRec(email1);
                break;
            case "d":
                System.out.println("Eter email : ");
                String email2 = sc.next();
                eobj2.DeleteRec(email2);
                break;
        }
//        eobj2.add("vina","vin@vinay",12,"123");
//        eobj2.add("vina","vin@vi",12,"123");
//        eobj2.add("vina","vin@vina",12,"123");
//            eobj2.SearchRec("vin@vinay");
//        eobj2.DeleteRec("vin@vina");
        }
    }

