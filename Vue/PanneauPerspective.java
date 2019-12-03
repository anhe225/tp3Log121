package Vue;

import Controller.PerpectiveController;
import Interfaces.Observer;
import Model.Constantes;
import Model.ImageModel;
import Model.ImgPerspective;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanneauPerspective extends JPanel implements Observer {


    private  PerpectiveController perpectiveController;
    private  ImageModel imageModel;
   private int typePerpersective;

    public PanneauPerspective(ImageModel imageModel){
    super();
this.imageModel= imageModel;
    this.perpectiveController = new PerpectiveController(this.imageModel);
        setFocusable(true);
    operation();

}

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if(imageModel.getImg() == null) {
            System.out.println(Constantes.FICHIER_INTROUVABLE);
            return;
        }
            BufferedImage image = imageModel.getImg();

            ImgPerspective perspective = imageModel.getMyPerspective();

            int width = (int)(image.getWidth() * perspective.getNum_zoom());
            int height = (int)(image.getHeight() * perspective.getNum_zoom());

            int x = perspective.getTranslate_image().x;
            int y = perspective.getTranslate_image().y;

            g.drawImage(image,x,y,width,height,null);

    }

    @Override
    public void update() {
        repaint();
    }

    public void operation()
    {
        addMouseWheelListener(this.perpectiveController);
        addMouseListener(this.perpectiveController);
        addMouseMotionListener(this.perpectiveController);
        addKeyListener(this.perpectiveController);
    }
}
