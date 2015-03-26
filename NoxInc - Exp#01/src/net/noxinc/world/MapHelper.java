package net.noxinc.world;


public class MapHelper 
{
	public static String randomMapName()
	{
		//TODO Only unique names
		double tmp = Math.round((Math.random() * 10000));
		
		Double tmpDouble = new Double(tmp);
		String s = tmpDouble.toString();
		
		return s;
	}
}
