package com.Hotwax.www;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


class NameComparator implements Comparator<Employee> {
    public  int compare(Employee emp1, Employee emp2){
        return emp1.getName().compareTo(emp2.getName());
    }
}
class NameComparatorDesc implements Comparator<Employee> {
    public  int compare(Employee emp1, Employee emp2){
        return emp2.getName().compareTo(emp1.getName());
    }
}
class AgeComparator implements Comparator<Employee> {
    public  int compare(Employee emp1, Employee emp2){
        return emp1.getAge().compareTo(emp2.getAge());
    }
}
class AgeComparatorDesc implements Comparator<Employee> {
    public  int compare(Employee emp1, Employee emp2){
        return emp2.getAge().compareTo(emp1.getAge());
    }
}
class EmailComparator implements Comparator<Employee> {
    public  int compare(Employee emp1, Employee emp2){
        return emp1.getEmail().compareTo(emp2.getEmail());
    }
}
class EmailComparatorDesc implements Comparator<Employee> {
    public  int compare(Employee emp1, Employee emp2){
        return emp1.getEmail().compareTo(emp2.getEmail());
    }
}
class DobComparator implements Comparator<Employee> {
    public  int compare(Employee emp1, Employee emp2){
        return emp1.getDob().compareTo(emp2.getDob());
    }
}
class DobComparatorDesc implements Comparator<Employee> {
    public  int compare(Employee emp1, Employee emp2){
        return emp1.getDob().compareTo(emp2.getDob());
    }
}
class Employee implements Comparable<Employee> {
    private String name;
    private String email;
    private String age;
    private String dob;

    Employee(String n, String e, String a, String d){
        name = n;
        email = e;
        age= a;
        dob = d;
    }
    public String toString(){
        return name+","+email+","+age+","+dob;
    }

    public int compareTo(Employee e){
        return name.compareTo(e.getName());
    }

    public String getName(){
        return name;
    }
    public String getEmail(){
        return  email;
    }
    public  String getDob(){
        return dob;

    }
    public String getAge(){
        return  age;
    }



    void add(String n, String e, String a, String d) {
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
            System.out.println("some error occurred");
            er.printStackTrace();
        }
    }

    void SearchRec(String e) {
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
        File oldFile = new File("employee.txt");
        File newFile = new File("employee1.txt");

        String current;
        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader("employee.txt");
            BufferedReader br = new BufferedReader(fr);
//            int count = (data.split("," + e + ",").length) - 1;
            while ((current = br.readLine()) == null) {
                try {
                    if (current.split("," + e + ",").length != 1) {
                        pw.println(current);
                    }
                }
                catch (NullPointerException error){
                    System.out.println(error);
                }


            }
            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();

            oldFile.delete();
            File dump = new File("employee.txt");
            newFile.renameTo(dump);
        } catch (Exception em) {
            System.out.println("Handled");
        }
    }

    public void sortIt(String orderBy) {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            File obj = new File("employee.txt");
            Scanner reader = new Scanner(obj);
            int flag = 0;
            String[] emp=null;
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
//                System.out.println(data);
                emp = data.split(",");
                Employee employee = new Employee(emp[0],emp[1],emp[2],emp[3]);
                employees.add(employee);
            }
            System.out.println("Enter A for Ascending and D for Descending :");
            Scanner sc = new Scanner(System.in);
            String order = sc.next();
            if (orderBy.equalsIgnoreCase("name")){
                if (order.equalsIgnoreCase("A"))
                Collections.sort(employees,new NameComparator());
                else if (order.equalsIgnoreCase("D")){
                    Collections.sort(employees,new NameComparatorDesc());
                }
                else {
                    System.out.println("Invalid Input");
                }
            }
            else if (orderBy.equalsIgnoreCase("Age")){
                if (order.equalsIgnoreCase("A")){
                    Collections.sort(employees,new AgeComparator());
                }

                else if(order.equalsIgnoreCase("D")){
                    Collections.sort(employees,new AgeComparatorDesc());
                }
                else {
                    System.out.println("Invalid input");
                }
            }
            else if (orderBy.equalsIgnoreCase("Email")){
                if (order.equalsIgnoreCase("A")){
                    Collections.sort(employees,new EmailComparator());
                }

                else if(order.equalsIgnoreCase("D")){
                    Collections.sort(employees,new EmailComparatorDesc());
                }
                else {
                    System.out.println("Invalid input");
                }
            }
            else if(orderBy.equalsIgnoreCase("Dob")){
                if (order.equalsIgnoreCase("A")){
                    Collections.sort(employees,new DobComparator());
                }

                else if(order.equalsIgnoreCase("D")){
                    Collections.sort(employees,new DobComparatorDesc());
                }
                else {
                    System.out.println("Invalid input");
                }

            }
            else {
                System.out.println("Invalid input");
            }
//
//

            int k;
            for(k=0;k<employees.size();k++)
            System.out.println(employees.get(k));
            reader.close();
        } catch (FileNotFoundException er) {
            System.out.println("error found");
            er.printStackTrace();
        }
    }
}


    public class problem_statement_3 {
        public static void main(String[] args) {
            Employee eobj2 = new Employee(null,null,null,null);
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
                String age = sc.next();
                System.out.print("Enter dob :");
                String dob = sc.next();
                eobj2.add(name, email,age,dob);
                break;

            case "s":
                System.out.println("Enter s for search OR Enter sort to sort the list ");
                String choice = sc.next();
                if (choice.equalsIgnoreCase("s")) {
                    System.out.print("Enter email :");
                    String email1 = sc.next();
                    eobj2.SearchRec(email1);
                    break;
                }
                else if (choice.equalsIgnoreCase("sort")){
                    System.out.println("Order by ?");
                    String orderBy = sc.next();
                    eobj2.sortIt(orderBy);
                    break;
                    //
                }
                else {
                    System.out.println("Invalid input ");
                }
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
//        eobj2.sortit("name");

        }
    }

