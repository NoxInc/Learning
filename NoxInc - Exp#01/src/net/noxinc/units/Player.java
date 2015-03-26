package net.noxinc.units;

import java.util.Scanner;

import net.noxinc.units.inventory.Inventory;
import net.noxinc.world.Map;
import net.noxinc.world.cells.Cell;

public class Player 
{
	private Map map;
	private String name;
	private Inventory inventory = new Inventory(5, this);
	private int health = 10;
	private int facingDirection;
	private int x;
	private int y;
	private boolean isdead;
	
	public Player(String name, Map map, int x, int y)
	{
		this.map = map;
		this.name = name;
		this.x = x;
		this.y = y;
		map.registerPlayer(this);
	}
	
	private void moveTo(int oX, int oY, int facingDirection)
	{
		this.facingDirection = facingDirection;
		if(!(x + oX < 1 || x + oX > map.getMapX() - 2) && !(y + oY < 1 || y + oY > map.getMapY() - 2))
		{
			if(map.getCell(x + oX, y + oY).isCollectable())
			{
				inventory.addToInventory(map.getCell(x + oX, y + oY));
				map.setCell(new Cell(' ', "Air", map), x + oX, y + oY);
			}else{
				if(map.getCell(x + oX, y + oY).isSolid())
				{
					oX = 0;
					oY = 0;
				}
			}
			x += oX;
			y += oY;
		}
	}
	
	public void move(int direction, Scanner scanner)
	{
		switch(direction)
		{
		case 1:
			moveTo(0, -1, 1);
			break;
		case 2:
			moveTo(0, 1, 2);
			break;
		case 3:
			moveTo(1, 0, 3);
			break;
		case 4:
			moveTo(-1, 0, 4);
			break;
		case 5:
			mine(scanner.nextInt());
			break;
		case 6:
			inventory.open();
		}
	}
	
	private void mine(int direction)
	{
		switch(direction)
		{
		case 1:
			if(map.getCell(x, y - 1).isMineable())
				map.setCell(new Cell(' ', "Air", map), x, y - 1);
			break;
		case 2:
			if(map.getCell(x, y + 1).isMineable())
				map.setCell(new Cell(' ', "Air", map), x, y + 1);
			break;
		case 3:
			if(map.getCell(x + 1, y).isMineable())
				map.setCell(new Cell(' ', "Air", map), x + 1, y);
			break;
		case 4:
			if(map.getCell(x - 1, y).isMineable())
				map.setCell(new Cell(' ', "Air", map), x - 1, y);
			break;
		}
	}
	
	public void modifyHpBy(int amount)
	{
		health += amount;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public Map getMap()
	{
		return map;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public int getFacingDirection()
	{
		return facingDirection;
	}
	
	public boolean isDead()
	{
		return isdead;
	}
	
	public void setDead()
	{
		isdead = true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
