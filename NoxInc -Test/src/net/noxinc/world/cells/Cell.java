package net.noxinc.world.cells;

import net.noxinc.status.Dialogs;
import net.noxinc.units.Player;

public class Cell 
{
	private char symbol;
	private boolean solid;
	private boolean collect;
	private int dmg;
	private int heal;
	private String name;
	
	public Cell(char symbol, String name)
	{
		this.symbol = symbol;
		this.name = name;
	}
	
	public Cell()
	{
		
	}
	
	public void onArrival(Player player)
	{
		if(dmg > 0)
		{
			player.setHealth(player.getHealth() - dmg);
			Dialogs.status("You lost " + dmg + "HP! ");
		}else if(heal > 0)
		{
			player.setHealth(player.getHealth() + heal);
			Dialogs.status("You healed by " + heal + "HP! ");
		}else if(isCollectable())
		{
			player.getInventory().addToInventory(this);
		}
	}
	
	public void use(Player player)
	{
		
	}
	
	public char getSymbol()
	{
		return symbol;
	}
	
	public String getName()
	{
		return name;
	}
	
	public boolean isSolid()
	{
		return solid;
	}
	
	public boolean isCollectable()
	{
		return collect;
	}
	
	public Cell setSolidness(boolean value)
	{
		solid = value;
		return this;
	}
	
	public Cell setDamage(int dmg)
	{
		this.dmg = dmg;
		return this;
	}
	
	public Cell setHealing(int heal)
	{
		this.heal = heal;
		return this;
	}
	
	public Cell setCollect(boolean value)
	{
		collect = value;
		return this;
	}
	
}
