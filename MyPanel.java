package techProgr;

import java.awt.Graphics;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
	 	private ITechnique ufo;
	 	private Parking parking;
	 	 	
	 	 	public MyPanel() {
	 	 		super();
	 	 		parking = new Parking();
	 	 		
	 	 	}
	 	@Override
	 	public void paint(Graphics g) {
	 		super.paint(g);
	 		parking.drawMarking(g);
	 		if(ufo != null) {
	 			parking.putShipInParking(ufo);
	 				ufo = null;
	 		}
	 		parking.drawAll(g);
	 	}
	 	
	 	public void setUFO(ITechnique ufo) {
	 		this.ufo = ufo;
	 	}
	 	public ITechnique getUFO(int i) {
	 		return parking.getUFOInParking(i);
	 	}
	 }
