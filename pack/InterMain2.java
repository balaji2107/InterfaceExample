package com.Interface.pack;

public class InterMain2 {
    public static void main(String[] args) {
        Box b=new Box();
        System.out.println(b.colour);
        b.open();
        b.close();
        b.isTheft();
        System.out.println("-------------");
        Pen p=new Box();
        System.out.println(p.colour);
        p.open();
        p.close();
        p.write();
        System.out.println("-------------");
        System.out.println("Upcasting....");
        Box box=(Box)p;
        box.store();
    }
}
