package net.noxinc.world;

import net.noxinc.units.Player;
import net.noxinc.world.cells.Cell;

public class Map 
{
	private Player player;
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
		createBoard();
	}
	
	public void updateMap()
	{
		//----MAP----\\
		String tmp = "";
		for(int y = 0; y < board.length; y++)
		{
			for(int x = 0; x < board[y].length; x++)
			{
				if(board[y][x] == null)
				{
					tmp += '.';
				}else{
					if(player.getX() == x && player.getY() == y)
					{
						tmp += 'P';
					}else{
						tmp += board[y][x].getSymbol();
					}
				}
			}
			
			//----HUD----\\
			switch(y)
			{
			case 0:
				tmp += "  " + "__________";
				break;
			case 1:
				tmp += " |" + "Health: " + player.getHealth();
				break;
			case 2:
				tmp += " |" + "Inventory:|";
				int counter = 1;
				for(int i = 0; i <  player.getInventory().getMaxSlots(); i++)
				{
					if(i < player.getInventory().getSize())
					{
						tmp += player.getInventory().getSymbolFromIndex(i) + "|";
					}else{
						tmp += "" + counter + "|";
					}
					counter++;
				}
			}
			if(!(y < y - 1))
			{
				tmp += "\n";
			}
		}
		System.out.print(tmp + "\n");
	}
	
	public void registerPlayer(Player player)
	{
		this.player = player;
	}
	
	private void createBoard()
	{
		for(int y = 1; y < board.length - 1; y++)
		{
			for(int x = 1; x < board[y].length - 1; x++)
			{
				board[y][x] = new Cell(' ', "Air", this);
			}
		}
	}
	
	public void setCell(Cell cell, int x, int y)
	{
		cell.setX(x);
		cell.setY(y);
		board[y][x] = cell;
	}
	
	public Cell getCell(int x, int y)
	{
		return board[y][x];
	}
	
	public String getMapName()
	{
		return name;
	}
	
	public int getMapX()
	{
		return board.length;
	}
	
	public int getMapY()
	{
		return board[getMapX() - 1].length;
	}
}
