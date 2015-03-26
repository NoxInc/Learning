package net.noxinc.world.cells;

public class Cell 
{
	private char symbol;
	private String name;
	private boolean isSolid;
	private boolean isCollectable;
	
	public Cell(char symbol, String name)
	{
		this.symbol = symbol;
		this.name = name;
	}
	
	public boolean isSolid()
	{
		return isSolid;
	}
	
	public boolean isCollectable()
	{
		return isCollectable;
	}
	
	public char getSymbol()
	{
		return symbol;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Cell setSolidState(boolean value)
	{
		isSolid = value;
		return this;
	}
	
	public Cell setCollectState(boolean value)
	{
		isCollectable = value;
		return this;
	}
}
