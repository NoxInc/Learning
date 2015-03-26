package net.noxinc;

import java.util.Scanner;

import net.noxinc.units.Player;
import net.noxinc.world.InitMap;
import net.noxinc.world.Map;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Player p1 = new Player(InitMap.registerMap(new Map("Debug")), 2, 2);
		
		p1.getMap().updateMap();
		
		while(!p1.isDead())
		{
			switch(input.nextInt())
			{
			case 1:
				p1.moveTo(0, -1, 1);
				break;
			case 2:
				p1.moveTo(0, 1, 2);
				break;
			case 3:
				p1.moveTo(1, 0, 3);
				break;
			case 4:
				p1.moveTo(-1, 0, 4);
			}
			p1.getMap().updateMap();
		}
	}
}
