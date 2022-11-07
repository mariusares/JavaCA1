import java.awt.*;

//the public class Square is a copy of the Rectangle class with different string output message
//probably was a nice idea to compare the lenght of the shapes sides in order to confirm that the shape is actually a Square, but that is  only a proof of concept
public class Square extends Shape {
        private int width;
    private int height;


    public Square(Color color, boolean filled, int xCenter, int yCenter, int width, int height) {
        super( color, filled, xCenter, yCenter );
        this.width = width;
        this.height = height;


    }
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

        if(displayShapeName)
            drawName(g);

        if(displayBoundingBox)
            drawBoundingBox(g);
    }

    @Override
    public String toString() {
        return "Square{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

}