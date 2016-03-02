package com.blstream.fryga;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 02.03.2016.
 */
public class FrygaClassTest {

    @Test
    public void testGetFrygaTime() throws Exception {

        FrygaClass frygaTest = new FrygaClass("13:17:01");
        assertEquals("O RROO RRRO YYROOOOOOOO YYOO",frygaTest.getFrygaTime());
        FrygaClass frygaTest1 = new FrygaClass("00:00:00");
        assertEquals("Y OOOO OOOO OOOOOOOOOOO OOOO", frygaTest1.getFrygaTime());
        FrygaClass frygaTest2 = new FrygaClass("23:59:59");
        assertEquals("O RRRR RRRO YYRYYRYYRYY YYYY", frygaTest2.getFrygaTime());
        FrygaClass frygaTest3 = new FrygaClass("24:00:00");
        assertEquals("Y RRRR RRRR OOOOOOOOOOO OOOO", frygaTest3.getFrygaTime());
    }
}