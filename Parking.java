package techProgr;

import java.awt.Color;
import java.awt.Graphics;

public class Parking {
	    ClassArray<ITechnique> parking;
	 	private int countPlaces = 20;
	 	private int placeSizeWidth = 220;
	 	private int placeSizeHeight = 160;
	 	
	 	public Parking() {
	 		parking = new ClassArray<ITechnique>(countPlaces,null);
	 	}
	 	
	 	public int putShipInParking(ITechnique ufo) {
	 		return parking.addUFO(ufo);
	 	}
	 	
	 	public ITechnique getUFOInParking(int ticket) {
	 		return parking.getUFO(ticket);
	 	}
	 	
	 	public void drawAll(Graphics g) {
	 		for(int i = 0;i<countPlaces;i++) {
	 			ITechnique ufo = parking.popUFO(i);
	 			if(ufo!=null) {
	 				ufo.setPosition(5 + i /5 * placeSizeWidth + 2, i % 5 * placeSizeHeight + 60);
	 				ufo.drawUFO(g);
	 			}
	 		}
	 	}
	 	
	 	public void drawMarking(Graphics g) {
	 		g.setColor(Color.BLACK);
	 		g.drawRect(0, 0, (countPlaces / 5) * placeSizeWidth, 800);
	 		for(int i = 0; i < countPlaces / 5; i++) {
	 			for(int j = 0; j< 6;j++) {
	 				g.drawLine(i * placeSizeWidth, j*placeSizeHeight,
	 						i*placeSizeWidth + 110, j * placeSizeHeight);
	 			}
	 			g.drawLine(i*placeSizeWidth, 0, i*placeSizeWidth, 800);
	 		}
	 	}
}
