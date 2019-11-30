package ButListener;

import Controller.CommandLoadImage;
import Model.ImageModel;

import java.awt.event.ActionEvent;

public class ButOnLoad extends ButListener {

    public ButOnLoad(String name, ImageModel img) {
        super(name, img);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        CommandLoadImage cImg = new CommandLoadImage(this.getImg());
       cImg.execute();
    }
}
