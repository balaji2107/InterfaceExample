package com.Interface.pack;

public class InterMain {
    public static void main(String[] args) {
        Pen p=new Pen();
        System.out.println(p.colour);
        p.open();
        p.close();
        p.state();
        System.out.println("/** Object can be store Interface **/");
        InterOne i1=new Pen();
        i1.open();
        i1.close();
        i1.write();

    }
}
