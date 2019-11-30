package Vue;

import Controller.PerpectiveController;
import Model.ImageModel;
import Model.ImgPerspective;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class PanneauImage extends JPanel {

    private ImageModel imageModel;
    private PerpectiveController perpectiveController;
    public PanneauImage( ImageModel imageModel) {
        super();
        this.imageModel=imageModel;
        this.perpectiveController = new PerpectiveController(this.imageModel);
        setFocusable(true);
        operation();
    }

    public void operation()
    {
        addMouseWheelListener(this.perpectiveController);
        addMouseListener(this.perpectiveController);
        addMouseMotionListener(this.perpectiveController);
        addKeyListener(this.perpectiveController);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        BufferedImage image = imageModel.getImg();

        ImgPerspective perspective = imageModel.getMyPerspective();

        int width = (int)(image.getWidth() * perspective.getNum_zoom());
        int height = (int)(image.getHeight() * perspective.getNum_zoom());

        int x = perspective.getTranslate_image().x;
        int y = perspective.getTranslate_image().y;

        g.drawImage(image,x,y,width,height,null);
    }
}
