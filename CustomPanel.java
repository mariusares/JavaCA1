import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

import static java.awt.event.MouseEvent.BUTTON3;
//Pulic Class CustomPaanel what extends the JPanel class
//basically here is where the magic happens . The logic behind is that "where do we click? on shape? but the shape is on the panel"
public class CustomPanel extends JPanel  {

    private ShapesManager shapesManager;
    public CustomPanel(ShapesManager shapeManager) {
        this.shapesManager = shapeManager;
        addMouseListener();
    }
//drawing all the shapes on the panel, basically would load all the shapes on display
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent( g );
        shapesManager.drawShapes( g );
    }

//adding the mouse listener
    private void addMouseListener(){

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked( e );
                for (Shape currShape : shapesManager.getShapes()) {
                    BoundingBox boundingBox = currShape.setupBoundingBox();
//checking if the click is on the boundingBox boundaries. And if is, what type of click is it
                    if ((e.getPoint().x >= boundingBox.getBottomLeft().getX() && e.getPoint().x <= boundingBox.getTopRight().getX())
                            && (e.getPoint().y <= boundingBox.getBottomLeft().getY()) && e.getPoint().y >= boundingBox.getTopRight().getY()) {
                        if(e.getButton()==MouseEvent.BUTTON1) {
                            currShape.toggleFilling();
                            System.out.println( "You clicked the shape " + currShape );
                        }
//if the Mouse Button 3 (right click) is used and if the Shape is a subject of Rotatable interface, would rotate the shape
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            if (currShape instanceof Rotatable) {
                                Rotatable rota = (Rotatable) currShape;
                                rota.rotate90();
                                System.out.println( "You rotate the shape " + currShape );
                            }
///if the Mouse Button 3 (right click) is used and if the Shape is a subject of Moveable interface, would move the shape on right click
                            if (currShape instanceof Moveable) {
                                Moveable move = (Moveable) currShape;
                                move.moveTenUnits();
                                System.out.println( "You move the shape " + currShape );
                            }

                        }
                    }
                    CustomPanel.super.repaint(); //CustomPanel would be repainted as per clicks output
                }
            }
        });
    }
}

