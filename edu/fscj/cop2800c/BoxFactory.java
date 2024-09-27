// BoxFactory.java
// D. Singletary 
// 10/2/22
// Class which represents a factory containing boxes of various colors

package edu.fscj.cop2800c;

public class BoxFactory {

    public static final int NUMBER_OF_BOXES = 3;
    
    // array (instance variable) of boxes
    private Box[] boxes;
    
    // default constructor
    public BoxFactory() { }
    
    // overloaded constructor
    public BoxFactory(Box[] boxes) {
        this.boxes = boxes;
    }
        
    // toString
    @Override
    public String toString() {
        Integer boxNum = 0;
            
        String retString = "Box Factory contents:\n"; // start here
        retString += "There are " + this.boxes.length + " boxes in the factory.\n";

        // append the boxes
        retString += "First Box is a " + this.boxes[boxNum++] + " box.\n";
        retString += "Second Box is a " + this.boxes[boxNum++] + " box.\n";
        retString += "And the final box is a " + 
                        this.boxes[boxNum] + " box.";
        return retString;
    } 
    
    public static void main(String[] args) {

        // create a local array of boxes
        Box[] boxArray = new Box[NUMBER_OF_BOXES];

        // local counter to keep track of number of boxes
        Integer boxNum = 0;
        
        // add boxes to the array
        boxArray[boxNum++] = new Box(Color.RED);
        boxArray[boxNum++] = new Box(Color.GREEN);
        boxArray[boxNum] = new Box(Color.BLUE);
        
        // use the overloaded constructor to create our Box factory
        BoxFactory boxFact = new BoxFactory(boxArray);

        // print the state of the factory
        System.out.println(boxFact);
        
        // make some changes to test the mutator
        System.out.println("Testing mutators and accessors");
        boxNum = 0; // reset counter         
        boxFact.boxes[boxNum++].setBoxColor(Color.BLUE); 
        boxFact.boxes[boxNum++].setBoxColor(Color.RED);   
        boxFact.boxes[boxNum].setBoxColor(Color.GREEN); 
        
        // test the accessor
        boxNum = 0; // reset counter 
        System.out.println("first box: " + boxFact.boxes[boxNum++].getBoxColor());
        System.out.println("second box: " + boxFact.boxes[boxNum++].getBoxColor());
        System.out.println("third box: " + boxFact.boxes[boxNum].getBoxColor());

        // create a new Box object and test for equality with first box in factory
        Box compareBox = new Box();
        compareBox.setBoxColor(Color.BLUE);

        // verify first box in factory is blue
        System.out.println("first box color: " + boxFact.boxes[0].getBoxColor());

        // compare with == (comparing memory addresses, should be false)
        System.out.println("compare boxes with ==, result is " + 
                (compareBox == boxFact.boxes[0]));

        // compare with equals method (comparing colors, should be true)
        System.out.println("compare boxes with equals method, result is " + 
                compareBox.equals(boxFact.boxes[0]));     
    }
}