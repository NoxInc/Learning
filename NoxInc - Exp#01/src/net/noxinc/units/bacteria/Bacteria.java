package net.noxinc.units.bacteria;

import net.noxinc.ColonyBac;

public class Bacteria 
{
	private String name;
	private int deathCounter;
	private boolean isDead;
	
	public Bacteria(String name, ColonyBac colony)
	{
		this.name = name;
		deathCounter = (int)Math.random() + 3;
		colony.registerBacteria(this);
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getDC()
	{
		return deathCounter;
	}
	
	public boolean isDead()
	{
		return isDead;
	}
	
	public void nextCycle()
	{
		if(deathCounter-- == 0)
		{
			isDead = true;
		}
	}
}
