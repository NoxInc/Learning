package net.noxinc.world;

import net.noxinc.world.cells.Cell;

public class Map 
{
	private Cell[][] board;
	private String name;
	
	public Map()
	{
		this(MapHelper.randomMapName(), 10, 10);
	}
	
	public Map(String name)
	{
		this(name, 10, 10);
	}
	
	public Map(String name, int x, int y)
	{
		board = new Cell[y][x];
		this.name = name;
	}
	
	public String getMapName()
	{
		return name;
	}
}
