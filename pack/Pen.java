package com.Interface.pack;

public class Pen implements InterOne{
    String colour="Red";
    int size;
    String shape;
    public void state(){
        System.out.println("Pen current state is Open..");
    }
    public void open(){
        System.out.println("Pen Open...");
    }
    public void close(){
        System.out.println("Pen Close...");
    }
    public void write(){
        System.out.println("Pen write...");
    }
    public void drawing(){
        System.out.println("Pen Drawing...");
    }
}

