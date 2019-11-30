package ButListener;

import Controller.CommandTranslate;
import Model.ImageModel;

import java.awt.*;
import java.awt.event.ActionEvent;

public class ButTranslate extends ButListener {
    private Point point;


    @Override
    public void actionPerformed(ActionEvent e) {
      this.manager.doCommand(new CommandTranslate(this.getImg(), point));
    }

    public ButTranslate(String name, ImageModel img, Point point) {
        super(name, img);
        this.point = point;
    }
}
