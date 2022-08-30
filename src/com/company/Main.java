package com.company;
import java.util.*;


class Triangle{
    int height;
    int base;

    void getDimensions(int h , int b){
        height = h;
        base = b;
    }

    void calculateArea(){
        System.out.println((height*base)/2);
    }

    void calculatePerimeter(int a , int b , int c){
        System.out.println(a+b+c);
    }
}
class Rectangle{
    void calculateArea(int l , int b){
        System.out.println(l*b);
    }
    void calculatePerimeter(int l , int b){
        System.out.println(2*l + 2*b);
    }
}
class Square{
    void calculateArea(int l ){
        System.out.println(l*l);
    }
    void calculatePerimeter(int l){
        System.out.println(4*l);
    }
}
class Cylinder{
    void calculateArea(int r, int h ){
        System.out.println(2*3.14*r*h+ 2*3.14*r*r);
    }
    void calculatePerimeter(int r ){
        System.out.println((2*3.14*r*r));
    }
    void calculateVolume(int r , int h ){
        System.out.println(3.14 * r*r*h);
    }
}
class Sphere{
    void calculateArea(int r ){
        System.out.println(4*3.14*r*r);
    }
    void calculatePerimeter(int r ){
        System.out.println((2*3.14*r));
    }
    void calculateVolume(int r ){
        System.out.println(3.14 * r*r*r * 1.34);
    }
}
class Circle{
    void calculateArea(int r){
        System.out.println(3.14*r*r);
    }
    void calculatePerimeter(int r){
        System.out.println((2*3.14*r));
    }
}
public class Main {

    public static void main(String[] args) {
        // write your code here
        while (true)
        {
            System.out.println("Enter shape : ");
            Scanner sc = new Scanner(System.in);
            String shape = sc.next();
            if (shape.equalsIgnoreCase( "triangle")){
                Triangle t = new Triangle();
                System.out.println("Enter Operation to be performed : ");
                String operation = sc.next();
                if (operation.equalsIgnoreCase("area")){
                    System.out.print("Enter height of Triangle : ");
                    int height = sc.nextInt();
                    System.out.print("Enter base of Triangle : ");
                    int base = sc.nextInt();
                    t.getDimensions(height, base);
                    t.calculateArea();
                }
                if (operation.equalsIgnoreCase("perimeter")){
                    System.out.println("Enter length of first side");
                    int a = sc.nextInt();
                    System.out.println("Enter length of second side");
                    int b = sc.nextInt();
                    System.out.println("Enter length of third side");
                    int c = sc.nextInt();
                    t.calculatePerimeter(a,b,c);
                }

            }
            else if (shape.equalsIgnoreCase("rectangle")){
                Rectangle r = new Rectangle();
                System.out.println("Enter Operation to be performed : ");
                String operation = sc.next();
                System.out.println("Enter length : ");
                int l = sc.nextInt();
                System.out.println("Enter breadth : ");
                int b = sc.nextInt();
                if (operation.equalsIgnoreCase("area")){
                    r.calculateArea(l,b);
                }
                else if (operation.equalsIgnoreCase("perimeter")){
                    r.calculatePerimeter(l,b);
                }
            }
            else if (shape.equalsIgnoreCase("square")){
                Square r = new Square();
                System.out.println("Enter Operation to be performed : ");
                String operation = sc.next();
                System.out.println("Enter side : ");
                int l = sc.nextInt();
                if (operation.equalsIgnoreCase("area")){
                    r.calculateArea(l);
                }
                else if (operation.equalsIgnoreCase("perimeter")){
                    r.calculatePerimeter(l);
                }
            }
            else if (shape.equalsIgnoreCase("cylinder")){
                Cylinder c = new Cylinder();
                System.out.println("Enter Operation to be performed : ");
                String operation = sc.next();
                System.out.println("Enter radius : ");
                int r = sc.nextInt();
                System.out.println("Enter height : ");
                int h = sc.nextInt();
                if (operation.equalsIgnoreCase("area")){
                    c.calculateArea(r,h);
                }
                else if (operation.equalsIgnoreCase("perimeter")){
                    c.calculatePerimeter(r);
                }
                else if (operation.equalsIgnoreCase("Volume")){
                    c.calculateVolume(r,h);
                }
            }
            else if (shape.equalsIgnoreCase("circle")){
                Circle c = new Circle();
                System.out.println("Enter Operation to be performed : ");
                String operation = sc.next();
                System.out.println("Enter radius : ");
                int r = sc.nextInt();
                if (operation.equalsIgnoreCase("area")){
                    c.calculateArea(r);
                }
                else if (operation.equalsIgnoreCase("perimeter")) {
                    c.calculatePerimeter(r);
                }
            }
            else if (shape.equalsIgnoreCase("Sphere")){
                Sphere s = new Sphere();
                System.out.println("Enter Operation to be performed : ");
                String operation = sc.next();
                System.out.println("Enter radius : ");
                int r = sc.nextInt();
                if (operation.equalsIgnoreCase("area")){
                    s.calculateArea(r);
                }
                else if (operation.equalsIgnoreCase("perimeter")) {
                    s.calculatePerimeter(r);
                }
                else if (operation.equalsIgnoreCase("Volume")) {
                    s.calculateVolume(r);
                }
            }
            else if (shape.equalsIgnoreCase("done")){
                break;
            }
            else{
                System.out.println("shape not found");
            }

        }
    }
}
