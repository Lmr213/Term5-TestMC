package com.example.testmc;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class csvReadTest {

    //1. At least one of the input files are invalid
    //1.1 read two valid csv files
    @Test
    public void testReadcsv1() {
        csvComparer csvcomparer = new csvComparer();
        String expect1 = "[[\"ID1\", \"BOS963241\", \"USD\", \"SAVINGS\", \"963432\"], [\"ID2\", \"BO4534452\", \"AUD\", \"CURRENT\", \"987124\"], [\"ID3\", \"BOS756613\", \"AUD\", \"CURRENT\", \"556740\"], [\"ID4\", \"BOS56824\", \"INR\", \"CURRENT\", \"756568\"]]";
        String result1 = csvcomparer.read_csv_file("/Users/lmr/Desktop/Week9 csvfiles/class1/class11.csv").toString();
        Assert.assertEquals(expect1, result1);
        String expect2 = "[[\"ID1\", \"BOS963241\", \"USD\", \"SAVINGS\", \"123234\"], [\"ID2\", \"BO4534452\", \"USD\", \"CURRENT\", \"987124\"], [\"ID3\", \"BOS331613\", \"AUD\", \"SAVINGS\", \"556740\"], [\"ID4\", \"BOS56824\", \"INR\", \"CURRENT\", \"711458\"]]";
        String result2 = csvcomparer.read_csv_file("/Users/lmr/Desktop/Week9 csvfiles/class1/class12.csv").toString();
        Assert.assertEquals(expect2, result2);
    }

    //1.2 There is exact one input file is invalid and another one is valid csv file
    @Test
    public void testReadcsv2 () {
        csvComparer csvcomparer = new csvComparer();
        String expect = "[[\"ID1\", \"BOS963241\", \"USD\", \"SAVINGS\", \"123234\"], [\"ID2\", \"BO4534452\", \"USD\", \"CURRENT\", \"987124\"], [\"ID3\", \"BOS331613\", \"AUD\", \"SAVINGS\", \"556740\"], [\"ID4\", \"BOS56824\", \"INR\", \"CURRENT\", \"711458\"]]";
        String result = csvcomparer.read_csv_file("/Users/lmr/Desktop/Week9 csvfiles/class1/class1_boundary2.csv").toString();
        assertEquals(expect,result);
        try {
            csvcomparer.read_csv_file("/Users/lmr/Desktop/Week9 csvfiles/class1/Android Lesson 1.pdf");
            fail("didn't catch wrong file type error)");
        } catch (Exception e) {
            System.out.println("successfully caught wrong file type error");
        }
    }

    //1.3 Both two input files are invalid (eg: invalid file name)
    @Test
    public void testReadcsv3 () {
        csvComparer csvcomparer = new csvComparer();
        try {
            csvcomparer.read_csv_file("/Users/lmr/Desktop/Week9 csvfiles/class1/Android Lesson 2.pdf");
            fail("didn't catch wrong file type error)");
        } catch (Exception e) {
            System.out.println("successfully caught wrong file type error");
        }
        try {
            csvcomparer.read_csv_file("/Users/lmr/Desktop/Week9 csvfiles/class1/Android Lesson 3.pdf");
            fail("didn't catch wrong file type error)");
        } catch (Exception e) {
            System.out.println("successfully caught wrong file type error");
        }
    }

}