package Controller;

import Model.Constantes;
import Model.ImageModel;

import java.awt.*;
import java.awt.event.*;

/**
 * operation du clavier sur
 * source : https://docs.oracle.com/javase/tutorial/uiswing/events/mousemotionlistener.html
 * @author pascal anhe
 */

public class PerpectiveController implements MouseListener, MouseWheelListener, MouseMotionListener, KeyListener {

   private Point default_point;
   private ImageModel img;

    public PerpectiveController(ImageModel img) {
        this.img = img;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
     if((e.getKeyCode() == KeyEvent.VK_Z) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
      GestionnaireCommande.getInstance().undo();
     }

     if((e.getKeyCode() == KeyEvent.VK_Y) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
      GestionnaireCommande.getInstance().redo();
     }

     if((e.getKeyCode() == KeyEvent.VK_S) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
      CommandSaveImage commande = new CommandSaveImage(img);
      commande.execute();
     }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
       this.default_point = new Point(e.getX(), e.getY());
        e.getComponent().setCursor(new Cursor(Cursor.MOVE_CURSOR));
    }

    @Override
    public void mousePressed(MouseEvent e) {
     default_point = new Point(e.getX(), e.getY());
     e.getComponent().setCursor(new Cursor(Cursor.MOVE_CURSOR));
    }

    @Override
    public void mouseReleased(MouseEvent e) {

     e.getComponent().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

     int deltaX = e.getX() - default_point.x;
     int deltaY = e.getY() - default_point.y;

     GestionnaireCommande.getInstance().doCommand(new CommandTranslate(img, new Point(deltaX, deltaY)));

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
     if(e.getWheelRotation() < 1) {
      System.out.println(img.getMyPerspective().getNum_zoom());
      GestionnaireCommande.getInstance().doCommand(new CommandZoom(img, Constantes.PLUS));

     } else {
      GestionnaireCommande.getInstance().doCommand(new CommandZoom(img,Constantes.MOINS));
     }
    }
}
