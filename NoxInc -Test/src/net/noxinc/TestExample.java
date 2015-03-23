package net.noxinc;

import java.util.Scanner;

import net.noxinc.units.Player;
import net.noxinc.world.Cell;
import net.noxinc.world.Map;

public class TestExample 
{
	public static void main(String[] args)
	{
		Scanner myScanner = new Scanner(System.in);
		Map a1 = new Map(5, 8);
		Player p1 = new Player(a1, 2, 2);
		
		a1.createCellAtLocation(new Cell('x', "TestSolid") .setSolidness(true), 3, 3);
		a1.createCellAtLocation(new Cell('H', "Healing Pot")
		{
			@Override
			public void onArrival()
			{
				p1.setHealth(p1.getHealth() + 5);
				System.out.println(p1.getHealth());
			}
		}, 3, 0);
		a1.drawMap();
		
		while(p1.getHealth() > 0)
		{
			int tmp = myScanner.nextInt();
			switch(tmp)
			{
			case 1:
				p1.moveTo(-1, 0);
				break;
			case 2:
				p1.moveTo(1, 0);
				break;
			case 3:
				p1.moveTo(0, 1);
				break;
			case 4:
				p1.moveTo(0, -1);
				break;
			default:
				System.out.println("No valid option");
			}
			a1.drawMap();
		}
	}

}
