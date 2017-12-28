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
	
	public int addUFO(T ufo) throws OverflowException {
		for(int i = 0; i < maxCount; i++) {
			if(checkFreePlace(i)) {
				places.put(i, ufo);
				return i;
			}
		}
		throw new OverflowException();
	}
	
	public T getUFO(int index) throws IndexOutOfRangeException {
		if(!checkFreePlace(index)) {
			T ufo = places.get(index);
			places.remove(index);
			return ufo;
		}
		throw new IndexOutOfRangeException();
	}
	
	public T popUFO(int index) throws IndexOutOfRangeException{
		if(!checkFreePlace(index)) {
			return places.get(index);
		}
		throw new IndexOutOfRangeException();
	}
	
	private boolean checkFreePlace(int index) {
		return !places.containsKey(index);
	}
}