package com.company;

class Account{
    int balance = 1000;
    void withdraw(String s , int b){
        if (balance >= b){
            balance = balance - b;
            System.out.println(s +" withdrew "+b+" amount of money");
            System.out.println("New balance " + balance);
        }
        else{
            System.out.println("Not enough money");
        }
    }
}

class AccountOverdrawSafeDemo extends Thread{
    Account ac;
    String name;
    int balance;
    AccountOverdrawSafeDemo(Account ob, String n, int b)
    {
        ac = ob;
        name = n;
        balance = b;
    }

    public void run(){
        ac.withdraw(name, balance);
    }
}

public class Problem_statement_4_OverdrawnSafeDemo {
    public static void main(String[] args) {
        Account acc = new Account();
        for (int i =0 ;i<5;i++){
            AccountOverdrawSafeDemo a = new AccountOverdrawSafeDemo(acc, "a", 100);
            a.start();
        }
        for (int i =0 ;i<5;i++){
            AccountOverdrawSafeDemo b = new AccountOverdrawSafeDemo(acc, "b", 100);
            b.start();
        }
    }

}
