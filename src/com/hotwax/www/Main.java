package com.hotwax.www;

import java.util.Scanner;

class Triangle{
    int height;
    int base;

    void getDimensions(int height , int base){
        this.height = height;
        this.base = base;
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
            System.out.println("Enter shape ---\nType--\nTriangle\nRectangle\nSquare\nCylinder\nCircle\nSphere\nexit");
            Scanner sc = new Scanner(System.in);
            String shape = sc.next();
            if (shape.equalsIgnoreCase( "triangle")){
                Triangle triangle = new Triangle();
                System.out.println("Enter Operation to be performed : ");
                System.out.println("Choose between Area and Perimeter");
                String operation = sc.next();

                if (operation.equalsIgnoreCase("area")){
                    System.out.print("Enter height of Triangle : ");
                    int height = sc.nextInt();
                    System.out.print("Enter base of Triangle : ");
                    int base = sc.nextInt();
                    triangle.getDimensions(height, base);
                    triangle.calculateArea();
                }
                if (operation.equalsIgnoreCase("perimeter")){
                    System.out.println("Enter length of first side");
                    int a = sc.nextInt();
                    System.out.println("Enter length of second side");
                    int b = sc.nextInt();
                    System.out.println("Enter length of third side");
                    int c = sc.nextInt();
                    triangle.calculatePerimeter(a,b,c);
                }

            }
            else if (shape.equalsIgnoreCase("rectangle")){
                Rectangle rectangle = new Rectangle();
                System.out.println("Enter Operation to be performed : ");
                System.out.println("Choose between Area and Perimeter");
                String operation = sc.next();
                System.out.println("Enter length : ");
                int length = sc.nextInt();
                System.out.println("Enter breadth : ");
                int breadth = sc.nextInt();
                if (operation.equalsIgnoreCase("area")){
                    rectangle.calculateArea(length,breadth);
                }
                else if (operation.equalsIgnoreCase("perimeter")){
                    rectangle.calculatePerimeter(length,breadth);
                }
            }
            else if (shape.equalsIgnoreCase("square")){
                Square square = new Square();
                System.out.println("Enter Operation to be performed : ");
                System.out.println("Choose between Area and Perimeter");
                String operation = sc.next();
                System.out.println("Enter side : ");
                int side = sc.nextInt();
                if (operation.equalsIgnoreCase("area")){
                    square.calculateArea(side);
                }
                else if (operation.equalsIgnoreCase("perimeter")){
                    square.calculatePerimeter(side);
                }
            }
            else if (shape.equalsIgnoreCase("cylinder")){
                Cylinder cylinder = new Cylinder();
                System.out.println("Enter Operation to be performed : ");
                System.out.println("Choose between Area, Perimeter and Volume");
                String operation = sc.next();
                System.out.println("Enter radius : ");
                int radius = sc.nextInt();
                System.out.println("Enter height : ");
                int height = sc.nextInt();
                if (operation.equalsIgnoreCase("area")){
                    cylinder.calculateArea(radius,height);
                }
                else if (operation.equalsIgnoreCase("perimeter")){
                    cylinder.calculatePerimeter(radius);
                }
                else if (operation.equalsIgnoreCase("Volume")){
                    cylinder.calculateVolume(radius,height);
                }
            }
            else if (shape.equalsIgnoreCase("circle")){
                Circle circle = new Circle();
                System.out.println("Enter Operation to be performed : ");
                System.out.println("Choose between Area and Perimeter");
                String operation = sc.next();
                System.out.println("Enter radius : ");
                int radius = sc.nextInt();
                if (operation.equalsIgnoreCase("area")){
                    circle.calculateArea(radius);
                }
                else if (operation.equalsIgnoreCase("perimeter")) {
                    circle.calculatePerimeter(radius);
                }
            }
            else if (shape.equalsIgnoreCase("Sphere")){
                Sphere sphere = new Sphere();
                System.out.println("Enter Operation to be performed : ");
                System.out.println("Choose between Area, Perimeter and Volume");
                String operation = sc.next();
                System.out.println("Enter radius : ");
                int radius = sc.nextInt();
                if (operation.equalsIgnoreCase("area")){
                    sphere.calculateArea(radius);
                }
                else if (operation.equalsIgnoreCase("perimeter")) {
                    sphere.calculatePerimeter(radius);
                }
                else if (operation.equalsIgnoreCase("Volume")) {
                    sphere.calculateVolume(radius);
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
