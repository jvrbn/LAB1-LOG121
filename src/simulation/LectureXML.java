package simulation;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class LectureXML {

    private final static String USINE = "usine";
    private final static String TYPE = "type";
    private final static String PATH = "path";
    private final static String ICONE = "icone";
    private final static String METADONNEES = "metadonnees";
    private final static String SIMULATION = "simulation";
    private final static String ENTREE = "entree";
    private final static String SORTIE = "sortie";
    private final static String CAPACITE = "capacite";
    private final static String QUANTITE = "quantite";
    private final static String ENTREPOT = "entrepot";
    private final static String INTERVALLE = "interval-production";
    private final static String POSX = "x";
    private final static String POSY = "y";
    private final static String ID = "id";
    private final static String CHEMIN = "chemin";

    private int nombreUsine;

    private HashMap<String,ArrayList> icone;



    public LectureXML(String path){

        try{

            File xmlFile = new File(path);

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            //Creation.getInstance();

            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(xmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root : " + doc.getDocumentElement().getNodeName());

            NodeList metadonneList = doc.getElementsByTagName(METADONNEES);
            NodeList simulationList = doc.getElementsByTagName(SIMULATION);

            for (int sautMetadonne = 0; sautMetadonne < metadonneList.getLength(); sautMetadonne++) {

                Node metadonneNode = metadonneList.item(sautMetadonne);

                if (metadonneNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element metadonne = (Element) metadonneNode;

                    NodeList listeUsine = metadonne.getElementsByTagName(USINE);
                    nombreUsine = listeUsine.getLength();

                    for (int sautUsine = 0; sautUsine < listeUsine.getLength(); sautUsine++) {

                        Node usineNode = listeUsine.item(sautUsine);
                        ArrayList<String> arrayListIcone = new ArrayList<>();
                        ArrayList<String> arrayListEntree = new ArrayList<>();
                        ArrayList<String> arrayListSortie = new ArrayList<>();
                        ArrayList<String> arrayListInterval = new ArrayList<>();

                        if (usineNode.getNodeType() == Node.ELEMENT_NODE) {

                            Element usine = (Element) usineNode;
                            System.out.println("\nType: " + usine.getAttribute(TYPE));

                            NodeList listeIcones = usine.getElementsByTagName(ICONE);

                            for (int sautIcone = 0; sautIcone < listeIcones.getLength(); sautIcone++) {

                                Node iconeNode = listeIcones.item(sautIcone);

                                if (iconeNode.getNodeType() == Node.ELEMENT_NODE) {

                                    Element icone = (Element) iconeNode;
                                    System.out.println("Icone " + icone.getAttribute(TYPE)
                                    + " PATH = " + icone.getAttribute(PATH));
                                    arrayListIcone.add(icone.getAttribute(PATH));
                                }
                            }

                            NodeList listeEntree = usine.getElementsByTagName(ENTREE);

                            for (int sautEntree = 0; sautEntree < listeEntree.getLength(); sautEntree++) {

                                Node entreNode = listeEntree.item(sautEntree);

                                if (entreNode.getNodeType() == Node.ELEMENT_NODE) {

                                    Element entre = (Element) entreNode;

                                    if (!usine.getAttribute(TYPE).equals(ENTREPOT)) {

                                        System.out.println("Entrer: " + entre.getAttribute(TYPE)
                                                                        + " Quantite: " + entre.getAttribute(QUANTITE));
                                        arrayListEntree.add(entre.getAttribute(TYPE));
                                        arrayListEntree.add(entre.getAttribute(QUANTITE));

                                    } else {

                                        System.out.println("Entrer: " + entre.getAttribute(TYPE)
                                                                        + " Capacite: " + entre.getAttribute(CAPACITE));
                                        arrayListEntree.add(entre.getAttribute(TYPE));
                                        arrayListEntree.add(entre.getAttribute(CAPACITE));
                                    }
                                }
                            }

                            NodeList listeSortie = usine.getElementsByTagName(SORTIE);

                            for (int sautSortie = 0; sautSortie < listeSortie.getLength(); sautSortie++) {

                                Node sortieNode = listeSortie.item(sautSortie);

                                if (sortieNode.getNodeType() == Node.ELEMENT_NODE) {

                                    Element sortie = (Element) sortieNode;
                                    System.out.println("Sortie: " + sortie.getAttribute(TYPE));
                                    arrayListSortie.add(sortie.getAttribute(TYPE));

                                }
                            }

                            NodeList listeInterval = usine.getElementsByTagName(INTERVALLE);


                            for (int sautInterv = 0; sautInterv < listeInterval.getLength(); sautInterv++) {

                                Node intervNode = listeInterval.item(sautInterv);

                                if (intervNode.getNodeType() == Node.ELEMENT_NODE) {

                                    Element interval = (Element) intervNode;
                                    System.out.println("Interval: " + interval.getTextContent());
                                    arrayListInterval.add(interval.getTextContent());
                                }
                            }
                            Creation.creationAttributUsine(usine.getAttribute(TYPE),arrayListIcone, arrayListEntree,
                                                                                    arrayListSortie, arrayListInterval);
                        }
                    }


                    System.out.println("");

                    for (int sautSimulation = 0; sautSimulation < simulationList.getLength(); sautSimulation++) {

                        Node simulationNode = simulationList.item(sautSimulation);

                        if (simulationNode.getNodeType() == Node.ELEMENT_NODE) {

                            Element simulation = (Element) simulationNode;

                            NodeList listeUsine1 = simulation.getElementsByTagName(USINE);

                            for (int sautUsine = 0; sautUsine < listeUsine1.getLength(); sautUsine++) {

                                Node usineNode = listeUsine1.item(sautUsine);

                                if (usineNode.getNodeType() == Node.ELEMENT_NODE) {

                                    Element usine = (Element) usineNode;
                                    System.out.println("Usine type " + usine.getAttribute(TYPE)
                                                                        + " ID: " + usine.getAttribute(ID)
                                                                            + " PosX:" + usine.getAttribute(POSX)
                                                                                + " PosY:" + usine.getAttribute(POSY));

                                    Creation.creationSimulation(usine.getAttribute(TYPE),usine.getAttribute(ID)
                                                                    ,usine.getAttribute(POSX),usine.getAttribute(POSY));
                                }
                            }

                            System.out.println("");
                            NodeList listeChemin = simulation.getElementsByTagName(CHEMIN);

                            for (int sautChemin = 0; sautChemin < listeChemin.getLength(); sautChemin++) {

                                Node cheminNode = listeChemin.item(sautChemin);

                                if (cheminNode.getNodeType() == Node.ELEMENT_NODE) {

                                    Element chemin = (Element) cheminNode;

                                    System.out.println("Chemin de " + chemin.getAttribute("de")
                                                                        + " vers " + chemin.getAttribute("vers"));
                                    Creation.creationChemin(chemin.getAttribute("de"),
                                                                                        chemin.getAttribute("vers"));
                                }
                            }
                        }
                    }
                }
            }
        }

        catch (Exception e){

            e.printStackTrace();
        }
    }

    public int getNombreUsine(){
        return nombreUsine;
    }
}


/**
 public static void lireNodeList(NodeList listeALire){

 for(int sautListeNoeud = 0; sautListeNoeud < listeALire.getLength(); sautListeNoeud++){

 Node noeudPresent = listeALire.item(sautListeNoeud);

 if(noeudPresent.getNodeType() == Node.ELEMENT_NODE){

 if(noeudPresent.hasAttributes()){

 NamedNodeMap listeNodeMap = noeudPresent.getAttributes();

 for(int sautNodeMap = 0; sautNodeMap < listeNodeMap.getLength(); sautNodeMap++){

 Node noeudTemp = listeNodeMap.item(sautNodeMap);
 System.out.println(noeudTemp.getNodeName() + " " +noeudTemp.getNodeValue());

 }

 }

 if(noeudPresent.hasChildNodes()){

 lireNodeList(noeudPresent.getChildNodes());
 }

 }
 System.out.println(" ");

 }
 }
 **/

