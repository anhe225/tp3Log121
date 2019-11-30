package Controller;

import Model.ImageModel;

abstract class  Command  {

     protected static ImageModel img;


     public Command(ImageModel img){
         this.img=img;
     }
}
