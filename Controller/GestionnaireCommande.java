package Controller;

public class GestionnaireCommande {

    private static  GestionnaireCommande singleton;

    private GestionnaireCommande() {

    }

    public static  GestionnaireCommande getInstance(){

        if(singleton== null){
            singleton = new GestionnaireCommande();
        }

        return singleton;
    }
}
