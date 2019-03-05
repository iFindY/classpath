package de.arkadi.reflection;

import de.arkadi.reflection.IPrint;

public class ImplPrint implements IPrint{

    public void print() {
        System.out.println("privet from ImplPrint Class !!");
    }
    
    public void doSome(){
    	System.out.println("working");
    }
}