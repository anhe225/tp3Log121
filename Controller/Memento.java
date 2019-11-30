package Controller;

import Model.Constantes;
import Model.ImageModel;
import Model.ImgPerspective;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Memento {
    private int index;
    private BufferedImage img;
    private ImgPerspective [] tabPerpective;

    public Memento(ImageModel img) {
       this.img = img.getImg();
       this.index = img.getIndex();
       this.tabPerpective = img.getTabPerpective();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public ImgPerspective[] getTabPerpective() {
        return tabPerpective;
    }

    public void setTabPerpective(ImgPerspective[] tabPerpective) {
        this.tabPerpective = tabPerpective;
    }

    public void ecritureObjet(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        ImageIO.write(this.img, Constantes.PNG, out);

    }

    public  void lectureObjet(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.img=ImageIO.read(in);

    }
}
