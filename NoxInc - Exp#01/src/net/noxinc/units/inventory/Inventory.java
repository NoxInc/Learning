package net.noxinc.units.inventory;

import java.util.ArrayList;
import java.util.Scanner;

import net.noxinc.units.Player;
import net.noxinc.world.cells.Cell;

public class Inventory 
{
	private Scanner input = new Scanner(System.in);
	private ArrayList<Cell> inventory = new ArrayList<Cell>();
	private Player player;
	private int maxSlots;
	
	public Inventory(int maxSlots)
	{
		this.maxSlots = maxSlots;
	}
	
	public Inventory(int maxSlots, Player player)
	{
		this.maxSlots = maxSlots;
		this.player = player;
	}
	
	public boolean addToInventory(Cell cell)
	{
		if(inventory.contains(cell) && cell.getCurrentStack() < cell.getMaxStackSize())
		{
			cell.modifyCurrentStackBy(1);
			return true;
		}else if(inventory.size() < maxSlots && cell.getCurrentStack() >= cell.getMaxStackSize())
		{
			inventory.add(cell);
			cell.modifyCurrentStackBy(1);
			return true;
		}else if(inventory.size() < maxSlots)
		{
			inventory.add(cell);
			cell.modifyCurrentStackBy(1);
			return true;
		}else{
			System.out.println("Cant add cell to inventory");
			return false;
		}
	}
	
	public void open()
	{
		String tmp = "";
		for(Cell c : inventory)
		{
			tmp += inventory.indexOf(c) + 1 + ". " + c.getName() + " [" + c.getCurrentStack() + "/" + c.getMaxStackSize() + "]\n";
		}
		System.out.println(tmp);
		
		System.out.println("Select slot");
		int intTmp = input.nextInt();
		if(intTmp != 0)
		{
			if((intTmp > 0 || intTmp <= inventory.size() - 1))
			{
				System.out.println("(1) Use Cell");
				int tmp2 = input.nextInt();
				switch(tmp2)
				{
				case 0:
					break;
				case 1:
					if(inventory.get(intTmp - 1).use(player))
					{
						System.out.println("used");
						if(inventory.get(intTmp - 1).getCurrentStack() == 1)
						{
							inventory.remove(intTmp - 1);
						}else{
							inventory.get(intTmp - 1).modifyCurrentStackBy(-1);
						}
					}
					break;
				}
			}
		}
	}
}
