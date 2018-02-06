package simulation;

import sun.util.resources.cldr.rw.CurrencyNames_rw;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.*;

public class PanneauPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;
	
	// Variables temporaires de la demonstration:
	private Point position = new Point(0,0);
	private Point vitesse = new Point(1,1);
	private int taille = 32;

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// On ajoute à la position le delta x et y de la vitesse
		//position.translate(vitesse.x, vitesse.y);
		//g.fillRect(position.x, position.y, taille, taille);

		for(int i = 0 ; i < Creation.getUsinesSimulation().size(); i++){

            for(int j = 0; j < Creation.getUsinesAttribut().size(); j++){

                if(Creation.getUsinesSimulation().get(i).getType().equals(Creation.getUsinesAttribut().get(j).getType())){

                    ImageIcon imageIcon = new ImageIcon(Creation.getUsinesAttribut().get(j).getIcone().get(0)) ;

                    imageIcon.paintIcon(this, g, Creation.getUsinesSimulation().get(i).getPositionX(),
                            Creation.getUsinesSimulation().get(i).getPositionY());

                    //g.drawLine();
                }
            }
		}
	}
}