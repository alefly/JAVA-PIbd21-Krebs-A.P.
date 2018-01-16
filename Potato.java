package l1Alyona;

public class Potato {
	public int has_ready = 0;
    public int dirty = 10;
    public boolean Have_skin;
    public boolean Have_wholeness;

    
    public void Dirty(int value)
    {
     
            if (value > -1 && value < 11)
                dirty = value;
       
    }
    public void GetHeat()
    {
        if (has_ready < 10)
        {
            has_ready++;
        }
    }
}

