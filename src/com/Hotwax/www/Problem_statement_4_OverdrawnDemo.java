package com.company;

class Accountt extends Thread {
    String name;
    int balance = 1000;
    int getBalance(){
        return balance;
    }
    public void run(){
        int i =0;
        while(i<5){
            balance = balance - 100;
            System.out.println("b"+balance);
            i+=1;
        }

    }
}

class AccountOverdrawDemo1 {
    public void main() {
        Accountt boy1 = new Accountt();
        boy1.name = "vin";
        boy1.run();
        boy1.start();

        for(int i =0 ; i<5;i++){
            boy1.balance = boy1.balance-100;
            System.out.println("a"+boy1.balance);
        }
    }
}
public class Problem_statement_4_OverdrawnDemo {
    public static void main(String[] args) {
        AccountOverdrawDemo1 acc = new AccountOverdrawDemo1();
//        AccountOverdrawDemo1 acc = new AccountOverdrawDemo1();
        acc.main();
    }
}
