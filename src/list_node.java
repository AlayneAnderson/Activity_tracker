//Alayne Anderson
//3-11-21
//CS202 Winter 2021
//Program 4

public class list_node extends Activities {


    //the next pointer for the list of type list_node
    protected list_node next;

    //initialize next pointer in constructor
    public list_node() {
        super();
        next = null;
    }

    //set next to null in copy constructor
    public list_node(list_node a_node) {

        next = null;

    }

    //return the next pointer for traversal
    public list_node go_next() {

        return next;
    }

    //connect the next reference to a node
    public void connect_next(list_node connection) {

        next = connection;

    }

    //used for the tree_node classes add function to compare two subjects to see where to add to the tree
    public int compare_subjects(list_node to_compare) {

        //if the subjects are the same
        if (to_compare.subject.compareTo(subject) == 0) {
            return 0;
            //if the subject to compare if greater than subject
        } else if (to_compare.subject.compareTo(subject) > 0) {
            return 1;
        } else
            return -1;
    }


    //compare function that instead takes a string for adding, for the wrapper function of the same name in tree_node
    public int compare_subjects(String to_compare) {
        if(to_compare.compareTo(subject) == 0) {
            return 0;
        } else if (to_compare.compareTo(subject) > 0) {
            return 1;
        } else
            return -1;
    }



    //compare two string names of activities
    public int compare_name(String to_compare) {
        //if the names match
        if(to_compare.compareTo(name) == 0) {
            return 0;
            //if the name we are comparing is greater
        } else if (to_compare.compareTo(name) > 0) {
            return 1;
        } else
            //no match
            return -1;
    }

    //compare two names of type list_node
    public int compare_name(list_node to_compare) {
        //if its a match
        if (name.compareTo(to_compare.name) == 0) {
            return 0;
            //if the name we are comparing is greater
        } else if (name.compareTo(to_compare.name) > 0) {
            return 1;
        } else
            //no match
            return -1;
    }




}
