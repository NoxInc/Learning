package net.noxinc.units;

import net.noxinc.world.Map;

public class Player 
{
	private Map map;
	private int facingDirection;
	private int x;
	private int y;
	private boolean isdead;
	
	public Player(Map map, int x, int y)
	{
		this.map = map;
		this.x = x;
		this.y = y;
		map.registerPlayer(this);
	}
	
	public void moveTo(int oX, int oY, int facingDirection)
	{
		this.facingDirection = facingDirection;
		if(!(x + oX < 1 || x + oX > map.getMapX() - 2) && !(y + oY < 1 || y + oY > map.getMapY() - 2))
		{
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
}
