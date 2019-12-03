package Controller;

import Interfaces.Icommand;

import java.util.Stack;

/**
 * @author  pascal anhe
 *
 */

public class GestionnaireCommande {

    /**
     * uilisation de de la librairie Strack sur ce site
     * src https://insensa.org/development/java-doc/index.html?insensa/commands/CommandManager.html
     */

    private static  GestionnaireCommande singleton;
    private Stack<Icommand> stackYes;
    private Stack<Icommand> stackNo;

    private GestionnaireCommande() {
        stackYes = new Stack<>();
        stackNo = new Stack<>();
    }

    /**
     *
     * @param command
     */
    public void doCommand(Icommand command) {
        command.execute();
        stackYes.push(command);
        stackNo.clear();
    }


    /**
     *
     * @return
     */

    public static  GestionnaireCommande getInstance(){

        if(singleton== null){
            singleton = new GestionnaireCommande();
        }

        return singleton;
    }


    /***
     *
     */
    public void undo(){
        if(stackYes.isEmpty()) {
            return;
        }
        Icommand command = stackYes.pop();
        stackNo.push(command);
        command.undo();
    }

    /**
     *
     */
    public void redo() {
        if(stackNo.isEmpty()) {
            return;
        }
        Icommand command  = stackNo.pop();
        stackYes.push(command);
        command.execute();
    }

    /**
     *
     */
    public void reboot(){
        stackYes.clear();
        stackNo.clear();
    }


    /**
     *
     */
    public void rebootUndoSatck() {
        stackYes.clear();
    }
}
