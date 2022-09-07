package com.company;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Student implements Serializable {
    String firstname;
    String dob;
    Date d;
//    Date d=new SimpleDateFormat("dd/MM/yyyy").parse(dob);
    Address address;
    public Student(String firstname, Date d,Address address) throws ParseException {
        this.firstname = firstname;
        this.address = address;
        this.d = d;
    }
    @Override
    public String toString() {
        return " Student First Name = " +firstname + "\n DOB = " + dob + "\n Address =" + address + "\n\n" ;
    }
}

class Address implements Serializable {
    String city;
    String state;
    int pincode;
    String country;


    public Address(String city, String state, int pincode, String country) {
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.country = country;
    }
}
public class Problem_statement_5 {
    public static void main(String[] args) throws ParseException {
        String fileName = "output1.ser";
        Address add = new Address("Indore", "up", 123456,"India");
        Date d=new SimpleDateFormat("dd/MM/yyyy").parse("12/12/2020");
        Student stu = new Student("veennayak",d,add);
        serializeObject(fileName,stu);
        deserializeObject(fileName);
        Date d1=new SimpleDateFormat("dd/MM/yyyy").parse("12/12/2020");
        Student stu1 = new Student("vinayak",d1,add);
        serializeObject(fileName,stu1);
        deserializeObject(fileName);
        Date d2=new SimpleDateFormat("dd/MM/yyyy").parse("12/12/2020");
        Student stu2 = new Student("yak",d2,add);
        serializeObject(fileName,stu2);
        deserializeObject(fileName);
        Date d3=new SimpleDateFormat("dd/MM/yyyy").parse("12/12/2020");
        Student stu3 = new Student("vina",d3,add);
        serializeObject(fileName,stu3);
        deserializeObject(fileName);
    }

    private static void deserializeObject(String fileName) {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Object object = ois.readObject();
            Student st=(Student) object;
            System.out.println(st);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void serializeObject(String fileName ,Student stu) {

//        Address ad = new Address("Indore", "up", 123456,"India");
//        Student st = new Student("vinayak","123",ad);
//        Address add = new Address("Indore", "up", 123456,"India");
//        Student stu = new Student("vinayak","123",ad);
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(stu);
//            oos.writeObject(stu);
//            System.out.println("serialized");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
