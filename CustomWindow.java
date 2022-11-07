import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Console;


public class CustomWindow extends JFrame {

    private ShapesManager shapesManager;
    private CustomPanel mainPanel;
    public CustomWindow(ShapesManager shapesManager)
    {
        this.shapesManager = shapesManager;
        mainPanel = new CustomPanel(shapesManager);

        //add our new panel to the frame

        add(mainPanel, BorderLayout.CENTER);
        //set the dimensions of the frame/window
        setSize(Consts.FRAME_WIDTH, Consts.FRAME_HEIGHT);
    }
}