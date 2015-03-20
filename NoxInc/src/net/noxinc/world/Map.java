package net.noxinc.world;

import net.noxinc.units.Player;

public class Map {
 
	//all the locations
    private Location[][] board;
    
	//create a map with the given size
    public Map(int width, int height) 
    {
        board = new Location[height][width];
    }
    
	//constructor that creates a map with the default size
    public Map() 
    {
		//call the other constructor, it will do the work
        this(10, 10);
    }
    
	//get the Location at a specific position
    public Location getLocationAtPosition(int x, int y) 
    {
        if (x < 0 || y < 0 || y >= board.length || x >= board[y].length) {
            return null;
        }else{
            return board[y][x];
        }
    }
    
	//set the Location at a specific position
    public void setLocation(int x, int y, Location location) {
        if (x >= 0 && y >= 0 && y < board.length && x < board[y].length) {
            board[y][x] = location;
        }
    }
    
	//print the map and the player inside the map
    public void printMap(Player player) {
        String boardText = "";
        
		//loop through all the locations in the map
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
			
                if (player.getX() == x && player.getY() == y) {
					//the player
                    boardText += "P";
                }else{
                    Location location = board[y][x];
                    
                    if (location == null) {
                        //no location exist
                        boardText += '.';
                    }else{
                        //print the symbol for the specific location
                        boardText += location.getSymbol();
                    }
                }
            }
            boardText += "\n";
        }
        
        System.out.print(boardText);
    }
    
	//creates an empty map with a border around it
    public void createOpenMap() {
        for (int y = 1; y < board.length - 1; y++) {
            for (int x = 1; x < board[y].length - 1; x++) {
                board[y][x] = new Location(' ');
            }
        }
    }
}