package techProgr;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.Random;

public class UFO extends Transport{
	 
	 public UFO(int maxSpeed,int maxCountPassengers, float weight, Color color) {
	 		this.colorBody = color;
		this.setWeight(weight);
	 		this.setMaxCountPassengers(maxCountPassengers);
	 		this.maxSpeed = maxSpeed;
	 		
	 		Random r = new Random();
	 		this.posX = (r.nextInt(190) +10);
	 		this.posY = (r.nextInt(190) +10);
	 		
	 	}
	 
	 	@Override
	 	public void moveUFO() {
	 		posX +=
	 				(maxSpeed * 50 / weight) / 
	 				(countPassengers == 0 ? 1 : countPassengers);
	 		
	 	}
	 
	 	@Override
	 	public void drawUFO(Graphics g) {
	 		drawBombUFO(g);
	 	}
	 	
	 	protected void drawBombUFO(Graphics g) {
            g.setColor(Color.BLACK);
            g.drawOval(posX + 20, posY - 10 + 5, 80, 30);
            g.setColor(colorBody);
            Polygon poly = new Polygon();
            poly.addPoint((int)posX + 20, (int)posY + 5);
            poly.addPoint((int)posX + 100, (int)posY + 5);
            poly.addPoint((int)posX + 120, (int)posY + 12 + 5);
            poly.addPoint((int)posX + 100, (int)posY + 24 + 5);
            poly.addPoint((int)posX + 20, (int)posY + 24 + 5);
            poly.addPoint((int)posX, (int)posY + 12 + 5); 
            poly.addPoint((int)posX + 20, (int)posY + 5);
            g.fillPolygon(poly);
	 	}
	 
	 	protected void setMaxCountPassengers(int value) {
	 		if(value>0 && value<5) {
	 			super.maxCountPassengers = value;
	 		} else {
	 			super.maxCountPassengers = value;
	 		}
	 	}
	 	
	 	protected void setWeight(float value){
	 		if(value>500 && value<1500) {
	 			super.weight = value;
	 		} else {
				super.weight = 1000;
	 		}
	 	}
	 	
	 	@Override
	 	 	public void setBodyColor(Color c) {
	 	 		colorBody = c;
	 	 	}
	 }
