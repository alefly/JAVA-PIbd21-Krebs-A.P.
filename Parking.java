package techProgr;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Parking {
	ArrayList<ClassArray<ITechnique>> parking;
	private int countPlaces = 20;
	private int placeSizeWidth = 220;
	private int placeSizeHeight = 160;
	private int currentLevel;

	public Parking(int levels) {
		parking = new ArrayList<ClassArray<ITechnique>>();
		currentLevel = 0;
		for (int i = 0; i < levels; i++) {
			parking.add(new ClassArray<ITechnique>(countPlaces, null));
		}
	}

	public int putUFOInParking(ITechnique ufo) {
		return parking.get(currentLevel).addUFO(ufo);
	}

	public ITechnique getUFOInParking(int ticket) {
		return parking.get(currentLevel).getUFO(ticket);
	}

	public void drawAll(Graphics g) {
		for (int i = 0; i < countPlaces; i++) {
			ITechnique ufo = parking.get(currentLevel).popUFO(i);
			if (ufo != null) {
				ufo.setPosition(5 + i / 5 * placeSizeWidth + 2, i % 5
						* placeSizeHeight + 60);
				ufo.drawUFO(g);
			}
		}
	}

	public void levelUp() {
		if (currentLevel + 1 < parking.size()) {
			currentLevel++;
		}
	}

	public void levelDown() {
		if (currentLevel > 0) {
			currentLevel--;
		}
	}

	public int getCurentLevel() {
		return currentLevel;
	}

	public void drawMarking(Graphics g) {
		g.setColor(Color.BLUE);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString("L" + (currentLevel + 1), (countPlaces / 5)
				* placeSizeWidth - 70, 830);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, (countPlaces / 5) * placeSizeWidth, 800);
		for (int i = 0; i < countPlaces / 5; i++) {
			for (int j = 0; j < 6; j++) {
				g.drawLine(i * placeSizeWidth, j * placeSizeHeight, i
						* placeSizeWidth + 110, j * placeSizeHeight);
			}
			g.drawLine(i * placeSizeWidth, 0, i * placeSizeWidth, 800);
		}
	}

	public void saveData(String fileName) {
		try {
			FileOutputStream fileStream = new FileOutputStream(fileName);
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
			os.writeObject(parking);
		} catch (Exception e) {
			System.out.println("Íåò äîñòóïà ê ôàéëó");
		}
	}

	public void loadData(String fileName) {
		try {
			FileInputStream inStream = new FileInputStream(fileName);
			ObjectInputStream inObject = new ObjectInputStream(inStream);
			parking = (ArrayList<ClassArray<ITechnique>>) inObject.readObject();
		} catch (Exception ex) {
			System.out.println("Сохранение прошло успешно");
		}
	}
}
