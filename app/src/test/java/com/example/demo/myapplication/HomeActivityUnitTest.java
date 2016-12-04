package com.example.demo.myapplication;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class HomeActivityUnitTest {
    HomeActivity ha = new HomeActivity();

    @Test
    public void processData_isCorrect1() throws Exception {
        String rawData = "";

        assertEquals(ha.processData(rawData).size(), 0);
    }

    @Test
    public void processData_isCorrect2() throws Exception {
        String rawData = "<br>";

        assertEquals(ha.processData(rawData).size(), 1);
        assertEquals(ha.processData(rawData).get(0).isEmpty(), true);
    }

    @Test
    public void processData_isCorrect3() throws Exception {
        String rawData = "COMP3006 Software Engineering<br>";

        assertEquals(ha.processData(rawData).size(), 1);
        assertEquals(ha.processData(rawData).get(0).equals("COMP3006 Software Engineering"), true);
    }

    @Test
    public void processData_isCorrect4() throws Exception {
        assertEquals(ha.processData("<br>COMP3006 Software Engineering<br><br>COMP3005 Design and Analysis of Algorithms<br><br>").size(), 5);
    }

    @Test
    public void processData_isCorrect5() throws Exception {
        String rawData = "COMP3006 Software Engineering<br>COMP3005 De";

        assertEquals(ha.processData(rawData).size(), 2);
        assertEquals(ha.processData(rawData).get(1).equals("COMP3005 De"), true);
    }

}