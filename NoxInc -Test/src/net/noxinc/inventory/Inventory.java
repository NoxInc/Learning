package net.noxinc.inventory;

import java.util.ArrayList;
import java.util.Scanner;

import net.noxinc.status.Dialogs;
import net.noxinc.units.Player;
import net.noxinc.world.cells.Cell;

public class Inventory 
{
	private ArrayList<Cell> inventory;
	private int maxSize;
	private Player player;
	
	public Inventory(int maxSize, Player player)
	{
		inventory = new ArrayList<Cell>();
		this.maxSize = maxSize;
		this.player = player;
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
		int tmp3;
		Scanner myScanner = new Scanner(System.in);
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
		
		Dialogs.inventory1();
		
		tmp3 = myScanner.nextInt();
		if(!(tmp3 > maxSize + 1))
		{
			inventory.get(tmp3 - 1).use(player);
		}else{
			player.getMap().drawMap(player);
		}
		
		
	}
}
