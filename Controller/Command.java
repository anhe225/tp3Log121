package Controller;

import Model.ImageModel;

abstract class  Command  {

     protected static ImageModel img;
     protected static  double ZOOM_EFFECT =0.2;

     public Command(ImageModel img){
         this.img=img;
     }
}
