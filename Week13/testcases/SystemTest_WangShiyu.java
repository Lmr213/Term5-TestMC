package com.example.grouptest;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SystemTest_WangShiyu {

    // 1.Two input csv files have different number of entries
    @Test
    public void SystemTest1() {
        csvComparer csvcomparer = new csvComparer();
        List<List<String>> list1 = csvcomparer.read_csv_file_kevin("/Users/lmr/Desktop/Week9 csvfiles/class3/class3_middle1.csv");
        List<List<String>> list2 = csvcomparer.read_csv_file_kevin("/Users/lmr/Desktop/Week9 csvfiles/class3/class3_middle2.csv");
        List<List<String>> exceptions = csvcomparer.compare_csv_file_kevin(list1, list2);

        csvcomparer.generate_csv_file_kevin(exceptions);

        String expect = "[[\"ID2\", \"BOS85962\", \"AUD\", \"CURRENT\", \"987124\"], [\"ID3\", \"BOS756613\", \"INR\", \"CURRENT\", \"556740\"], [\"ID4\", \"BOS56824\", \"USD\", \"SAVINGS\", \"777878\"], [\"ID1\", \"BOS963241\", \"USD\", \"SAVINGS\", \"123234\"], [\"ID2\", \"BO4534452\", \"USD\", \"CURRENT\", \"987124\"], [\"ID3\", \"BOS331613\", \"AUD\", \"SAVINGS\", \"556740\"], [\"ID4\", \"BOS56824\", \"INR\", \"CURRENT\", \"711458\"], [\"ID5\", \"BOS963241\", \"USD\", \"SAVINGS\", \"963432\"], [\"ID6\", \"BO4534452\", \"AUD\", \"CURRENT\", \"987124\"], [\"ID7\", \"BOS756613\", \"AUD\", \"CURRENT\", \"556740\"]]";
        String result = csvcomparer.read_csv_file_kevin("/Users/lmr/Desktop/Output/compare_output.csv").toString();

        Assert.assertEquals(expect, result);
    }

    // 2.The Customer ID of the csv files does not have the same range
    @Test
    public void SystemTest2() {
        csvComparer csvcomparer = new csvComparer();
        List<List<String>> list1 = csvcomparer.read_csv_file_kevin("/Users/lmr/Desktop/Week9 csvfiles/class4/class4_middle1.csv");
        List<List<String>> list2 = csvcomparer.read_csv_file_kevin("/Users/lmr/Desktop/Week9 csvfiles/class4/class4_middle2.csv");
        List<List<String>> exceptions = csvcomparer.compare_csv_file_kevin(list1, list2);

        csvcomparer.generate_csv_file_kevin(exceptions);

        String expect = "[[\"ID35\", \"BOS85962\", \"AUD\", \"CURRENT\", \"987124\"], [\"ID36\", \"BOS756613\", \"INR\", \"CURRENT\", \"556740\"], [\"ID37\", \"BOS56824\", \"USD\", \"SAVINGS\", \"777878\"], [\"ID66\", \"BOS433241\", \"USD\", \"SAVINGS\", \"873432\"], [\"ID67\", \"BOS86542\", \"AUD\", \"CURRENT\", \"534124\"], [\"ID68\", \"BOS123413\", \"INR\", \"SAVINGS\", \"519240\"], [\"ID69\", \"BOS56544\", \"AUD\", \"SAVINGS\", \"668878\"]]";
        String result = csvcomparer.read_csv_file_kevin("/Users/lmr/Desktop/Output/compare_output.csv").toString();

        Assert.assertEquals(expect, result);
    }

    //3. At least one of the csv file has null value
    @Test
    public void SystemTest3() {
        csvComparer csvcomparer = new csvComparer();
        List<List<String>> list1 = csvcomparer.read_csv_file_kevin("/Users/lmr/Desktop/Week9 csvfiles/class5/class5_middle1.csv");
        List<List<String>> list2 = csvcomparer.read_csv_file_kevin("/Users/lmr/Desktop/Week9 csvfiles/class5/class5_middle2.csv");
        List<List<String>> exceptions = csvcomparer.compare_csv_file_kevin(list1, list2);

        csvcomparer.generate_csv_file_kevin(exceptions);

        String expect = "[[\"ID2\", \"BOS85962\", \"AUD\", \"\", \"987124\"], [\"ID3\", \"BOS756613\", \"INR\", \"CURRENT\", \"556740\"], [\"ID4\", \"\", \"USD\", \"SAVINGS\", \"777878\"], [\"ID1\", \"BOS433241\", \"USD\", \"SAVINGS\", \"\"], [\"ID2\", \"BOS86542\", \"AUD\", \"\", \"534124\"], [\"ID3\", \"BOS123413\", \"INR\", \"SAVINGS\", \"519240\"], [\"ID4\", \"BOS56544\", \"\", \"SAVINGS\", \"668878\"]]";
        String result = csvcomparer.read_csv_file_kevin("/Users/lmr/Desktop/Output/compare_output.csv").toString();

        Assert.assertEquals(expect, result);
    }

    //4. Exist at least one entry which the type of the data in a certain filed are not matched with the corresponding already defined data type.
    @Test
    public void SystemTest4() {
        csvComparer csvcomparer = new csvComparer();
        List<List<String>> list1 = csvcomparer.read_csv_file_kevin("/Users/lmr/Desktop/Week9 csvfiles/class6/class6_middle1.csv");
        List<List<String>> list2 = csvcomparer.read_csv_file_kevin("/Users/lmr/Desktop/Week9 csvfiles/class6/class6_middle2.csv");
        List<List<String>> exceptions = csvcomparer.compare_csv_file_kevin(list1, list2);

        csvcomparer.generate_csv_file_kevin(exceptions);

        String expect = "[[\"ID4\", \"UIY56544\", \"AUD\", \"SAVINGS\", \"668878\"], [\"ID2\", \"78886542\", \"AUD\", \"CURRENT\", \"534124\"], [\"ID4\", \"12356544\", \"AUD\", \"SAVINGS\", \"668878\"]]";
        String result = csvcomparer.read_csv_file_kevin("/Users/lmr/Desktop/Output/compare_output.csv").toString();

        Assert.assertEquals(expect, result);
    }


}
