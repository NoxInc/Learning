package net.noxinc;

import java.util.ArrayList;

import net.noxinc.units.bacteria.Bacteria;

public class ColonyBac 
{
	private ArrayList<Bacteria> bacList = new ArrayList<Bacteria>();
	
	public ColonyBac()
	{
		
	}
	
	public void registerBacteria(Bacteria bac)
	{
		bacList.add(bac);
	}
	
	public ArrayList<Bacteria> getBackColony()
	{
		return bacList;
	}
	
}
