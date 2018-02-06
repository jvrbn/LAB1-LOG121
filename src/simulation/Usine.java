package simulation;

import java.util.ArrayList;

public class Usine {

    private int numeroID;
    private String type;
    private ArrayList<String> icone;
    private ArrayList<String> entre;
    private ArrayList<String> sortie;
    private ArrayList<String> intervalle;
    private int quantiterEntrer;
    private int positionX;
    private int positionY;


    public Usine (String type, String id, String posX, String posY){

        this.type = type;
        this.numeroID = Integer.valueOf(id);
        this.positionX = Integer.valueOf(posX);
        this.positionY = Integer.valueOf(posY);

    }

    public Usine (String type, ArrayList<String> icone, ArrayList<String> entre,
                  ArrayList<String> sortie, ArrayList<String> intervalle){

        this.type = type;
        this.icone = icone;
        this.entre = entre;
        this.sortie = sortie;
        this.intervalle = intervalle;

    }

    public int getPositionX(){

        return positionX;
    }

    public int getPositionY(){

        return positionY;
    }

    public String getType() {
        return type;
    }

    public int getNumeroID(){

        return  numeroID;
    }

    public ArrayList<String> getIcone() {
        return icone;
    }

    public ArrayList<String> getEntre() {
        return entre;
    }

    public ArrayList<String> getSortie() {
        return sortie;
    }

    public ArrayList<String> getIntervalle() {
        return intervalle;
    }

}
