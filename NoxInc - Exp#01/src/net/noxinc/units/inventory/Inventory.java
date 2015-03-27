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
		if(inventory.size() < maxSlots)
		{
			inventory.add(cell);
			return true;
		}else{
			System.out.println("Cant add cell to inventory");
			return false;
		}
	}
	
	public char getSymbolFromIndex(int idx)
	{
		return inventory.get(idx).getSymbol();
	}
	
	public Cell placeCell(int idx)
	{
		Cell tmp;
//		if(inventory.get(idx).getCurrentStack() > 1)
//		{
//			tmp = inventory.get(idx).modifyCurrentStackBy(-inventory.get(idx).getCurrentStack() + 1);
//			inventory.get(idx).modifyCurrentStackBy(-1);
//		}else{
			tmp = inventory.get(idx);
			inventory.remove(idx);
//		}
		return tmp;
		
	}
	
	public int getMaxSlots()
	{
		return maxSlots;
	}
	
	public int getSize()
	{
		return inventory.size();
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
		int slot = input.nextInt();
		
		if((slot > 0 && slot <= inventory.size()))
		{
			System.out.println("(1) Use Cell");
			System.out.println("(2) Place Cell");
			int tmp2 = input.nextInt();
			switch(tmp2)
			{
			case 0:
				break;
			case 1:
				if((inventory.get(slot - 1).use(player) == true))
				{
					System.out.println("used");
					if(inventory.get(slot - 1).getCurrentStack() == 1)
					{
						inventory.remove(slot - 1);
					}else{
						inventory.get(slot - 1).modifyCurrentStackBy(-1);
					}
				}
				break;
			case 2:
				player.placeCell(slot);
				break;
			}
		}
	}
}
