package simulation;

import javax.swing.*;
import java.util.ArrayList;

public class Creation {

    private Creation _instance;
    private ArrayList<ArrayList> listeUsine;

    private static ArrayList<Usine> usinesSimulation = new ArrayList<>();
    private static ArrayList<Usine> usinesAttribut = new ArrayList<>();
    private static ArrayList<ImageIcon> image = new ArrayList<>();
    private static ArrayList<Chemin> chemin = new ArrayList<>();

    /**
    public static Creation getInstance(){
        if(_instance == null)
            _instance = new Creation();
        return _instance;
    }
     **/

    public static void creationSimulation(String type, String id, String posX, String posY){

        usinesSimulation.add(new Usine(type, id, posX, posY));
    }

    public static void creationAttributUsine(String type, ArrayList<String> icone, ArrayList<String> entre,
                                             ArrayList<String> sortie, ArrayList<String> intervalle){

        usinesAttribut.add(new Usine(type, icone, entre, sortie, intervalle));
    }

    public static void creationChemin(String de, String vers){

        chemin.add(new Chemin(de, vers));
    }

    public static ArrayList<Usine> getUsinesAttribut() {

        return usinesAttribut;
    }

    public static ArrayList<Usine> getUsinesSimulation() {

        return usinesSimulation;
    }

    public static ArrayList<Chemin> getChemin(){

        return chemin;
    }
    public static ArrayList<ImageIcon> getImage(){

        return image;
    }
}
