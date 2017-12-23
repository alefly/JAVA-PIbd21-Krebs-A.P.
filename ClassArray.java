package techProgr;

import java.io.Serializable;
import java.util.HashMap;

public class ClassArray<T extends ITechnique> implements Serializable {
    private HashMap<Integer,T> places;
    private int maxCount;
    private T defaultValue;

	public ClassArray(int size, T defaultValue) {
		this.defaultValue = defaultValue;
		places = new HashMap<Integer, T>();
		this.maxCount = size;
	}
	
	public int addUFO(T ufo) {
		for(int i = 0; i < maxCount; i++) {
			if(checkFreePlace(i)) {
				places.put(i, ufo);
				return i;
			}
		}
		return -1;
	}
	
	public T getUFO(int index) {
		if(!checkFreePlace(index)) {
			T ufo = places.get(index);
			places.remove(index);
			return ufo;
		}
		return defaultValue;
	}
	
	public T popUFO(int index) {
		if(!checkFreePlace(index)) {
			return places.get(index);
		}
		return defaultValue;
	}
	
	private boolean checkFreePlace(int index) {
		return !places.containsKey(index);
	}
}