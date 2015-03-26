package net.noxinc.world;


public class MapHelper 
{
	public static String randomMapName()
	{
		//TODO Only unique names
		Double tmpDouble = new Double(Math.round((Math.random() * 10000)));
		String s = tmpDouble.toString();
		
		return s;
	}
}
