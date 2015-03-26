package net.noxinc.world;

import java.util.ArrayList;

public class InitMap 
{
	private static ArrayList<Map> mapList = new ArrayList<Map>();
	
	public static Map registerMap(Map map)
	{
		mapList.add(map);
		return mapList.get(mapList.size() - 1);
	}
	
	public static Map getMap(int idx)
	{
		return mapList.get(idx);
	}
}
