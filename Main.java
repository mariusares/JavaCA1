import javax.swing.*;
import java.awt.*;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        ShapesManager shapesManager = new ShapesManager(); //ShapesManager Inheritance
        shapesManager.setDisplayName(true);    //shapesManager Shapes Display Name Bolean
        shapesManager.setDisplayBoundingBox(true); //ShapesManager Display BoundingBox Bolean

        shapesManager.addShape(new Circle(Color.green, true, 600, 80, 50)); //creating the circle shape

        shapesManager.addShape(new Square( Color.cyan, true, 600,240, 80 , 80 )); //creating the square shape
        shapesManager.addShape(new Rectangle( Color.blue, true, 400,400, 180 , 80 )); //creating the rectangle shape

        //creating the Quadrilateral with the Rectangle constructor
        Rectangle rect2 = new Rectangle(Color.red, true, 170, 170, 100, 120);
        Quadrilateral quad = new Quadrilateral( rect2 );
        //creating the Quadrilateral with the Quadrilateral constructor
        shapesManager.addShape( quad );
        Quadrilateral quad1 = new Quadrilateral( new Point(80,80), new Point( 50 ,50 ),new Point (120, 70), new Point (100,120), new Point(40,90) );
        shapesManager.addShape(quad1);

        CustomWindow customWindow = new CustomWindow(shapesManager); //this is a polymorphosism case where shapeManager is passing trough the CustomWindow Class

        customWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customWindow.setTitle("Marius Window"); //window title
        customWindow.setVisible(true); //windoow visibility


       }

}