package l1Alyona;

public class Oil {
	public int temperature = 0;

	public void GetHeat() {
		if (temperature < 100) {
			temperature++;
		}
	}
}
