package com.Interface.pack;

public class Box extends Pen implements InterTwo,InterThree,InterFour{
    String colour="Blue";
    int size;
    String shape;
    public void state(){
        System.out.println("Box Current status Open..");
    }
    public void open(){
        System.out.println("Box Open...");
    }
    public void close(){
        System.out.println("Box Close...");
    }
    public void isTheft(){
        System.out.println("Box theft...");
    }
    public void store(){
        System.out.println("Box Store...");
    }
    public void play(){
        System.out.println("Box Playing...");
    }
}

