package com.blstream.fryga;


public class Main {

    public static void main(String [] args)
    {
        FrygaClass frygaTime = new FrygaClass(args[0]); //Argument as time (hh:mm:ss)
        System.out.println(frygaTime.getFrygaTime());
    }
}
