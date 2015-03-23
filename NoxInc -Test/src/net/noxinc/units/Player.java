package net.noxinc.units;

import net.noxinc.world.Cell;
import net.noxinc.world.Map;

public class Player extends Cell
{
	private int x;
	private int y;
	private Map map;
	private int health;
	
	public Player(Map map, int x, int y)
	{
		super('P', "Player1");
		spawnPlayer(map, x, y);
		health = 10;
		this.x = x;
		this.y = y;
		this.map = map;
	}
	
	private void spawnPlayer(Map map, int x, int y)
	{
		map.createCellAtLocation(this, x, y);
	}
	
	public void moveTo(int offsetX, int offsetY)
	{
		if((!(x + offsetX > map.getYLength() - 1 || x + offsetX < 0) && !(y + offsetY > map.getXLength() - 1 || y + offsetY < 0)))
		{
			if(map.getCellAtPosition(x + offsetX, y + offsetY) == null || map.getCellAtPosition(x + offsetX, y + offsetY).isSolid())
			{
				System.out.println("Can't move. Border/Solid");
			}
			else
			{
				map.getCellAtPosition(x + offsetX, y + offsetY).onArrival(this);
				map.createCellAtLocation(this, x + offsetX, y + offsetY);
				map.createCellAtLocation(new Cell(' ', ""), x, y);
				x += offsetX;
				y += offsetY;
			}
		}else{
			System.out.println("Reached end of map");
		}
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public void setHealth(int hp)
	{
		health = hp;
	}
}
