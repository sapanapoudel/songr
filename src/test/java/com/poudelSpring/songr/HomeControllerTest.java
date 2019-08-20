package com.poudelSpring.songr;

import org.junit.Test;

import static org.junit.Assert.*;

public class HomeControllerTest {
    @Test
    public void helloWorldRouteTest() {
        assertEquals("Should be same", "World Hello",
                HomeController.reverseWord("Hello World") );
    }

    @Test
    public void helloWorldRouteTest_differentWords() {
        assertEquals("Should be same", "Sapana is name My",
                HomeController.reverseWord("My name is Sapana") );
    }

}