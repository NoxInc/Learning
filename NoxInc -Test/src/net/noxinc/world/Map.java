package net.noxinc.world;

import net.noxinc.units.Player;
import net.noxinc.world.cells.Cell;

public class Map 
{
	private Cell[][] board;
	private int xLength;
	private int yLength;
	
	public Map(int x, int y)
	{
		board = new Cell[y][x];
		xLength = x;
		yLength = y;
		createMap();
	}
	
	public Map()
	{
		this(5, 5);
	}
	
	public void drawMap(Player player)
	{
		String tmp = "";
		for(int y = 0; y < board.length; y++)
		{
			for(int x = 0; x < board[y].length; x++)
			{
				if(board[y][x] == null)
				{
					tmp += ".";
				}else{
					if(board[y][x] instanceof Player)
					{
						tmp += "P";
					}else{
						tmp += board[y][x].getSymbol();
					}
				}
			}
			if(y == 0)
			{
				tmp += "  " + "___________";
			}else if(y == 1)
			{
				tmp += " |" + "Health: " +  player.getHealth();
			}else if(y == 2)
			{
				tmp += " |" + "Luck: ";
			}
			tmp += "\n";
		}
		System.out.println(tmp);
	}
	
	public void createMap()
	{
		for(int y = 1; y < board.length - 1; y++)
		{
			for(int x = 1; x < board[y].length - 1; x++)
			{
				createCellAtLocation(new Cell(' ', ""),x , y);
			}
		}
	}
	
	public void createCellAtLocation(Cell cell, int x, int y)
	{
		board[y][x] = cell;
	}
	
	public Cell getCellAtPosition(int x, int y)
	{
		return board[y][x];
	}
	
	public int getXLength()
	{
		return xLength;
	}
	
	public int getYLength()
	{
		return yLength;
	}

}
