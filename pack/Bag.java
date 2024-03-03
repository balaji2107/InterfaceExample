package com.Interface.pack;

public class Bag extends Box implements InterOne,InterTwo,InterThree,InterFour,InterFive{
    String colour="Orange";
    int size;
    String shape;
    public void state(){
        System.out.println("Bag current state is Open..");
    }
    public void open(){
        System.out.println("Bag Open...");
    }
    public void close(){
        System.out.println("Bag Close...");
    }
    public void cleaning(){
        System.out.println("Bag cleaning...");
    }
    public void travel(){
        System.out.println("Bag Travel...");
    }
}
