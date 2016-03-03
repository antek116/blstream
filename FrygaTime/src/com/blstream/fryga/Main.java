package com.blstream.fryga;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static String regex = "(\\b([0-5][0-9]:){2})[0-5][0-9]\\b";
    public static void main(String [] args)
    {
        if(args[0] != null) {
            if (isArgOkay(args[0])){
                FrygaClass frygaTime = new FrygaClass(args[0]); //Argument as time (hh:mm:ss)
                System.out.println(frygaTime.getFrygaTime());
            } else {
                System.out.println("Wrong argument");
            }
        }
        else        {
            System.out.println("No Args detected");
        }
    }
    protected static boolean isArgOkay(String arg)
    {
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(arg);
        return m.find();
    }
}
