package techProgr;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class BombUFO extends UFO {
	 private boolean pipe;
	 private boolean boat;
	 private Color dopColor;
	 public BombUFO(int maxSpeed, int maxCountPassengers,
	 			float weight, Color color,boolean pipe,boolean boat,Color dopColor) {
	 		super(maxSpeed, maxCountPassengers, weight, color);
	 		this.pipe = pipe;
	 		this.boat = boat;
	 		this.dopColor = dopColor;
	 	}
	 	
	 	@Override
	 	protected void drawBombUFO(Graphics g) {
	         super.drawBombUFO(g);
	         if (pipe)
	         {
	             g.setColor(dopColor);
	             Polygon poly = new Polygon();
	             poly.addPoint((int)posX + 100, (int)posY + 29);
	             poly.addPoint((int)posX + 120, (int)posY + 60);
	             poly.addPoint((int)posX, (int)posY + 60);
	             poly.addPoint((int)posX + 20, (int)posY + 29);
	             poly.addPoint((int)posX + 100, (int)posY + 29);
	             g.fillPolygon(poly);
	         }
	         if (boat)
	         {
	        	 g.setColor(Color.WHITE);
	             g.drawString("= ^ - ^ =", posX + 25, posY + 19);
	         }
	 	}
	 	public void setDopColor(Color c) {
	 		 		dopColor = c;
	 		 	}
	 
	 }