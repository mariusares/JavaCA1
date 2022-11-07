import java.awt.*;
//creating the Rectangle class what is extending the Shape class and is including the Moveable interface
public  class Rectangle extends Shape implements Moveable {
    //the width and height variables are available only for this extended class
    private int width;
    private int height;
    //creating the constructor for the Rectangle class
       public Rectangle(Color color, boolean filled, int xCenter, int yCenter, int width, int height) {
        super( color, filled, xCenter, yCenter );
        this.width = width;
        this.height = height;
            }
     //the Getters and Setters
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    //creating the boundingbox for the Rectangle class
        @Override
    public BoundingBox setupBoundingBox()
    {

        return  new BoundingBox( new Point (getxCenter() - (width/2) ,getyCenter() + (height/2)) , new Point( getxCenter() + (width/2) , getyCenter() - (height/2) )) ;
     }
    @Override
    public void drawShape(Graphics g, boolean displayShapeName, boolean displayBoundingBox ) {
        g.setColor(getColor());

        if(getFilled()){
            g.fillRect(getxCenter()-(width/2), getyCenter()-(height/2),width,height );

        }
        else{

            g.drawRect(getxCenter()-(width/2), getyCenter()-(height/2),width,height);
        }
       //displaying the shapeName as per boolean
        if(displayShapeName)
            drawName(g);
//displaying the boundingbox box as per boolean
        if(displayBoundingBox)
            drawBoundingBox(g);
    }

   //definition for moving the shape with 10 units
   @Override
    public void moveTenUnits() {
        setxCenter(getxCenter()+10);
    }

//the output string message
    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}' ;
    }

}
