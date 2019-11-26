package Controller;

 abstract class  Command  {

     private Souris souris;

     public Command(Souris souris) {
          super();
         this.souris = souris;
     }

     public Souris getSouris() {
         return souris;
     }

     public void setSouris(Souris souris) {
         this.souris = souris;
     }

     public  void execute(){

     }

     public  void undo(){

     }
}
