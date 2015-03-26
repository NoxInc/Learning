package net.noxinc;

import net.noxinc.units.Player;
import net.noxinc.world.InitMap;
import net.noxinc.world.Map;

public class Main 
{
	public static void main(String[] args)
	{
		Player p1 = new Player(InitMap.registerMap(new Map("Debug")), 2, 2);
		
		p1.getMap().updateMap();
	}
}
