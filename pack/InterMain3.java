package com.Interface.pack;

public class InterMain3 {
    public static void main(String[] args) {
        Bag bag=new Bag();
        System.out.println(bag.colour);
        bag.open();
        bag.close();
        bag.cleaning();
        bag.travel();
        bag.state();

        Box b=new Bag();
        System.out.println(b.colour);
        b.open();
        b.close();
        b.play();

        Pen p=new Bag();
        System.out.println(p.colour);
        p.open();
        p.close();
        p.write();
    }
}
