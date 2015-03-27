package net.noxinc;

import java.util.Scanner;

import net.noxinc.units.Player;
import net.noxinc.world.InitMap;
import net.noxinc.world.Map;
import net.noxinc.world.cells.Cell;
import net.noxinc.world.cells.CellPotion;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Player p1 = new Player("NoxInc", InitMap.registerMap(new Map("Debug")), 2, 2);
		
		p1.getMap().setCell(new CellPotion(p1.getMap(), 5), 4, 4);
		p1.getMap().setCell(new CellPotion(p1.getMap(), 5), 3, 4);
		p1.getMap().setCell(new Cell('+', "Wall", p1.getMap()).setSolid().setMineable(), 4, 5);
		
		p1.getMap().updateMap();
		
		while(!p1.isDead())
		{
			p1.getMap().updateMap();
			p1.move(input.nextInt(), input);
			
		}
	}
}
