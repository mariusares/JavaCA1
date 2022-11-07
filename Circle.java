import java.awt.*;
//public class Circle that extends the main class Shape, adding the radius variable to the Circle Shape
public class Circle extends Shape {
    private int radius;

//Circle class constructor
    public Circle(Color color, boolean filled, int xCenter, int yCenter, int radius) {
        super( color, filled, xCenter, yCenter );
        this.radius = radius;
           }
//here is where the Circle Shape is draw, including the Shape Name and BoundingBox display
    @Override
    public void drawShape(Graphics g,  boolean displayShapeName, boolean displayBoundingBox) {

        g.setColor( getColor() );
        if (getFilled()) {
            //filling the circle
            g.fillOval(getxCenter()-radius, getyCenter()-radius,radius*2,radius*2 );

        } else {
            //drawing the circle boundaries mark
            g.drawOval(getxCenter()-radius, getyCenter()-radius,radius*2,radius*2 );


        }
          //checking the shapeName boolean n order to display the Shape Name
        if (displayShapeName)
            drawName( g );
//checking the BoundingBox boolean in order to display the boundingbox
        if (displayBoundingBox)
            drawBoundingBox( g );
    }

    //seting up the bounding box
    @Override
    public BoundingBox setupBoundingBox() {

        return  new  BoundingBox(new Point(getxCenter()-radius,getyCenter()+radius), new Point(getxCenter()+radius, getyCenter()-radius));
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
//the output string message
   @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", xCenter=" + xCenter +
                ", yCenter=" + yCenter +
                '}' ;
    }

}
