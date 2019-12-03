package Controller;

import Interfaces.Icommand;
import Model.ImageModel;

public class CommandPerspective extends Command implements Icommand {
    private int index,previous;

    public CommandPerspective(ImageModel img, int index) {
        super(img);
        this.index = index;
        this.previous = img.getIndex();
    }

    @Override
    public void execute() {
        GestionnaireCommande.getInstance().rebootUndoSatck();
        img.modifyPerspectives(index);
    }

    @Override
    public void undo() {
        img.modifyPerspectives(previous);
    }
}
