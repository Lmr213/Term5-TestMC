package com.example.grouptest;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class csvCompareTest_YangHaocheng {

    //2.At least one of the input csv files has no entry
    //2.1 Only one of the csv file is empty
    @Test
    public void testCompcsv1() {
        CSVcomparator csvcomparer = new CSVcomparator();
        List<List<String>> list1 = csvcomparer.read_csv_file_yhc("/Users/lmr/Desktop/Week9 csvfiles/class2/class2_boundary1.csv");
        List<List<String>> list2 = csvcomparer.read_csv_file_yhc("/Users/lmr/Desktop/Week9 csvfiles/class2/class2_boundary2.csv");

        String expect = "[[\"ID1\", \"BOS963241\", \"USD\", \"SAVINGS\", \"963432\"], [\"ID2\", \"BO4534452\", \"AUD\", \"CURRENT\", \"987124\"], [\"ID3\", \"BOS756613\", \"AUD\", \"CURRENT\", \"556740\"], [\"ID4\", \"BOS56824\", \"INR\", \"CURRENT\", \"756568\"]]";
        String result = csvcomparer.compare_csv_file_yhc(list1, list2).toString();

        Assert.assertEquals(expect, result);
    }

    //2.2 Both of the two input files are empty
    @Test
    public void testCompcsv2() {
        CSVcomparator csvcomparer = new CSVcomparator();
        List<List<String>> list1 = csvcomparer.compare_csv_file_yhc("/Users/lmr/Desktop/Week9 csvfiles/class2/class2_middle1.csv");
        List<List<String>> list2 = csvcomparer.compare_csv_file_yhc("/Users/lmr/Desktop/Week9 csvfiles/class2/class2_middle2.csv");

        String expect = "[]";
        String result = csvcomparer.compare_csv_file_yhc(list1, list2).toString();

        Assert.assertEquals(expect, result);
    }

    //3. Two input csv files have different number of entries:
    //3.1 The number of entries of one file is only one entry less/more than another file
    @Test
    public void testCompcsv3() {
        CSVcomparator csvcomparer = new CSVcomparator();
        List<List<String>> list1 = csvcomparer.compare_csv_file_yhc("/Users/lmr/Desktop/Week9 csvfiles/class3/class3_boundary11.csv");
        List<List<String>> list2 = csvcomparer.compare_csv_file_yhc("/Users/lmr/Desktop/Week9 csvfiles/class3/class3_boundary12.csv");

        String expect = "[[\"ID3\", \"BOS756613\", \"INR\", \"CURRENT\", \"556740\"], [\"ID4\", \"BOS56824\", \"USD\", \"SAVINGS\", \"777878\"], [\"ID2\", \"BO4534452\", \"AUD\", \"CURRENT\", \"987124\"], [\"ID3\", \"BOS756613\", \"AUD\", \"CURRENT\", \"556740\"], [\"ID4\", \"BOS56824\", \"INR\", \"CURRENT\", \"756568\"]]";
        String result = csvcomparer.compare_csv_file_yhc(list1, list2).toString();

        Assert.assertEquals(expect, result);
    }

    //3.2 Both files have several (>=1) repeat customer IDs
    @Test
    public void testCompcsv4() {
        CSVcomparator csvcomparer = new CSVcomparator();
        List<List<String>> list1 = csvcomparer.compare_csv_file_yhc("/Users/lmr/Desktop/Week9 csvfiles/class3/class3_boundary21.csv");
        List<List<String>> list2 = csvcomparer.compare_csv_file_yhc("/Users/lmr/Desktop/Week9 csvfiles/class3/class3_boundary22.csv");

        String expect = "[[\"ID2\", \"BO4534452\", \"AUD\", \"CURRENT\", \"987124\"], [\"ID3\", \"BOS756613\", \"AUD\", \"CURRENT\", \"556740\"], [\"ID4\", \"BOS56824\", \"INR\", \"CURRENT\", \"756568\"]]";
        String result = csvcomparer.compare_csv_file_yhc(list1, list2).toString();

        Assert.assertEquals(expect, result);
    }

    //3.3 One file has more/less (the difference is larger than one) entries than another one and none of them has zero entry.
    @Test
    public void testCompcsv5() {
        CSVcomparator csvcomparer = new CSVcomparator();
        List<List<String>> list1 = csvcomparer.compare_csv_file_yhc("/Users/lmr/Desktop/Week9 csvfiles/class3/class3_middle1.csv");
        List<List<String>> list2 = csvcomparer.compare_csv_file_yhc("/Users/lmr/Desktop/Week9 csvfiles/class3/class3_middle2.csv");

        String expect = "[[\"ID1\", \"BOS963241\", \"USD\", \"SAVINGS\", \"963432\"], [\"ID2\", \"BOS85962\", \"AUD\", \"CURRENT\", \"987124\"], [\"ID3\", \"BOS756613\", \"INR\", \"CURRENT\", \"556740\"], [\"ID4\", \"BOS56824\", \"USD\", \"SAVINGS\", \"777878\"], [\"ID1\", \"BOS963241\", \"USD\", \"SAVINGS\", \"123234\"], [\"ID2\", \"BO4534452\", \"USD\", \"CURRENT\", \"987124\"], [\"ID3\", \"BOS331613\", \"AUD\", \"SAVINGS\", \"556740\"], [\"ID4\", \"BOS56824\", \"INR\", \"CURRENT\", \"711458\"], [\"ID5\", \"BOS963241\", \"USD\", \"SAVINGS\", \"963432\"], [\"ID6\", \"BO4534452\", \"AUD\", \"CURRENT\", \"987124\"], [\"ID7\", \"BOS756613\", \"AUD\", \"CURRENT\", \"556740\"]]";
        String result = csvcomparer.compare_csv_file_yhc(list1, list2).toString();

        Assert.assertEquals(expect, result);
    }

    //4. Compare two files with the flipped rows
    @Test
    public void testCompcsv6() {
        CSVcomparator csvcomparer = new CSVcomparator();
        List<List<String>> list1 = csvcomparer.compare_csv_file_yhc("/Users/lmr/Desktop/Week9 csvfiles/class4/class4_boundary1.csv");
        List<List<String>> list2 = csvcomparer.compare_csv_file_yhc("/Users/lmr/Desktop/Week9 csvfiles/class4/class4_boundary2.csv");

        String expect = "[[\"ID4\", \"BOS76844\", \"AUD\", \"SAVINGS\", \"672878\"], [\"ID5\", \"BOS76844\", \"AUD\", \"SAVINGS\", \"672878\"]]";
        String result = csvcomparer.compare_csv_file_yhc(list1, list2).toString();

        Assert.assertEquals(expect, result);
    }


    //5. Exist at least one entry which the type of the data in a certain filed are not matched with the corresponding already defined data type.
    @Test
    public void testCompcsv7() {
        CSVcomparator csvcomparer = new CSVcomparator();
        List<List<String>> list1 = csvcomparer.compare_csv_file_yhc("/Users/lmr/Desktop/Week9 csvfiles/class6/class6_boundary1.csv");
        List<List<String>> list2 = csvcomparer.compare_csv_file_yhc("/Users/lmr/Desktop/Week9 csvfiles/class6/class6_boundary2.csv");

        String expect = "[[\"ID1\", \"BOS963241\", \"USD\", \"SAVINGS\", \"963432\"], [\"ID2\", \"BOS85962\", \"AUD\", \"CURRENT\", \"SRD124\"], [\"ID3\", \"BOS756613\", \"INR\", \"CURRENT\", \"556740\"], [\"ID4\", \"BOS56824\", \"USD\", \"SAVINGS\", \"777878\"], [\"ID1\", \"BOS433241\", \"USD\", \"SAVINGS\", \"873432\"], [\"ID2\", \"BOS86542\", \"AUD\", \"CURRENT\", \"534124\"], [\"ID3\", \"BOS123413\", \"INR\", \"SAVINGS\", \"519240\"], [\"ID4\", \"BOS56544\", \"AUD\", \"SAVINGS\", \"668878\"]]";
        String result = csvcomparer.compare_csv_file_yhc(list1, list2).toString();

        Assert.assertEquals(expect, result);
    }

    //6. Both files have several (>=1) repeat customer IDs
    public void testCompcsv8() {
        CSVcomparator csvcomparer = new CSVcomparator();
        List<List<String>> list1 = csvcomparer.read_csv_file_yhc("/Users/lmr/Desktop/Week9 csvfiles/class6/class6_middle1.csv");
        List<List<String>> list2 = csvcomparer.read_csv_file_yhc("/Users/lmr/Desktop/Week9 csvfiles/class6/class6_middle2.csv");

        String expect = "[[\"ID2\", \"YUH86542\", \"AUD\", \"CURRENT\", \"UIJ124\"], [\"ID4\", \"UIY56544\", \"AUD\", \"SAVINGS\", \"668878\"], [\"ID2\", \"78886542\", \"AUD\", \"CURRENT\", \"534124\"], [\"ID4\", \"12356544\", \"AUD\", \"SAVINGS\", \"668878\"]]";
        String result = csvcomparer.compare_csv_file_yhc(list1, list2).toString();

        Assert.assertEquals(expect, result);
    }




}
