package org.example;

/*
Description:
Algorithm that needs to be able to save the last X values received.

Format:
The data input format is the following:
Orden 1
...
Orden N

Instructions:
TODO I1. print - Return/Print the last value saved
TODO I2. ctrlZ - delete the last value and be able to recover the last one
TODO I3. block - Convert the last value in untouchable until unblock instruction
TODO I4. unblock - Convert the last value in touchable

Message error:
TODO E1.Value that is not available
TODO E2.Element is blocked
TODO E3.Save a value without space
*/

public class Main {
    public static void main(String[] args) {
        DataStorer dataManager = new DataStorer("database.txt");
        dataManager.readData();
        //dataManager.printLastValue();
    }
}