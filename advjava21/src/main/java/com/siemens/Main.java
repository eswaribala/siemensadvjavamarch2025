package com.siemens;

public class Main {
    public static void main(String[] args) {

        String name="Parameswari";
        //functional interface runnable with lambda
        //implemented runnable interface
        Runnable runnable =()->{
            for(char ch : name.toCharArray()){
                System.out.println(ch);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();


    }
}