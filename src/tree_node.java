//Alayne Anderson
//3-11-21
//CS202 Winter 2021

//for write function
import java.io.PrintStream;

public class tree_node {

    //red black tree data members left, right, and parent
    private tree_node left;
    private tree_node right;
    private tree_node parent;

    //head node of type list_node for linked list functions
    private list_node head;
    //enum name Color object for red black tree colors
    private Color color;

    //tree_node class constructor for initializing the parent, left and right references for the tree
    public tree_node() {
        left = null;
        right = null;
        parent = null;
        //color object is red
        color = Color.Red;
    }

    //copy constructor for the members of the tree when we make another
    public tree_node(list_node to_copy) {
        head = to_copy;
        left = null;
        right = null;
        parent = null;
        color = Color.Red;
    }

    //set the color to red
    public void set_color(Color color) {
        this.color = color;
    }

    //return the color
    public Color get_color() {
        return color;
    }

    //copy constructor for the tree_node data members, setting the left, right and parent to null
    public tree_node(tree_node a_node) {

        left = null;
        right = null;
        parent = null;
    }

    //return the left reference
    public tree_node go_left() {
        return left;
    }

    //return the right reference
    public tree_node go_right() {
        return right;
    }

    //return the parent rference
    public tree_node go_parent() {
        return parent;
    }

    //connect the right reference to a node
    public void connect_right(tree_node connection) {
        right = connection;
    }

    //connect the left reference to a node
    public void connect_left(tree_node connection) {
        left = connection;
    }

    //connect the parent refernce to a node
    public void connect_parent(tree_node connection) {
        parent = connection;
    }

    //display the linked list public function that calls the recursive function
    public void display() {

        if (head != null)
            display(head);
        else
            System.out.println("Nothing to display yet.");

        System.out.println("----------------------------------------------");
    }

    //private recursive display function that recursively displays the head
    private void display(list_node head) {

        if (head != null) {
            //display the info in head
            head.display();
            //then recurse
            display(head.go_next());
        }
    }

    //add a head to the linear linked list
    public void add_tutor(list_node to_add) {

        if (head != null) {
            //if there is nothing then call the recursive function below which handles this case
            add_tutor(head, to_add);
        } else
            //if there is something then it is to be added
            head = to_add;
    }

    //private recursive add function
    private void add_tutor(list_node head, list_node to_add) {

        //if there is noting in head then:
        if (head != null) {
            //if what is to be added is not a match, then recurse
            if (head.compare_name(to_add) > 0) {
                add_tutor(head.go_next(), to_add);
            } else {
                //else it is a match then what is to be added is head
                to_add.connect_next(head.go_next());
                head.connect_next(to_add);
            }
        } else
            //if there is nothing in the list then the first thing in the list will be to_add
            head = to_add;
    }

    //Remove function created but not used because it isnt a requirement
    /*
    public boolean remove_tutor(list_node to_add) {

        if (head == null) {
            System.out.println("There are no subjects yet.");
            return false;
        } else {
            //if the subject we are trying to delete is after the compare_subjects subject
            if (head.compare_subjects(to_add) > 0) {
                //set the head to null to invoke garbage collection
                head = null;
                head = head.go_next();

            } else if (head.compare_subjects(to_add) == 0) {
                head = null;
                head = head.go_next();

            } else {
                System.out.println("No topics for this subject exist.");
                return false;
            }

        }
        return true;
    }

*/
    //retrieve function for the list
    public list_node retrieve(String subject) {
        //if there is nothing in head then there is nothing to retrieve
        if (head == null) {
            return null;
        } else
            //else call the recursive find function
            return retrieve(head, subject);
    }

    //private recursive find function
    private list_node retrieve(list_node head, String to_retrieve) {

        //if there is something to be found, then call the compare_tutornames from list_node that helps find a match
        if (head != null) {
            //if we have found a match
            if (head.compare_name(to_retrieve) == 0) {
                return head;
            } else
                //if we have not found a match then recurse
                return retrieve(head.go_next(), to_retrieve);
        } else {
            //if head is empty then return null
            return null;
        }
    }

    //wrapper function for tree_manager classes add tree function
    public int compare_subjects(list_node to_compare) {
        return head.compare_subjects(to_compare.subject);
    }

    //for adding in tree manager, compare subjects
    public int compare_subjects(tree_node to_compare) {
        return head.compare_subjects(to_compare.head);
    }


    //compare two activities with type tree_node
    public int compare_name(tree_node to_compare) {
        return head.compare_name(to_compare.head);
    }

    //compare two activities with type string
    public int compare_name(String to_compare) {
        return head.compare_name(to_compare);
    }


    //public non recursive write function that calls the recursive write function
    public void write(PrintStream to_write) {
        if (head != null) {
            //base case is if head is not empty, then we must have something to write to a file
            write(head, to_write);
        }
    }

    //write out data to a text file using the head of the list
    private void write(list_node head, PrintStream to_write) {
        //if head is not empty then we must have something to write to a file:
        if (head != null) {
            //if the data we are adding to the file is an instance of the Math derived class:
            if (head instanceof Drawing) {
                //then we have an identifier in the textfile that shows the data belongs to a math class
                to_write.println("M");
                //if the data we are adding to the file is an instance of the Chemistry derived class:
            } else if (head instanceof Paint) {
                //then we have an identifier in the textfile that shows the data belongs to a chemistry class
                to_write.println("C");
                //if the data we are adding to the file is an instance of the CompSci derived class:
            } else if (head instanceof Pottery) {
                //then we have an identifier in the textfile that shows the data belongs to the CS class
                to_write.println("CS");
            }else if(head instanceof Cardio){
                to_write.println("Ca");
            }else if(head instanceof Weights){
                to_write.println("W");
            }

            //write whatever is in head to the file
            head.write(to_write);
            //then recurse to do this again
            write(head.go_next(), to_write);
        }
    }


}








