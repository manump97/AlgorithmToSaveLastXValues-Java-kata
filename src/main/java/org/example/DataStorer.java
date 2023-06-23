package org.example;


//NO COMENTARIOS!!!
import java.io.File;  // Import the File class  //En lugar de hacerlo con un archivo de texto si quieres hazlo con un array de strings, por ejemplo
import java.io.FileNotFoundException;  // Import this class to handle errors  //Si quieres controlar la excepcion quizas deberias dar la sensacion de que la controlas, no de que la sueltas ahi en la cara :)
import java.util.Scanner; // Import the Scanner class to read text files // Repito lo de la fila 5

//Pregunta, estas o no estas acoplado a la manera en que te llega la informacion?

import java.util.ArrayList;
import java.util.List;

public class DataStorer {
    // INITIALIZATION
    private List<String> data=new ArrayList<String>();
    private boolean lastValueIsBlocked = false;
    private String clipboardValue = "0";
    private String pathData = "";
    private String pathInit = System.getProperty("user.dir");
    // Ya hemos hablado de que quizas lo del txt no es lo mas adecuado, pero nunca, nunca nunca hardcodees la configuracion
    // DONE - Get user path directamente desde el sitio en el que se ejecuta el main.
    private int dataSize = 0;

    // CONSTRUCTORS
    public DataStorer() {
        new DataStorer(this.pathData);
    }
    public DataStorer(String userPathData) { //No creo que en ningun caso una clase deba llamarse Algorithm. Quizas el objeto seria...
        //DataStorer DataBuffer Clipboard
        // DONE - DataStorer mejor nombre
        this.data = data;
        this.lastValueIsBlocked = lastValueIsBlocked;
        this.clipboardValue = clipboardValue;
        this.pathData = this.pathInit+"\\"+userPathData;
    }
    public void readData(){
        try {
            File myObj = new File(this.pathData);  //el nombre myObj es red flag
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {  //Creo que tu objetivo en el core de tu aplicacion es procesar una orden y devolver resultado
                String value = myReader.nextLine();
                //System.out.println(value);
                this.data.add(value);
            }
            this.dataSize = this.data.size(); // La idea era poder guardar x valores definidos por el usuario ejemplo 3, todos los valores que exceden a 3 hacia atras, serian irrecuperables.
            myReader.close();
            System.out.println(this.data);   //ACOPLAMIENTOS
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred."); //Ya sabes lo que te voy a decir :)
            e.printStackTrace();
        }
    }
    public void printLastValue(){
        String lastValue = this.data.get(this.dataSize-1);
        System.out.println(lastValue);
    }
    public void changeLastValue(String num){  // String num???  // Segun yo lo veo nunca se modifica last value se añade otro a la lista y se elimina el que ya no tiene espacio, por ejemplo
        this.clipboardValue = this.data.get(this.dataSize-1);
        this.data.add(this.dataSize-1,num);
    }
    public void ctrlZ(){
        this.clipboardValue = this.data.get(this.dataSize-1);
        this.data.add(this.dataSize-1,this.clipboardValue);  //Parece que machacas el valor con el anterior //Si hago ctrlZ dos veces que ocurre en un buffer de 4 elementos recuperables por ejemplo, porque a mi me parece que siempre recuperarias en mismo, puedo estar equivocado
    //Como controlas si el array esta vacio?? O como comntrolas si estamos intentando acceder a un valor para el cual ya no hay memoria?
    }
    public boolean isLastValueBlocked(){
        System.out.println(this.lastValueIsBlocked); // Y si te pido que envies un mail?? Tienes que cambiar el core de tu codigo? Que motivo tienes para acoplarte con el printer
        return this.lastValueIsBlocked;  //Dos responsabilidades en la clase, eso es contrario a los principios solid (busca un poco si quieres pero ya te explicare yo, si no)
    }
    public void blockLastValue(){
        this.lastValueIsBlocked = true;
    }
    public void unblockLastValue(){
        this.lastValueIsBlocked = false;
    }


}
