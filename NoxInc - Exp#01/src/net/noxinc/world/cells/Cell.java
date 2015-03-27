package net.noxinc.world.cells;

import net.noxinc.units.Player;
import net.noxinc.world.Map;


public class Cell 
{
	private char symbol;
	private String name;
	private Map map;
	private boolean isSolid;
	private boolean isCollectable;
	private boolean isMineable;
	private int maxStackSize = 3;
	private int currentStack = 1;
	
	public Cell(char symbol, String name, Map map)
	{
		this.map = map;
		this.symbol = symbol;
		this.name = name;
	}
	
	public boolean use(Player player)
	{
		return false;
	}
	
	public boolean isSolid()
	{
		return isSolid;
	}
	
	public boolean isCollectable()
	{
		return isCollectable;
	}
	
	public boolean isMineable()
	{
		return isMineable;
	}
	
	public char getSymbol()
	{
		return symbol;
	}
	
	public int getMaxStackSize()
	{
		return maxStackSize;
	}
	
	public int getCurrentStack()
	{
		return currentStack;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Cell setSolid()
	{
		isSolid = true;
		return this;
	}
	
	public Cell setCollectable()
	{
		isCollectable = true;
		return this;
	}
	
	public Cell setMineable()
	{
		isMineable = true;
		return this;
	}
	
	public Cell setMaxStackSize(int stackSize)
	{
		this.maxStackSize = stackSize;
		return this;
	}
	
	public Cell modifyCurrentStackBy(int mod)
	{
		currentStack += mod;
		return this;
	}
	
	protected Cell setName(String name)
	{
		this.name = name;
		return this;
	}
}
