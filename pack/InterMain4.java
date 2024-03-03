package com.Interface.pack;

public class InterMain4 {
    public static void main(String[] args) {
        InterOne i1=new Box();
        i1.write();
        i1.open();
        i1.close();

        InterTwo i2=new Box();
        i2.open();
        i2.close();
        i2.isTheft();

        InterThree i3=new Bag();
        i3.open();
        i3.close();
        i3.state();


    }
}
