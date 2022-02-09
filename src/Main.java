//Alayne Anderson
//3-11-21
//CS202 Winter 2021

import java.io.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    //throws exception for file io
    public static void main(String[] args) throws IOException {

        //for file io:
        BufferedReader in;
        in = new BufferedReader(new FileReader("src/in.txt"));

        //for user input:
        Scanner input = new Scanner(System.in);
        //Make an object of the tree_manager class to run its tree functions:
        tree_manager a_manager = new tree_manager();
        a_manager.read(in);
        //temp for edit case below
        String temp;
        //option int for menu selection
        int option = 0;

        //general menu
        while (option != 4) {
            System.out.println();

            System.out.println("Welcome to the Activity information service!");
            System.out.println("Select an option from below:");

            System.out.println("1) Display all current Activities");
            System.out.println("2) Add an Activity");
            System.out.println("3) Edit an Activity");
            System.out.println("4) Quit");
            System.out.println();

            //check for user input error
            try {
                option = input.nextInt();
            } catch (InputMismatchException e) {
                option = 10;
            }

            //switch statement for cases
            switch (option) {
                case 1:
                    //in this case we will display the tree
                    a_manager.display();
                    break;
                case 2:
                    //call outside function to add an activity
                    add_activity(a_manager);
                    break;
                case 3: {

                    //in this case we will change the data members data in the linked list:

                    //make a list_node object so we can alter linked list
                    list_node to_edit;
                    System.out.println("Enter the Activity name to edit: ");
                    input.nextLine();
                    //temp is for this user input to compare using the retrieve function
                    temp = input.nextLine();

                    //setting to_edit to whatever that match is
                    to_edit = a_manager.retrieve(temp);
                    //checking is the to_edit is null (has no match)
                    if (to_edit != null) {
                        //base classes change functions
                        to_edit.change_activity_info();
                        //dynamically bound change functions for derived classes
                        to_edit.change_description();
                        to_edit.change_materials();
                    } else
                        //in this case, there was no match
                        System.out.println("No activity matches..");
                }
                break;
                case 4:
                    //in this case we quit
                    System.out.println("Quitting..");
                    PrintStream out;
                    out = new PrintStream(new FileOutputStream("src/in.txt"));
                    a_manager.write(out);
                    out.flush();
                    out.close();
                    break;
                default:
                    System.out.println("Enter a valid option 1-4");
            }
        }
    }

    //add function for if user selects to add an activity above:
    static void add_activity(tree_manager a_manager) {

        //for user input
        Scanner input = new Scanner(System.in);
        //base class reference for dynamic binding
        list_node new_activity = null;
        //option for menu below
        int option = 0;

        //add menu for choosing a derived type to add
        System.out.println("Which activity do you want to do? ");
        System.out.println("1) Drawing");
        System.out.println("2) Paint");
        System.out.println("3) Pottery");
        System.out.println("4) Cardio");
        System.out.println("5) Weights");
        System.out.println("6) Etc");
        System.out.println();


        //check for user input error
        try {
            option = input.nextInt();
        } catch (InputMismatchException e) {
            option = 10;
        }


        //switch statement for cases
        switch(option) {
            case 1:
                //in this case we make a new derived type drawing using base class ref
                new_activity = new Drawing();
                break;
            case 2:
                //in this case we make a new derived type paint using base class ref
                new_activity = new Paint();
                break;
            case 3:
                //in this case we make a new derived type pottery using base class ref
                new_activity = new Pottery();
                break;
            case 4:
                //in this case we make a new derived type of Cardio using base class ref
                new_activity = new Cardio();
                break;
            case 5:
                //in this case we make a new derived type of Weights using base class ref
                new_activity = new Weights();
                break;
            case 6:
                //in this case we make a new derived type of Etc using the base class ref
                new_activity = new Etc();
                break;
            default:
                System.out.println("Select an option 1-3..");
        }

        //these change functions will run automatically for all derved types above:

        //this change function calls the base classes change function for common data members
        new_activity.change_activity_info();
        //this change function calls the dynamically bound description function to change derived class specific data member
        new_activity.change_description();
        //this change function calls the dynamically bound materials function to change derived class specific data member
        new_activity.change_materials();

        //adds a new activity
        a_manager.add(new_activity);

    }

}
