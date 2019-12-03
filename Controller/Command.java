package Controller;

import Model.ImageModel;

/**
 * @author  anhe Pascal
 */

abstract class  Command  {

     protected static ImageModel img;

    /**
     *
     * class abstraite des commandes
     */

     public Command(ImageModel img){
         this.img=img;
     }
}
