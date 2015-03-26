package net.noxinc.world;


public class MapHelper 
{
	public static String randomMapName()
	{
		double tmp = Math.round((Math.random() * 10000));
		Double tmpDouble = new Double(tmp);
		String s = tmpDouble.toString();
		return s;
	}
}
