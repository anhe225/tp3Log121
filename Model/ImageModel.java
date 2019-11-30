package Model;

import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 * @author  anhe pascal
 * cette classe fera toutes les operations possible avec
 * avec les images
 */

public class ImageModel implements Serializable {

    private BufferedImage img;
    private int index;
    private ImgPerspective [] tabPerpective;

    public ImageModel(BufferedImage img) {
        this.img = img;
        this.index =0;
        initPerpective();
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ImgPerspective[] getTabPerpective() {
        return tabPerpective;
    }

    public void setTabPerpective(ImgPerspective[] tabPerpective) {
        this.tabPerpective = tabPerpective;
    }

    public void initPerpective ()
    {
        this.tabPerpective = new ImgPerspective[2];
        tabPerpective[0]= new ImgPerspective(this);
        tabPerpective[1]= new ImgPerspective(this);
    }

    public ImgPerspective getMyPerspective()
    {
        return tabPerpective[index];
    }

    public void setSize(int largeur, int longueur)
    {
        this.img = new BufferedImage(largeur, longueur, img.TYPE_INT_ARGB);
    }

  /**  @Override
    public void update() {
        notifyObservers();
    }

  **/
}
