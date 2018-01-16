package l1Alyona;

public class Knife {
	 public void Clean(Potato p)
     {
         if (p.Have_skin)
         {
             p.Have_skin = false;
         }
     }
     public void Cut(Potato p)
     {
         if (p.Have_wholeness)
         {
             p.Have_wholeness = false;
         }
     }
 }

