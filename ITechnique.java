package techProgr;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public interface ITechnique extends Serializable{
	void moveUFO();
	void setPosition(int x,int y);
	void loadPassenger(int count);
	int getPassenger();
	void drawUFO(Graphics g);
	void setBodyColor(Color c);
}
