package org.example;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

import java.util.ArrayList;
import java.util.List;

public class AlgorithmDataManagement {
    // INITIALIZATION
    private List<String> data=new ArrayList<String>();
    private boolean lastValueIsBlocked = false;
    private int clipboardValue = 0;
    private String pathData = "";
    private String pathInit = "C:\\Users\\SNX8073\\OneDrive - Nissan Motor Corporation\\MMP\\Computing Skills" +
            "\\07. JAVA\\AlgorithmToSaveLastXValues-kata\\src\\main\\java\\org\\example";

    // CONSTRUCTORS
    public AlgorithmDataManagement() {
        new AlgorithmDataManagement(this.pathData);
    }
    public AlgorithmDataManagement(String userPathData) {
        this.data = data;
        this.lastValueIsBlocked = lastValueIsBlocked;
        this.clipboardValue = clipboardValue;
        this.pathData = this.pathInit+"\\"+userPathData;
    }
    public void readData(){
        try {
            File myObj = new File(this.pathData);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String value = myReader.nextLine();
                //System.out.println(value);
                this.data.add(value);
            }
            myReader.close();
            System.out.println(this.data);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void printLastValue(){
        String lastValue = this.data.get(this.data.size()-1);
        System.out.println(lastValue);
    }
    public void ctrlZ(){

    }
    public boolean isLastValueBlocked(){
        System.out.println(this.lastValueIsBlocked);
        return this.lastValueIsBlocked;/
    }
    public void blockLastValue(){
        this.lastValueIsBlocked = true;
    }
    public void unblockLastValue(){
        this.lastValueIsBlocked = false;
    }


}
