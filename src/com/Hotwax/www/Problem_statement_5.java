package com.company;

import java.io.*;

class Student implements Serializable {
    String firstname;
    String dob;
    Address address;
    public Student(String firstname, String dob,Address address) {
        this.firstname = firstname;
        this.address = address;
        this.dob = dob;
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
    public static void main(String[] args) {
        String fileName = "output1.ser";
        Address add = new Address("Indore", "up", 123456,"India");
        Student stu = new Student("veennayak","12/12/2000",add);
        serializeObject(fileName,stu);
        deserializeObject(fileName);
        Student stu1 = new Student("vinayak","12/12/2000",add);
        serializeObject(fileName,stu1);
        deserializeObject(fileName);
        Student stu2 = new Student("yak","12/12/2000",add);
        serializeObject(fileName,stu2);
        deserializeObject(fileName);
        Student stu3 = new Student("vina","12/12/2000",add);
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
