package Controller;

import Interfaces.Icommand;
import Model.ImageModel;
import Model.ImgPerspective;

import java.awt.*;

public class CommandTranslate extends Command implements Icommand {

    private Point point;

    public CommandTranslate(ImageModel img, Point point) {
        super(img);
        this.point = point;
    }

    @Override
    public void execute() {

        if (this.img.getMyPerspective() == null){
            ImgPerspective [] tab = new ImgPerspective[2];
            tab[0]= new ImgPerspective(img);
            tab[1]= new ImgPerspective(img);
            img.setTabPerpective(tab);
        }else
        {
            this.img.getMyPerspective().translate(point.x,point.y);
            System.out.println( this.img.getMyPerspective().toString());
        }

    }

    @Override
    public void undo() {
        int x = - point.x;
        int y = - point.y;
        this.img.getMyPerspective().translate(x,y);
    }
}
