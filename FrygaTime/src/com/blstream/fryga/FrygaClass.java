package com.blstream.fryga;

import org.jetbrains.annotations.NotNull;

/**
*Represent a class of Time on Fryga
 */
public class FrygaClass {

    private int hours;
    private int minutes;
    private int seconds;
    private StringBuffer onFrygaTime;

    /**
     * Creating a instance of fryga with parametr as a time
     * @param time  Time must be input in special format(hh:mm:ss).
     */
    public FrygaClass(String time){
        String parts[] = time.split(":");
        this.onFrygaTime = new StringBuffer();
        this.hours = Integer.parseInt(parts[0]);
        this.minutes = Integer.parseInt(parts[1]);
        this.seconds = Integer.parseInt(parts[2]);
    };

    private void setSecounds(){
        if(seconds % 2 != 1)
        {
            this.onFrygaTime.append("Y ");
        }
        else
        {
            this.onFrygaTime.append("O ");
        }

    }
    private void setHours(){
        int firstRow = hours / 5;
        int secondRow = hours % 5;
        StringBuffer oneHoursBuffer = new StringBuffer();
        oneHoursBuffer.append(" ");

        for(int i = 1; i<= 4 ;i++)
        {
            if(i <= firstRow && firstRow != 0)
                this.onFrygaTime.append("R");
            else
                this.onFrygaTime.append("O");
            if(i <= secondRow && secondRow !=0)
                oneHoursBuffer.append("R");
            else
                oneHoursBuffer.append("O");
        }
        this.onFrygaTime.append(oneHoursBuffer.toString() + " ");
    }
    private void setMinutes() {
        String[] minutesArray = new String[11];
        int howManyQuarter = minutes / 15;
        int howManyFives = minutes / 5;
        int restMinutes = minutes % 5;

        for (int i = 0; i < minutesArray.length; i++) {
            if (i < howManyFives)
                minutesArray[i] = "Y";
            else
                minutesArray[i] = "O";
            if (i % 3 == 0 && i <= howManyQuarter * 3 && i > 0)
                minutesArray[i -1] = "R";
        }
        this.onFrygaTime.append(getStringFromArray(minutesArray) + " ");
        for (int i = 1; i <=4; i++) {
            if (i <= restMinutes && restMinutes != 0)
                this.onFrygaTime.append("Y");
            else
                this.onFrygaTime.append("O");
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

    /**
     * Get the time on a Fryga
     * @return Return time in special format as a String;
     */
    public String getFrygaTime(){

        setSecounds();
        setHours();
        setMinutes();

        return this.onFrygaTime.toString();
    }

}
