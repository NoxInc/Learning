package net.noxinc.world.cells;

import java.util.ArrayList;

import net.noxinc.units.Bacteria;
import net.noxinc.world.Map;

public class BacteriaColony extends Cell
{
	private ArrayList<Bacteria> colony = new ArrayList<Bacteria>();
	private String art;
	
	public BacteriaColony(Map map, String art, int x, int y)
	{
		super('B');
		map.setCell(this, x, y);
		colony.add(new Bacteria(art));
		this.art = art;
	}
	
	public void growth()
	{
		for(int i = 0; i < colony.size(); i++)
		{
			if(colony.get(i).canGrow())
			{
				colony.add(new Bacteria(art));
			}
		}
	}
	
	public int getColonySize()
	{
		return colony.size();
	}
	
	public ArrayList<Bacteria> getColony()
	{
		return colony;
	}
}
