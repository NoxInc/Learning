package net.noxinc.units;

import net.noxinc.inventory.Inventory;
import net.noxinc.world.Map;
import net.noxinc.world.cells.Cell;

public class Player extends Cell
{
	private int x;
	private int y;
	private int health;
	private int facing;
	private Inventory inventory;
	private Map map;
	
	public Player(Map map, int x, int y)
	{
		super('P', "Player1");
		spawnPlayer(map, x, y);
		health = 10;
		this.x = x;
		this.y = y;
		this.map = map;
		inventory = new Inventory(5);
	}
	
	private void spawnPlayer(Map map, int x, int y)
	{
		map.createCellAtLocation(this, x, y);
	}
	
	public void moveTo(int offsetX, int offsetY)
	{
		if(offsetX == 0 && offsetY == -1)
		{
			this.facing = 1;
		}else if(offsetX == 0 && offsetY == 1)
		{
			this.facing = 2;
		}else if(offsetX == 1 && offsetY == 0)
		{
			this.facing = 3;
		}else if(offsetX == -1 && offsetY == 0)
		{
			this.facing = 4;
		}else{
			System.out.println("Invalid movement" + facing + " " + offsetX + " " + offsetY);
		}
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
				map.drawMap(this);
			}
		}else{
			System.out.println("Reached end of map");
		}
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public int getFacing()
	{
		return facing;
	}
	
	public Inventory getInventory()
	{
		return inventory;
	}
	
	public void setHealth(int hp)
	{
		health = hp;
	}
}
