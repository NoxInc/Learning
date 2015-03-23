package net.noxinc.world;

public class Cell 
{
	private char symbol;
	private boolean solid;
	private String name;
	
	public Cell(char symbol, String name)
	{
		this.symbol = symbol;
		this.name = name;
	}
	
	public Cell()
	{
		
	}
	
	public void onArrival()
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
	
	public Cell setSolidness(boolean value)
	{
		solid = value;
		return this;
	}
	
}
