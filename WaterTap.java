package l1Alyona;

public class WaterTap {
	public boolean State;
    public void Wash(Potato p)
    {
        if (State)
        {
            p.Dirty(0);
        }
    }

    public Water GetWater()
    {
        if (State)
        {
            return new Water();
        }
        else
        {
            return null;
        }
    }
}

