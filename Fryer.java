package l1Alyona;

public class Fryer {
	private Oil[] oil;
    private Potato[] potatoes;
    private Salt salt;
    public boolean power; 
    
    public void Init(int countPotatoes)
    {
        oil = new Oil[3];
        potatoes = new Potato[countPotatoes];

    }


    public void AddOil(Oil o)
    {
        for (int i = 0; i < oil.length; i++)
        {
            if (oil[i] == null)
            {
                oil[i] = o;
                return;
            }
        }
    }

    public void AddSalt(Salt s)
    {
        salt = s;
    }

    public void AddPotato(Potato p)
    {
        for (int i = 0; i < potatoes.length; ++i)
        {
            if (potatoes[i] == null)
            {
                potatoes[i] = p;
            }
            return;
        }
    }
    private boolean Check()
    {
        if (oil.length == 0)
        {
            return false;
        }
        if (potatoes.length == 0)
        {
            return false;
        }
        for (int i = 0; i < oil.length; i++)
        {
            if (oil[i] == null)
            {
                return false;
            }
        }
        for (int i = 0; i < potatoes.length; ++i)
        {
            if (potatoes[i] == null)
            {
                return false;
            }
        }
        return true;
    }



    public void GetHeat()
    {
        if (!Check())
        {
            return;
        }
        if (oil.length > 0)
        {
            if (oil[0].temperature < 100)
            {
                for (int i = 0; i < oil.length; i++)
                {
                    oil[i].GetHeat();
                }
            }
            boolean flag = false;
            switch (oil[0].temperature)
            {
                case 20:
                    flag = true;
                    break;
                case 40:
                    flag = true;
                    break;
                case 60:
                    flag = true;
                    break;
                case 80:
                    flag = true;
                    break;
                case 100:
                    flag = true;
                    break;
            }
            if (flag)
            {
                for (int i = 0; i < potatoes.length; ++i)
                {
                    potatoes[i].GetHeat();
                }
            }
        }
        else
        {
            for (int i = 0; i < potatoes.length; i++)
            {
                potatoes[i].GetHeat();
            }
        }
    }


    public boolean IsReady()
    {
        for (int i = 0; i < oil.length; i++)
        {
            if (oil[i].temperature < 100)
            {
                return false;
            }
        }
        for (int i = 0; i < potatoes.length; i++)
        {
            if (potatoes[i].has_ready < 10)
            {
                return false;
            }
        }
        return true;
    }
    public Potato[] GetPotatos()
    {
        return potatoes;
    }
    public boolean State;

    public void Cook() {
        if (State)
        {
            GetHeat();
        }
    } 
}

