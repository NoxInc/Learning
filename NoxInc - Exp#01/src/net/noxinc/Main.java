package net.noxinc;

import net.noxinc.world.Map;

public class Main 
{
	public static void main(String[] args)
	{
		Map map1 = new Map();
		Map map2 = new Map();
		
		System.out.println(map1.getMapName());
		System.out.println(map2.getMapName());
	}
}
