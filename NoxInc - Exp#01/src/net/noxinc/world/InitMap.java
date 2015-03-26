package net.noxinc.world;

import java.util.ArrayList;

public class InitMap 
{
	private static ArrayList<Map> maps = new ArrayList<Map>();
	
	public static Map registerMap(Map map)
	{
		maps.add(map);
		return maps.get(maps.size() - 1);
	}
	
	public static Map getMap(int idx)
	{
		return maps.get(idx);
	}
	
	public static int getMapIndex(Map map)
	{
		return maps.indexOf(map);
	}
}
