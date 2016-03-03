package com.blstream.fryga;

import org.jetbrains.annotations.NotNull;

/**
*Represent a class of Time on Fryga
 */

public class FrygaClass {

    static String redColor = "R";
    static String yellowColor = "Y";
    static String turnedOffColor ="O";
    static int eachRedRowSize = 4;
    static int fiveMinutesArraySize = 11;


    private int hours;
    private int minutes;
    private int seconds;
    private StringBuilder onFrygaTime;

    /**
     * Creating a instance of fryga with parametr as a time
     * @param time  Time must be input in special format(hh:mm:ss).
     */
    public FrygaClass(String time){
        String parts[] = time.split(":");
        this.onFrygaTime = new StringBuilder();
        this.hours = Integer.parseInt(parts[0]);
        this.minutes = Integer.parseInt(parts[1]);
        this.seconds = Integer.parseInt(parts[2]);
    }
    /**
     * Get the time on a Fryga
     * @return Return time in special format as a String;
     */
    public String getFrygaTime(){

        appendSecounds();
        appendHours();
        appendMinutes();

        return this.onFrygaTime.toString();
    }

    protected String appendSecounds(){
        if(seconds % 2 != 1)
        {
            this.onFrygaTime.append(turnedOffColor);
        }
        else
        {
            this.onFrygaTime.append(yellowColor);
        }
        onFrygaTime.append(" ");
        return onFrygaTime.toString();
    }
    private void appendHours(){
        int firstRow = hours / 5;
        int secondRow = hours % 5;
        StringBuilder oneHoursBuffer = new StringBuilder();
        oneHoursBuffer.append(" ");

        for(int i = 1; i<= eachRedRowSize ;i++)
        {
            if(i <= firstRow && firstRow != 0){
                this.onFrygaTime.append(redColor);}
            else{
                this.onFrygaTime.append(turnedOffColor);}
            if(i <= secondRow && secondRow !=0){
                oneHoursBuffer.append(redColor);}
            else{
                oneHoursBuffer.append(turnedOffColor);}
        }
        this.onFrygaTime.append(oneHoursBuffer.toString());
        this.onFrygaTime.append(" ");
    }
    private void appendMinutes() {
        String[] minutesArray = new String[fiveMinutesArraySize];
        int howManyQuarter = minutes / 15;
        int howManyFives = minutes / 5;
        int restMinutes = minutes % 5;

        for (int i = 0; i < minutesArray.length; i++) {
            if (i < howManyFives)
                minutesArray[i] = redColor;
            else
                minutesArray[i] = turnedOffColor;
            if (i % 3 == 0 && i <= howManyQuarter * 3 && i > 0)
                minutesArray[i -1] = redColor;
        }
        this.onFrygaTime.append(getStringFromArray(minutesArray));
        this.onFrygaTime.append(" ");
        for (int i = 1; i <=4; i++) {
            if (i <= restMinutes && restMinutes != 0)
                this.onFrygaTime.append(yellowColor);
            else
                this.onFrygaTime.append(turnedOffColor);
        }
    }

    @NotNull
    private String getStringFromArray(String[] array)
    {
        StringBuilder builder = new StringBuilder();
        for(String s : array) {
            builder.append(s);
        }
        return builder.toString();
    }

}
