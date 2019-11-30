package Controller;

import Interfaces.Icommand;
import Model.ImageModel;

import java.awt.*;

public class CommandTranslate extends Command implements Icommand {

    private Point point;

    public CommandTranslate(ImageModel img, Point point) {
        super(img);
        this.point = point;
    }

    @Override
    public void execute() {
        this.img.getMyPerspective().translate(point.x,point.y);
    }

    @Override
    public void undo() {
        int x = - point.x;
        int y = - point.y;
        this.img.getMyPerspective().translate(x,y);
    }
}
