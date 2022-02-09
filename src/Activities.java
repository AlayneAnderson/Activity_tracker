//Alayne Anderson
//3-11-21
//CS202 Winter 2021

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Activities {

    //string data members for the activity information
    protected String subject;
    protected String name;


    //copy constructor for data members
    public Activities(Activities a_topic) {
        subject = a_topic.subject;
        name = a_topic.name;
    }

    public Activities() {
        subject = null;
        name = null;
    }

    //these functions are defined here but not written, they are dynamically bound
    public int change_materials() {
        return 0;
    }
    public int change_description() {
        return 0;
    }


    //function to edit the data members associated with an activity.
    public void change_activity_info() {

        //string variable for determining if the user wants to change a certain data member or not
        String to_change = new String();
        //too allow for user input
        Scanner input = new Scanner(System.in);

        //Prompt for changing a subject. If the user selects yes then they may change it.
        System.out.println("Do you want to change an Activity? Enter y/n: ");
        to_change = input.nextLine();
        if (to_change.equals("y")) {
            System.out.println("What are you changing it to? :");
            subject = input.nextLine();
            System.out.println("Activity set to: " + subject);
        } else {
            System.out.println("You selected 'n', no activity added.");
            subject = "no activity.";
        }


        //Prompt for if user wants to change the activity name. If yes then they may change it
        System.out.println("Do you want to change an activity name? Enter y/n: ");
        to_change = input.nextLine();
        if (to_change.equals("y")) {
            System.out.println("What is your name? :");
            name = input.nextLine();
            System.out.println("Name set to: " + name);
        } else {
            System.out.println("You selected 'n', no name added.");
            name = "No name.";
        }


    }

    //display the subject, name
    public void display() {

        if (name != null) {
            System.out.println("Activity name is: " + name);
        } else
            System.out.println("No name set yet.");

        if (subject != null) {
            System.out.println("Subject of the session: " + subject);
        } else
            System.out.println("No subject set yet");

    }

    //this function is used in the class tree_manager for adding to the tree
    public int compare_subject(Activities to_compare) {

        if (to_compare.subject.compareTo(subject) == 0) {
            return 0;
        } else if (subject.compareTo(to_compare.subject) > 0) {
            return 1;
        } else  {
            return -1;
        }
    }

    //write function for outputting the data members of this class to a external text file
    public void write(PrintStream to_write) {
        to_write.println(subject);
        to_write.println(name);
    }

    //read function for this class that reads its data members to a file
    public void read(BufferedReader to_read) throws IOException, NumberFormatException {
        //read the strings to the file
        subject = to_read.readLine();
        name = to_read.readLine();

    }
}
