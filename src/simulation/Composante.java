package simulation;

public class Composante {

    private String mot;
    private int nombre;

    public Composante(String mot){

        this.mot = mot;
    }

    public Composante(int nombre) {

        this.nombre = nombre;
    }

    public String getMot() {

        return mot;
    }

    public int getNombre() {

        return nombre;
    }

    public void setMot(String mot) {

        this.mot = mot;
    }

    public void setNombre(int nombre) {

        this.nombre = nombre;
    }

}
