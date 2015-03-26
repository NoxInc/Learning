package net.noxinc.world;


public class MapHelper 
{
	public static String randomMapName()
	{
		double tmp = Math.round((Math.random() * 2));
		Double tmpDouble = new Double(tmp);
		String s = tmpDouble.toString();
		return s;
	}
}
