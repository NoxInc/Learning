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
}
