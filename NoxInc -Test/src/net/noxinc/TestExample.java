package net.noxinc;

import java.util.Scanner;

import net.noxinc.status.Dialogs;
import net.noxinc.units.Player;
import net.noxinc.world.Map;
import net.noxinc.world.cells.Cell;

public class TestExample 
{
	public static void main(String[] args)
	{
		Scanner myScanner = new Scanner(System.in);
		Map a1 = new Map(7, 8);
		Player p1 = new Player(a1, 2, 2);
		
		a1.createCellAtLocation(new Cell('x', "TestSolid") .setSolidness(true), 3, 3);
		a1.createCellAtLocation(new Cell('H', "Healing Pot").setHealing(5), 3, 0);
		a1.createCellAtLocation(new Cell('!', "Mine").setDamage(10), 4, 4);
		a1.createCellAtLocation(new Cell('#', "HP-Pot").setCollect(true), 5, 2);
		a1.drawMap(p1);
		
		while(p1.getHealth() > 0)
		{
			int tmp = myScanner.nextInt();
//			a1.drawMap(p1);
			switch(tmp)
			{
			case 1:
				p1.moveTo(0, -1);
				break;
			case 2:
				p1.moveTo(0, 1);
				break;
			case 3:
				p1.moveTo(1, 0);
				break;
			case 4:
				p1.moveTo(-1, 0);
				break;
			case 5:
				a1.drawMap(p1);
				p1.getInventory().drawInventory();
				break;
			default:
				System.out.println("No valid option");
			}
		}
		Dialogs.status("You deaded :P");
	}

}
