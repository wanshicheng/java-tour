package com.skillip.java.juc.lock.deadlock;

public class Account {
    private String name;
    private int balance;

    public Account(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public static void main(String[] args) throws InterruptedException {
        Account a = new Account("A", 1000000);
        Account b = new Account("B", 1000000);
        Account c = new Account("C", 0);

        Thread t1 = new Thread("t1") {
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    a.transfer(b, 1);
//                    System.out.println("ThreadA: " + "a: " + a.balance + ", b:" + b.balance + " c:" + c.balance);
                }
            }
        };

        Thread t2 = new Thread("t2") {
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    b.transfer(c, 1);
//                    System.out.println("ThreadB: " + "a: " + a.balance + ", b:" + b.balance + " c:" + c.balance);
                }
            }
        };

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("a: " + a.balance + ", b:" + b.balance + " c:" + c.balance);
    }

    synchronized void transfer(Account target, int amt) {
        if (this.balance >= amt) {
            this.balance -= amt;
            target.balance += amt;
        }
    }
}
