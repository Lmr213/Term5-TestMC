package com.example.testmc;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class csvCompareTest {

    //2.At least one of the input csv files has no entry
    //2.1 Only one of the csv file is empty
    @Test
    public void testCompcsv1() {
        csvComparer csvcomparer = new csvComparer();
        List<List<String>> list1 = csvcomparer.read_csv_file("/Users/lmr/Desktop/Week9 csvfiles/class2/class2_boundary1.csv");
        List<List<String>> list2 = csvcomparer.read_csv_file("/Users/lmr/Desktop/Week9 csvfiles/class2/class2_boundary2.csv");

        String expect = "[[\"ID1\", \"BOS963241\", \"USD\", \"SAVINGS\", \"963432\"], [\"ID2\", \"BO4534452\", \"AUD\", \"CURRENT\", \"987124\"], [\"ID3\", \"BOS756613\", \"AUD\", \"CURRENT\", \"556740\"], [\"ID4\", \"BOS56824\", \"INR\", \"CURRENT\", \"756568\"]]";
        String result = csvcomparer.compare_csv_file(list1, list2).toString();

        Assert.assertEquals(expect, result);
    }

    //2.2 Both of the two input files are empty
    @Test
    public void testCompcsv2() {
        csvComparer csvcomparer = new csvComparer();
        List<List<String>> list1 = csvcomparer.read_csv_file("/Users/lmr/Desktop/Week9 csvfiles/class2/class2_middle1.csv");
        List<List<String>> list2 = csvcomparer.read_csv_file("/Users/lmr/Desktop/Week9 csvfiles/class2/class2_middle2.csv");

        String expect = "[]";
        String result = csvcomparer.compare_csv_file(list1, list2).toString();

        Assert.assertEquals(expect, result);
    }

    //3. Two input csv files have different number of entries:
    //3.1 The number of entries of one file is only one entry less/more than another file
    @Test
    public void testCompcsv3() {
        csvComparer csvcomparer = new csvComparer();
        List<List<String>> list1 = csvcomparer.read_csv_file("/Users/lmr/Desktop/Week9 csvfiles/class3/class3_boundary11.csv");
        List<List<String>> list2 = csvcomparer.read_csv_file("/Users/lmr/Desktop/Week9 csvfiles/class3/class3_boundary12.csv");

        String expect = "[[\"ID3\", \"BOS756613\", \"INR\", \"CURRENT\", \"556740\"], [\"ID4\", \"BOS56824\", \"USD\", \"SAVINGS\", \"777878\"], [\"ID2\", \"BO4534452\", \"AUD\", \"CURRENT\", \"987124\"], [\"ID3\", \"BOS756613\", \"AUD\", \"CURRENT\", \"556740\"], [\"ID4\", \"BOS56824\", \"INR\", \"CURRENT\", \"756568\"]]";
        String result = csvcomparer.compare_csv_file(list1, list2).toString();

        Assert.assertEquals(expect, result);
    }

    //3.2 One file has one entries and another one has more than one entries
    @Test
    public void testCompcsv4() {
        csvComparer csvcomparer = new csvComparer();
        List<List<String>> list1 = csvcomparer.read_csv_file("/Users/lmr/Desktop/Week9 csvfiles/class3/class3_boundary21.csv");
        List<List<String>> list2 = csvcomparer.read_csv_file("/Users/lmr/Desktop/Week9 csvfiles/class3/class3_boundary22.csv");

        String expect = "[[\"ID2\", \"BO4534452\", \"AUD\", \"CURRENT\", \"987124\"], [\"ID3\", \"BOS756613\", \"AUD\", \"CURRENT\", \"556740\"], [\"ID4\", \"BOS56824\", \"INR\", \"CURRENT\", \"756568\"]]";
        String result = csvcomparer.compare_csv_file(list1, list2).toString();

        Assert.assertEquals(expect, result);
    }

    //3.3 One file has more/less (the difference is larger than one) entries than another one and none of them has zero entry.
    @Test
    public void testCompcsv5() {
        csvComparer csvcomparer = new csvComparer();
        List<List<String>> list1 = csvcomparer.read_csv_file("/Users/lmr/Desktop/Week9 csvfiles/class3/class3_middle1.csv");
        List<List<String>> list2 = csvcomparer.read_csv_file("/Users/lmr/Desktop/Week9 csvfiles/class3/class3_middle2.csv");

        String expect = "[[\"ID1\", \"BOS963241\", \"USD\", \"SAVINGS\", \"963432\"], [\"ID2\", \"BOS85962\", \"AUD\", \"CURRENT\", \"987124\"], [\"ID3\", \"BOS756613\", \"INR\", \"CURRENT\", \"556740\"], [\"ID4\", \"BOS56824\", \"USD\", \"SAVINGS\", \"777878\"], [\"ID1\", \"BOS963241\", \"USD\", \"SAVINGS\", \"123234\"], [\"ID2\", \"BO4534452\", \"USD\", \"CURRENT\", \"987124\"], [\"ID3\", \"BOS331613\", \"AUD\", \"SAVINGS\", \"556740\"], [\"ID4\", \"BOS56824\", \"INR\", \"CURRENT\", \"711458\"], [\"ID5\", \"BOS963241\", \"USD\", \"SAVINGS\", \"963432\"], [\"ID6\", \"BO4534452\", \"AUD\", \"CURRENT\", \"987124\"], [\"ID7\", \"BOS756613\", \"AUD\", \"CURRENT\", \"556740\"]]";
        String result = csvcomparer.compare_csv_file(list1, list2).toString();

        Assert.assertEquals(expect, result);
    }

    //4. The Customer ID of the csv files does not have the same range
    //4.1 One of the csv file has only one Customer ID which is larger/smaller than another one's largest/smallest Customer ID and the rest Customer ID of the same range
    @Test
    public void testCompcsv6() {
        csvComparer csvcomparer = new csvComparer();
        List<List<String>> list1 = csvcomparer.read_csv_file("/Users/lmr/Desktop/Week9 csvfiles/class4/class4_boundary1.csv");
        List<List<String>> list2 = csvcomparer.read_csv_file("/Users/lmr/Desktop/Week9 csvfiles/class4/class4_boundary2.csv");

        String expect = "[[\"ID4\", \"BOS76844\", \"AUD\", \"SAVINGS\", \"672878\"], [\"ID5\", \"BOS76844\", \"AUD\", \"SAVINGS\", \"672878\"]]";
        String result = csvcomparer.compare_csv_file(list1, list2).toString();

        Assert.assertEquals(expect, result);
    }

    //4.2 One of the file has a different range of Customer ID compared to another. (more than one Customer ID)
    @Test
    public void testCompcsv7() {
        csvComparer csvcomparer = new csvComparer();
        List<List<String>> list1 = csvcomparer.read_csv_file("/Users/lmr/Desktop/Week9 csvfiles/class4/class4_middle1.csv");
        List<List<String>> list2 = csvcomparer.read_csv_file("/Users/lmr/Desktop/Week9 csvfiles/class4/class4_middle2.csv");

        String expect = "[[\"ID34\", \"BOS963241\", \"USD\", \"SAVINGS\", \"963432\"], [\"ID35\", \"BOS85962\", \"AUD\", \"CURRENT\", \"987124\"], [\"ID36\", \"BOS756613\", \"INR\", \"CURRENT\", \"556740\"], [\"ID37\", \"BOS56824\", \"USD\", \"SAVINGS\", \"777878\"], [\"ID66\", \"BOS433241\", \"USD\", \"SAVINGS\", \"873432\"], [\"ID67\", \"BOS86542\", \"AUD\", \"CURRENT\", \"534124\"], [\"ID68\", \"BOS123413\", \"INR\", \"SAVINGS\", \"519240\"], [\"ID69\", \"BOS56544\", \"AUD\", \"SAVINGS\", \"668878\"]]";
        String result = csvcomparer.compare_csv_file(list1, list2).toString();

        Assert.assertEquals(expect, result);
    }

    //5. At least one of the csv file has null value
    //5.1  Only one of the file has exactly one null value and another file does not have any null values.
    @Test
    public void testCompcsv8() {
        csvComparer csvcomparer = new csvComparer();
        List<List<String>> list1 = csvcomparer.read_csv_file("/Users/lmr/Desktop/Week9 csvfiles/class5/class5_boundary1.csv");
        List<List<String>> list2 = csvcomparer.read_csv_file("/Users/lmr/Desktop/Week9 csvfiles/class5/class5_boundary2.csv");

        String expect = "[[\"ID1\", \"BOS963241\", \"USD\", \"SAVINGS\", \"963432\"], [\"ID2\", \"BOS85962\", \"AUD\", \"\", \"987124\"], [\"ID3\", \"BOS756613\", \"INR\", \"CURRENT\", \"556740\"], [\"ID4\", \"BOS56824\", \"USD\", \"SAVINGS\", \"777878\"], [\"ID1\", \"BOS433241\", \"USD\", \"SAVINGS\", \"873432\"], [\"ID2\", \"BOS86542\", \"AUD\", \"CURRENT\", \"534124\"], [\"ID3\", \"BOS123413\", \"INR\", \"SAVINGS\", \"519240\"], [\"ID4\", \"BOS56544\", \"AUD\", \"SAVINGS\", \"668878\"]]";
        String result = csvcomparer.compare_csv_file(list1, list2).toString();

        Assert.assertEquals(expect, result);
    }

    //5.2  Only one of the file has exactly one null value and another file does not have any null values.
    @Test
    public void testCompcsv9() {
        csvComparer csvcomparer = new csvComparer();
        List<List<String>> list1 = csvcomparer.read_csv_file("/Users/lmr/Desktop/Week9 csvfiles/class5/class5_middle1.csv");
        List<List<String>> list2 = csvcomparer.read_csv_file("/Users/lmr/Desktop/Week9 csvfiles/class5/class5_middle2.csv");

        String expect = "[[\"ID1\", \"\", \"USD\", \"SAVINGS\", \"963432\"], [\"ID2\", \"BOS85962\", \"AUD\", \"\", \"987124\"], [\"ID3\", \"BOS756613\", \"INR\", \"CURRENT\", \"556740\"], [\"ID4\", \"\", \"USD\", \"SAVINGS\", \"777878\"], [\"ID1\", \"BOS433241\", \"USD\", \"SAVINGS\", \"\"], [\"ID2\", \"BOS86542\", \"AUD\", \"\", \"534124\"], [\"ID3\", \"BOS123413\", \"INR\", \"SAVINGS\", \"519240\"], [\"ID4\", \"BOS56544\", \"\", \"SAVINGS\", \"668878\"]]";
        String result = csvcomparer.compare_csv_file(list1, list2).toString();

        Assert.assertEquals(expect, result);
    }

    //6. Exist at least one entry which the type of the data in a certain filed are not matched with the corresponding already defined data type.
    //6.1 Only one of the file has exactly one entry which contains the data that has the mismatched data type and another file does not have any this kind of entries.
    @Test
    public void testCompcsv10() {
        csvComparer csvcomparer = new csvComparer();
        List<List<String>> list1 = csvcomparer.read_csv_file("/Users/lmr/Desktop/Week9 csvfiles/class6/class6_boundary1.csv");
        List<List<String>> list2 = csvcomparer.read_csv_file("/Users/lmr/Desktop/Week9 csvfiles/class6/class6_boundary2.csv");

        String expect = "[[\"ID1\", \"BOS963241\", \"USD\", \"SAVINGS\", \"963432\"], [\"ID2\", \"BOS85962\", \"AUD\", \"CURRENT\", \"SRD124\"], [\"ID3\", \"BOS756613\", \"INR\", \"CURRENT\", \"556740\"], [\"ID4\", \"BOS56824\", \"USD\", \"SAVINGS\", \"777878\"], [\"ID1\", \"BOS433241\", \"USD\", \"SAVINGS\", \"873432\"], [\"ID2\", \"BOS86542\", \"AUD\", \"CURRENT\", \"534124\"], [\"ID3\", \"BOS123413\", \"INR\", \"SAVINGS\", \"519240\"], [\"ID4\", \"BOS56544\", \"AUD\", \"SAVINGS\", \"668878\"]]";
        String result = csvcomparer.compare_csv_file(list1, list2).toString();

        Assert.assertEquals(expect, result);
    }

    @Test
    public void testCompcsv11() {
        csvComparer csvcomparer = new csvComparer();
        List<List<String>> list1 = csvcomparer.read_csv_file("/Users/lmr/Desktop/Week9 csvfiles/class6/class6_middle1.csv");
        List<List<String>> list2 = csvcomparer.read_csv_file("/Users/lmr/Desktop/Week9 csvfiles/class6/class6_middle2.csv");

        String expect = "[[\"ID2\", \"YUH86542\", \"AUD\", \"CURRENT\", \"UIJ124\"], [\"ID4\", \"UIY56544\", \"AUD\", \"SAVINGS\", \"668878\"], [\"ID2\", \"78886542\", \"AUD\", \"CURRENT\", \"534124\"], [\"ID4\", \"12356544\", \"AUD\", \"SAVINGS\", \"668878\"]]";
        String result = csvcomparer.compare_csv_file(list1, list2).toString();

        Assert.assertEquals(expect, result);
    }

}
