package techProgr;

import java.awt.Graphics;

import javax.swing.JPanel;

public class SelectPanel extends JPanel {

	private ITechnique ufo;
	 	
	 	@Override
	 	public void paint(Graphics g) {
	 		super.paint(g);
	 		if(ufo!=null) {
	 			ufo.setPosition(15, 120);
	 			ufo.drawUFO(g);
	 		}
	 	}
	 	
	 	public void setShip(ITechnique ship) {
	 		this.ufo = ship;
	 	}
	 }
