# Term5-TestMC
### Prepare two files that you are going to compare
I put two csv files in a folder called Data, user can download these two csv files from the Data folder

### Set the path of two files
Set your own path of the downloaded two files you are going to compare and pass it into the method read_cvs_file as a parameter in the main method
```
List<Map<String, String>> list1 = read_csv_file("/Users/lmr/Desktop/Data/sample_file_1.csv");
List<Map<String, String>> list2 = read_csv_file("/Users/lmr/Desktop/Data/sample_file_3.csv");
```

### Set the path and name of the output csv file in generate_csv_file method and Run MyClass.java
```
String fileName = "compare_output.csv";
String filePath = "/Users/lmr/Desktop/Output/";
```
after running MyClass.java we are able to get the output csv file stored in the the place you setted(for me it is stored in the Output folder)
