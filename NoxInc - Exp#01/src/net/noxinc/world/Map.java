package net.noxinc.world;

import net.noxinc.world.cells.Cell;

public class Map 
{
	private Cell[][] board;
	
	public Map(int x)
	{
		board = new Cell[x][x];
		init();
	}
	
	public void setCell(Cell cell, int x, int y)
	{
		board[y][x] = cell;
	}
	
	public Cell getCell(int x, int y)
	{
		return board[y][x];
	}
	
	public void update()
	{
		String tmp = "";
		
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[i].length; j++)
			{
				if(board[i][j] == null)
				{
					tmp += ".";
				}else{
					tmp += board[i][j].getSymbol();
				}
			}
			tmp += "\n";
		}
		
		System.out.println(tmp);
	}

	private void init()
	{
		for(int i = 1; i < board.length - 1; i++)
		{
			for(int j = 1; j < board[i].length - 1; j++)
			{
				board[i][j] = new Cell();
			}
		}
	}
}
