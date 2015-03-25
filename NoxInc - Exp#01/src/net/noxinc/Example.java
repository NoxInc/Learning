package net.noxinc;

import java.util.Scanner;

import net.noxinc.units.bacteria.Bacteria;



public class Example 
{
	public static void main(String[] args)
	{
		Scanner myScanner = new Scanner(System.in);
		ColonyBac oneC = new ColonyBac();
		Bacteria one = new Bacteria("Kokken-1", oneC);
		
		while(true)
		{
			for(Bacteria i : oneC.getBackColony())
			{
				System.out.print(i.getName() + " | ");
			}
			System.out.println(oneC.getBackColony().size());
			System.out.println(one.getDC());
			if(myScanner.nextInt() == 1)
			{
				
			}
		}
	}

}
