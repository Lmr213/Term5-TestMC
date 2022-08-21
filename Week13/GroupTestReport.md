## Yang Haocheng’s code:
Bug1 :  For two adjacent rows(ed:4th  and 5th row) of the totally identical file1 and file2, if we flip the order of these two rows of the one of the file (switch these two rows)and another one doesn’t change and treat them as the two input csv files of the CSVcomparator. The expected output should be an empty csv file, but the actual output is the file which contains two 4th row records and the Assert.asserEquals(expect, result) function will throw an error in test case4 “compare two files with flipped row” 

Bug2: When the two input CSV file has different number of rows and has different repetitive rows, the CSVcomparator will throw ArrayIndexOutOfBoundsException. The bug is found by "Both files have several (>=1) repeat customer IDs" test case 8.

## Wang Shiyu’s code:
Bug: Based on my test cases, there is no bug found in her code.

## Kevin Richan’s code:
Bug: Based on my test cases, there is no bug found in his code.




**Note: The test case files i used are also from week9csv folder. And I modified some function’s name of my teammates code when I am testing their code for easier testing(unify some functions name) eg: read_csv_file_xxx() where xxx is the name of my teammate**
