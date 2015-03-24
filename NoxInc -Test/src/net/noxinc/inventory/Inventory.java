package net.noxinc.inventory;

import java.util.ArrayList;

import net.noxinc.status.Dialogs;
import net.noxinc.world.cells.Cell;

public class Inventory 
{
	private ArrayList<Cell> inventory;
	private int maxSize;
	
	public Inventory(int maxSize)
	{
		inventory = new ArrayList<Cell>();
		this.maxSize = maxSize;
	}
	
	public void addToInventory(Cell cell)
	{
		if(!(inventory.size() > maxSize))
		{
			inventory.add(cell);
		}else{
			Dialogs.status("Cant add " + cell.getName() + ". Inventory full.");
		}
	}
	
	public void drawInventory()
	{
		String tmp = " ";
		String tmp2 = "";
		int tmp3 = maxSize - inventory.size();
		for(int i = 0; i < inventory.size(); i++)
		{
			tmp += "_ ";
			tmp2 += "|";
			tmp2 += inventory.get(i).getSymbol();
			
		}
		for(int i = inventory.size() + 1; i <= maxSize; i++)
		{
			tmp += "_ ";
			tmp2 += "| ";
		}
		System.out.println(tmp + "\n" + tmp2 + "|");
	}
}
