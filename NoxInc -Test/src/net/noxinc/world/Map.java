package net.noxinc.world;

public class Map 
{
	private Cell[][] board;
	
	public Map(int x, int y)
	{
		board = new Cell[y][x];
		createMap();
	}
	
	public Map()
	{
		board = new Cell[5][5];
		createMap();
	}
	
	public void drawMap()
	{
		String tmp = "";
		for(int x = 0; x < board.length; x++)
		{
			for(int y = 0; y < board[x].length; y++)
			{
				if(board[x][y] == null)
				{
					tmp += ".";
				}else{
					tmp += board[x][y].getSymbol();
				}
			}
			tmp += "\n";
		}
		System.out.println(tmp);
	}
	
	public void createMap()
	{
		for(int x = 1; x < board.length - 1; x++)
		{
			for(int y = 1; y < board[x].length - 1; y++)
			{
				createCellAtLocation(new Cell(' '),x , y);
			}
		}
	}
	
	public void createCellAtLocation(Cell cell, int x, int y)
	{
		board[x][y] = cell;
	}

}
