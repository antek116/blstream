package com.blstream.fryga;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * Created by user on 02.03.2016.
 */
public class MainTest {


    @Test
    public void shouldReturnTrue() throws Exception {
         Main main = new Main();
        assertEquals("Is arg okay?",true,Main.isArgOkay("13:17:19"));
    }
    @Test
    public void shouldReturnFalse() throws Exception {
        Main main = new Main();
        assertEquals("Is arg okay?",false,Main.isArgOkay("ab:00:19"));
    }
}