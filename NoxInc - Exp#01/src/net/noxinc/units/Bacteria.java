package net.noxinc.units;


public class Bacteria 
{
	private String name;
	private boolean canGrow;
	
	public Bacteria(String name)
	{
		this.name = name;
	}
	
	public boolean canGrow()
	{
		return canGrow;
	}
	
	public String getName()
	{
		return name;
	}
	
	//-------------DEBUG---------------//
	public void setCanGrow(boolean value)
	{
		canGrow = value;
	}
}
