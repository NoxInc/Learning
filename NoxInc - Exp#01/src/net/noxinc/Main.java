package net.noxinc;

import net.noxinc.units.Player;
import net.noxinc.world.Map;

public class Main 
{
	public static void main(String[] args)
	{
		Map map1 = new Map();
		Player p1 = new Player(map1, 2, 2);
		
		map1.updateMap();
	}
}
