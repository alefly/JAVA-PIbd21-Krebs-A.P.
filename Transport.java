package techProgr;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Transport implements ITechnique {
	 
	 	protected int posX;
	 	protected int posY;
	 	protected int countPassengers;
	 	protected int maxCountPassengers;
	 	protected int maxSpeed;
	 	protected Color colorBody;
	 	protected float weight;
	 	
	 	
	 	@Override
	 	public abstract void moveUFO();
	 
	 	@Override
	 	public abstract void drawUFO(Graphics g);
	 
	 	@Override
	 	public void setPosition(int x, int y) {
	 		this.posX = x;
	 		this.posY = y;
	 		
	 	}
	 
	 	@Override
	 	public void loadPassenger(int count) {
	 		if(countPassengers + count < maxCountPassengers) {
	 			countPassengers += count;
	 		}
	 		
		}
	 
	 	@Override
	 	public int getPassenger() {
	 		int count = countPassengers;
	 		countPassengers = 0;
	 		return count;
	 	}
	 
	 	public int getMaxCountPassengers() {
	 		return maxCountPassengers;
	 	}
	 
	 	public int getMaxSpeed() {
			return maxSpeed;
	 	}
	 
	 	public Color getColorBody() {
	 		return colorBody;
	 	}
	 
	 	public float getWeight() {
	 		return weight;
	 	}
	 	
	 	
	 
	 }
