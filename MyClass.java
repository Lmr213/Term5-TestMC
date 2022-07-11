package com.example.week8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyClass {

    public static void main(String[] args) {
        List<Map<String, String>> list1 = read_csv_file("/Users/lmr/Desktop/Data/sample_file_1.csv");
        List<Map<String, String>> list2 = read_csv_file("/Users/lmr/Desktop/Data/sample_file_3.csv");

        List<Map<String, String>> exceptions = compare_csv_file(list1, list2);

        generate_csv_file(exceptions);
    }

    public static List<Map<String, String>> read_csv_file(String csv_path) {
        List<Map<String, String>> list = new ArrayList<>();

        try{
            File csv = new File(csv_path);
            BufferedReader textFile = new BufferedReader(new FileReader(csv));
            String lineDta = "";

            while ((lineDta = textFile.readLine()) != null){

                String[] user = lineDta.split(",");

                Map<String, String> entry = new HashMap<String, String>();
                entry.put("Customer ID#", user[0]);
                entry.put("Account No.", user[1]);
                entry.put("Currency", user[2]);
                entry.put("Type", user[3]);
                entry.put("Balance", user[4]);

                list.add(entry);
            }

        }catch (FileNotFoundException e){
            System.out.println("No such file");
        }catch (IOException e){
            System.out.println("read failed");
        }

        return list;
    }

    public static List<Map<String, String>> compare_csv_file(List<Map<String, String>> list1, List<Map<String, String>> list2) {

        List<Map<String, String>> exceptions = new ArrayList<>();

        for(int i = 0; i < list1.size(); i++){
            if(list1.get(i).equals(list2.get(i))){
                continue;
            }
            else{
                exceptions.add(list2.get(i));
                exceptions.add(list1.get(i));
            }
        }
        return exceptions;
    }

    public static void generate_csv_file(List<Map<String, String>> exceptions) {
        List<List<Object>> dataList = new ArrayList<>();
        List<Object> rowList = null;

        for (int i = 0; i < exceptions.size(); i++) {
            Map<String, String> entryData = exceptions.get(i);

            rowList = new ArrayList<>();
            rowList.add(entryData.get("Customer ID#"));
            rowList.add(entryData.get("Account No."));
            rowList.add(entryData.get("Currency"));
            rowList.add(entryData.get("Type"));
            rowList.add(entryData.get("Balance"));
            dataList.add(rowList);
        }

        String fileName = "compare_output.csv";
        String filePath = "/Users/lmr/Desktop/";

        File csvFile = null;
        BufferedWriter csvWriter = null;
        try {
            csvFile = new File(filePath + fileName);
            File parent = csvFile.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            csvFile.createNewFile();

            csvWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "GB2312"), 1024);

            for (List<Object> entry : dataList) {
                writeEntry(entry, csvWriter);
            }
            csvWriter.flush();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                csvWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void writeEntry(List<Object> entry, BufferedWriter csvWriter) throws IOException {
        for (Object data : entry) {
            StringBuffer stringBuffer = new StringBuffer();
            String entryStr = stringBuffer.append(data).append(",").toString();
            csvWriter.write(entryStr);
        }
        csvWriter.newLine();
    }
}