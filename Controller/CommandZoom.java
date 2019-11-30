package Controller;

import Interfaces.Icommand;
import Model.ImageModel;

public class CommandZoom extends  Command implements Icommand {
    private String Value;

    public CommandZoom(ImageModel img, String value) {
        super(img);
        Value = value;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    @Override
    public void execute() {
        if (this.getValue().equals("plus")){
            img.getMyPerspective().changeZoom( ZOOM_EFFECT);
        }else {

            img.getMyPerspective().changeZoom(-ZOOM_EFFECT);
        }
    }

    @Override
    public void undo() {
        if (this.getValue().equals("plus")){
            img.getMyPerspective().changeZoom( -ZOOM_EFFECT);
        }else {

            img.getMyPerspective().changeZoom( ZOOM_EFFECT);
        }
    }
}
