package techProgr;

import java.awt.Graphics;

public interface ITechnique {
	void moveUFO();
	void setPosition(int x,int y);
	void loadPassenger(int count);
	int getPassenger();
	void drawUFO(Graphics g);
}
