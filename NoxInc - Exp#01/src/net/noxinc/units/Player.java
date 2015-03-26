package net.noxinc.units;

import net.noxinc.world.Map;

public class Player 
{
	private Map map;
	private int x;
	private int y;
	
	public Player(Map map, int x, int y)
	{
		this.map = map;
		this.x = x;
		this.y = y;
		map.registerPlayer(this);
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
}
