package com.blstream.fryga;

/**
 * Created by user on 02.03.2016.
 */
public class Main {


    public static void main(String [] args)
    {
        FrygaClass frygaTime = new FrygaClass(args[0]); //Argument as time (hh:mm:ss)
        System.out.println(frygaTime.getFrygaTime());
    }
}
