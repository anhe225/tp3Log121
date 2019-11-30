package Controller;

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

    }

    @Override
    public void mouseReleased(MouseEvent e) {

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

    }
}
