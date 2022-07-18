# Week9



### Equivalence Class Partitioning:



#### 1.At least one of the input files are invalid:

check whether the system can handle and throw the error if the input files are invalid

##### Boundary value:

There is exact one input file is invalid and another one is valid csv file

##### Middle value:

Both two input files are invalid (eg: invalid file name)



#### 2.At least one of the input csv files has no entry:

check if one of them is an empty csv file (has no entry) the program will output the csv file which is exactly same as the non empty one and if both of them are empty, the output will also be an empty csv file.

##### Boundary value:

Only one of the csv file is empty

##### Middle value:

Both of the two input files are empty



#### 3.Two input csv files have different number of entries:

##### Boundary value:

1.The number of entries of one file is only one entry less/more than another file.

2.One file has one entries and another one has more than one entries 

##### Middle value:

One file has more/less (the difference is larger than one) entries than another one and none of them has zero entry.
