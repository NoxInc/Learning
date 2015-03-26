package net.noxinc;

import java.util.Scanner;

import net.noxinc.units.Player;
import net.noxinc.world.InitMap;
import net.noxinc.world.Map;
import net.noxinc.world.cells.Cell;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Player p1 = new Player("NoxInc", InitMap.registerMap(new Map("Debug")), 2, 2);
		
		p1.getMap().setCell(new Cell('H', "HP-Pot").setCollectable(), 4, 4);
		p1.getMap().setCell(new Cell('+', "Wall").setSolid().setMineable(), 4, 5);
		
		p1.getMap().updateMap();
		
		while(!p1.isDead())
		{
			p1.move(input.nextInt(), input);
			
			p1.getMap().updateMap();
		}
	}
}
