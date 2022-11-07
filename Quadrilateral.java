import java.awt.*;
//Public Class Quadrilateral that extends the Class Shape and implements the interface Rotatable
//as per description is inlcuding the array Point[] that includes the shape points
public class Quadrilateral extends Shape implements Rotatable {

    public Point[] points;

//the class constructors as per description
    public Quadrilateral(Point centerPoint, Point[] points) {
        super( Color.red, false,  centerPoint.getX(), centerPoint.getY());
        this.points = points;
          }
    public Quadrilateral(Point centerPoint, Point p1, Point p2, Point p3, Point p4){
        super(Color.BLACK, false, centerPoint.getX(),centerPoint.getY());
        this.points = new Point[]{p1,p2,p3,p4};
         }

    public Quadrilateral(Rectangle rectangle){
        super(Color.red, false, rectangle.getxCenter(),rectangle.getyCenter());
        Point p1 = new Point(rectangle.getxCenter() - (rectangle.getWidth() / 2), rectangle.getyCenter() - (rectangle.getHeight() / 2));
        Point p2 = new Point(rectangle.getxCenter() + (rectangle.getWidth() / 2) , rectangle.getyCenter() - (rectangle.getHeight() / 2));
        Point p3 = new Point(rectangle.getxCenter() + (rectangle.getWidth() / 2), rectangle.getyCenter() + (rectangle.getHeight() / 2));
        Point p4 = new Point(rectangle.getxCenter()- (rectangle.getWidth() / 2), rectangle.getyCenter() + (rectangle.getHeight() / 2));
        this.points = new Point[]{p1,p2,p3,p4};

    }
//the boundingbox that actually gave me a bit of hard time. In order to calculate the box points I had to setup local variables

    @Override
    public BoundingBox setupBoundingBox() {
        //declare and calculate the local variables
        int topY = points[0].getY();
        int bottomY = points[0].getY();
        int leftX = points[0].getX();
        int rightX = points[0].getX();
        for (Point p : points){
            if(p.getY()<topY)
                topY = p.getY();
            if(p.getY()>bottomY)
                bottomY=p.getY();
            if(p.getX()<leftX)
                leftX=p.getX();
            if(p.getX()>rightX)
                rightX=p.getX();
            }
//declaring the boundingbox
        return  new BoundingBox( new Point ( leftX, bottomY) , new Point( rightX, topY )) ;

    }
//drawing the shape accordingly to the description
    @Override
    public void drawShape(Graphics g, boolean displayShapeName, boolean displayBoundingBox) {
        g.setColor(getColor());
//displaying the shape boundaries or  filling the shape
        if(getFilled()){
            g.fillPolygon(new int[]{points[0].getX(),points[1].getX(),points[2].getX(),points[3].getX()},
                    new int[]{points[0].getY(),points[1].getY(),points[2].getY(),points[3].getY()},points.length);
        }
        else{
            g.drawPolygon(new int[]{points[0].getX(),points[1].getX(),points[2].getX(),points[3].getX()},
                    new int[]{points[0].getY(),points[1].getY(),points[2].getY(),points[3].getY()},points.length);
        }
//shape name display as per boolean
        if(displayShapeName)
            drawName(g);
        //shape boudningbox display as per boolean
        if(displayBoundingBox)
            drawBoundingBox(g);
    }
    //rotate the shape definition
    //here is where the rotation magic happens
    //local variables and maths where used as per tutorial : https://www.youtube.com/watch?v=dlUcIGnaAnk

    @Override
    public void rotate90() {
        for(Point point:points){
            double radian = Math.toRadians( Consts.DEGREES_TO_ROTATE );
            double rlx = ((point.getX()-getxCenter()) * Math.cos(radian)) - ((point.getY()-getyCenter())*Math.sin( radian ));
            double rly = ((point.getX()-getxCenter()) * Math.sin(radian)) + ((point.getY()-getyCenter())*Math.cos( radian ));
            point.setX( (int) rlx + getxCenter() );
            point.setY( (int) rly + getyCenter());
        }

    }
//outpput string text message
    @Override
    public String toString() {
        return "Quadrilateral{" +
               "xCenter "  + getxCenter() +
               ", yCenter "  + getyCenter() +
                '}' ;
    }
}