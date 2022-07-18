# Week9



## Equivalence Class Partitioning:



### 1.At least one of the input files are invalid:

check whether the system can handle and throw the error if the input files are invalid

##### Boundary value:

There is exact one input file is invalid and another one is valid csv file

##### Middle value:

Both two input files are invalid (eg: invalid file name)



### 2.At least one of the input csv files has no entry:

check if one of them is an empty csv file (has no entry) the program will output the csv file which is exactly same as the non empty one and if both of them are empty, the output will also be an empty csv file.

##### Boundary value:

Only one of the csv file is empty

##### Middle value:

Both of the two input files are empty



### 3.Two input csv files have different number of entries:

check if the two files have not equal length, there might exist some indexing error in the code which can result in the crash of the whole program

##### Boundary value:

1.The number of entries of one file is only one entry less/more than another file.

2.One file has one entries and another one has more than one entries 

##### Middle value:

One file has more/less (the difference is larger than one) entries than another one and none of them has zero entry.

### 4. The Customer ID of the csv files does not have the same range

Check that in these two cdv files, the range of Customer ID are same

##### Boundary value:

One of the csv file has only one Customer ID which is larger/smaller than another one's largest/smallest Customer ID and the rest  Customer ID of the same range

##### Middle value:

One of the file has a different range of Customer ID compared to another. (more than one Customer ID)



### 5. At least one of the csv file has null value

If there exist some entries have null value, the program might throw an error when it trying to compare some entries with null values.

##### Boundary value:

Only one of the file has exactly one null value and another file does not have any null values. 

##### Middle value:

Both of the two files have some null values (more than one).



### 6.Exist at least one entry which the type of the data in a certain filed are not matched with the corresponding already defined data type.

If there exist some data of the wrong data types in certain entries, the program might produce an error when it trying to compare this type of entries. (The data type of  `Customer ID.` `Account No.`, `Currency`, `Type` is String and `Balance` is Integer.)

##### Boundary value:

Only one of the file has exactly one entry which contains the data that has the mismatched data type and another file does not have any this kind of entries.

##### Middle value:

Both of the files have some entries which contains the data of the mismatched data type (more than one).
