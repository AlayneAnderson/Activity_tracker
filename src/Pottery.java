//Alayne Anderson
//3-11-21
//CS202 Winter 2021

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Pottery extends list_node {

    //data members software and language for the materials and description functions
    protected String supply;
    protected String type;

    //constructor calls the base classes constructor
    public Pottery() {
        super();
    }

    //the copy constructor for this class copies its two string data members
    public Pottery(Pottery a_pottery) {
        supply = a_pottery.supply;
        type = a_pottery.type;
    }

    //display function for this class calls the display function of its indirect base class tutor_topic and also
    //displays its own two data members
    public void display() {

        //call the indirect base classes display function to display base class data members
        super.display();

        //display this classes own two data members software and language
        if (supply != null) {
            System.out.println("Supplies needed is: " + supply);
        } else
            System.out.println("No supplies set yet.");

        if (type != null) {
            System.out.println("Pottery types used: " + type);
        } else
            System.out.println("No types set yet.");

    }

    //change the materials for this class CS which is in the form of a required software
    public int change_materials() {

        Scanner input = new Scanner(System.in);
        System.out.println("What are the supplies needed for this subject?:");
        supply = input.nextLine();

        if (supply != null) {
            System.out.println("Supplies needed: " + supply);
            return 0;
        } else
            //in main remember to handle this case
            return -1;
    }

    //change the description for this class which is in the form of a programming language
    public int change_description() {

        Scanner input = new Scanner(System.in);
        System.out.println("What Type of pottery should this person know to learn this subject? :");
        type = input.nextLine();

        if (type != null) {
            System.out.println("Type set to: " + type);
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
        to_write.println(supply);
        to_write.println(type);
    }

    //read function for this class to read its data members to a textfile
    public void read(BufferedReader to_read) throws IOException, NumberFormatException {

        //need to also read in the data members from the base class for this class
        super.read(to_read);
        //read in this classes 2 data members
        supply = to_read.readLine();
        type = to_read.readLine();

    }

}

