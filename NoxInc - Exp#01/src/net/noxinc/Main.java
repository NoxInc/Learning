package net.noxinc;

import java.util.Scanner;

import net.noxinc.units.Bacteria;
import net.noxinc.units.List;
import net.noxinc.world.Map;
import net.noxinc.world.cells.BacteriaColony;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner myScanner = new Scanner(System.in);
		Map map = new Map(10);
		BacteriaColony c1 = new BacteriaColony(map, List.kokken, 3, 2);
		map.update();
		
		
		while(true)
		{
			map.update();
			switch(myScanner.nextInt())
			{
			case 0:
				for(Bacteria b : c1.getColony())
				{
					b.setCanGrow(true);
				}
				break;
			case 1:
				c1.growth();
				System.out.println(c1.getColonySize());
				for(Bacteria b : c1.getColony())
				{
					b.setCanGrow(false);
				}
				break;
			case 2:
				for(Bacteria b : c1.getColony())
				{
					System.out.println(b.getName());
				}
			}
		}
	}
}
