package com.goal.jpademo.liskov;

public class Joy extends Animal{
    public Joy(String name) {
        super(name);
    }

    public void joySpeak(){
        System.out.println("LODAA");
    }
}
