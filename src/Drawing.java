//Alayne Anderson
//3-11-21
//CS202 Winter 2021

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Drawing extends list_node {

    //data members software and language for the materials and description functions
    protected String style;
    protected String supply;

    //constructor calls the base classes constructor
    public Drawing() {
        super();
    }

    //the copy constructor for this class copies its two string data members
    public Drawing(Drawing a_drawing) {
        style = a_drawing.style;
        supply = a_drawing.supply;
    }

    //display function for this class calls the display function of its indirect base class tutor_topic and also
    //displays its own two data members
    public void display() {

        //call the indirect base classes display function to display base class data members
        super.display();

        //display this classes own two data members software and language
        if (style != null) {
            System.out.println("Style drawn in the artwork: " + style);
        } else
            System.out.println("No style type set yet.");

        if (supply != null) {
            System.out.println("The supplies needed: " + supply);
        } else
            System.out.println("No supplies set yet.");

    }

    //change the materials for this class CS which is in the form of a required software
    public int change_materials() {

        Scanner input = new Scanner(System.in);
        System.out.println("What is the required Style for this subject?:");
        style = input.nextLine();

        if (style != null) {
            System.out.println("Style needed: " + style);
            return 0;
        } else
            //in main remember to handle this case
            return -1;
    }

    //change the description for this class which is in the form of a programming language
    public int change_description() {

        Scanner input = new Scanner(System.in);
        System.out.println("What supplies should this person know to learn this subject? :");
        supply = input.nextLine();

        if (supply != null) {
            System.out.println("Supplies needed: " + supply);
            return 0;
        } else
            //in main remember to handle this case
            return -1;
    }

    //write function for the CS class that writes data to a file
    public void write (PrintStream to_write) {
        //first we need to also write the data for this class that exists in the base class
        super.write(to_write);
        //then we can add to the textfile the two data members unique to this class
        to_write.println(style);
        to_write.println(supply);
    }

    //read function for this class to read its data members to a textfile
    public void read(BufferedReader to_read) throws IOException, NumberFormatException {

        //need to also read in the data members from the base class for this class
        super.read(to_read);
        //read in this classes 2 data members
        style = to_read.readLine();
        supply = to_read.readLine();

    }

}
