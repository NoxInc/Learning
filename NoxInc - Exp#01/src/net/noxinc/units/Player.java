package net.noxinc.units;

import net.noxinc.world.Map;
import net.noxinc.world.cells.Cell;

public class Player 
{
	private Map map;
	private String name;
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
	
	public void moveTo(int oX, int oY, int facingDirection)
	{
		this.facingDirection = facingDirection;
		if(!(x + oX < 1 || x + oX > map.getMapX() - 2) && !(y + oY < 1 || y + oY > map.getMapY() - 2))
		{
			if(map.getCell(x + oX, y + oY).isCollectable())
			{
				map.setCell(new Cell(' ', "Air"), x + oX, y + oY);
			}
			x += oX;
			y += oY;
		}
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
