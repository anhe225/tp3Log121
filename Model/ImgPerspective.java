package Model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;

public class ImgPerspective extends  Subject implements Serializable {

    private Point translate_image;
    private double num_zoom ;
    private ImageModel img;


    public ImgPerspective(ImageModel img) {
        this.img = img;
        this.num_zoom=1.0;
        this.translate_image = new Point();
        Attach(img);

    }


    public Point getTranslate_image() {
        return translate_image;
    }

    public void setTranslate_image(Point translate_image) {
        this.translate_image = translate_image;
    }

    public double getNum_zoom() {
        return num_zoom;
    }

    public void setNum_zoom(double num_zoom) {
        this.num_zoom = num_zoom;
    }

    public ImageModel getImg() {
        return img;
    }

    public void setImg(ImageModel img) {
        this.img = img;
    }


    public void translate(int x, int y){
        translate_image.x += x;
        translate_image.y += y;
        notifyObservers();
    }

    public void changeZoom(double num){
        num_zoom += num;
        notifyObservers();
    }
}
