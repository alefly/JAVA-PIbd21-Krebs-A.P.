package techProgr;

import java.awt.Graphics;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
	private ITechnique ufo;
	private Parking parking;

	public MyPanel() {
		super();
		parking = new Parking(7);

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		parking.drawMarking(g);
		if (ufo != null) {
			parking.putUFOInParking(ufo);
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

	public void levelUp() {
		parking.levelUp();
	}

	public void levelDown() {
		parking.levelDown();
	}
	
	public void loadParking(String fileName) {
		 		this.parking.loadData(fileName);
		 		repaint();
		 	}
		 	
		 	
		 	public void saveParking(String fileName) {
		 		this.parking.saveData(fileName);
		 		repaint();
		 	}
}
