package net.noxinc.units;

import net.noxinc.world.Map;
import net.noxinc.world.Location;


public class Player {
    
	//the map the player is currently in
    private Map map;
	
	//the player's current position
    private int x;
    private int y;
	
	//the health of the player, if this runs out the player dies
    private int health;
    
	
    public Player(Map map, int x, int y) {
        warpTo(map, x, y);
        health = 10;
    }
    
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
	//print out the map the player is currently in, as well as printing out the player in that map
    public void printInMap() {
        map.printMap(this);
    }
    
	//move the player compared to its current location
    public void movePlayer(int offsetX, int offsetY) {
		//get the Location we want to go to
        Location moveTo = map.getLocationAtPosition(x + offsetX, y + offsetY);
        
		//check if we can go to that location, if so go there
        if (moveTo != null && !moveTo.isSolid()) {
            x += offsetX;
            y += offsetY;
			
			//tell the Location that this player just arrives
            moveTo.onPlayerArrive(this);
        }else{
            System.out.println("Can't move there");
        }
    }
	
    //the player takes damage, ouch!
    public void decreaseHealth(int dmg) {
        health -= dmg;
		
		//if the player died, show that as a message
        if (isDead()) {
            System.out.println("You died");
        }
    }
    
	
    public boolean isDead() {
        return health <= 0;
    }
       
    public int getHealth() {
        return health;
    }
    
	//allows the player to warp to a specific position in a specific map
    public void warpTo(Map map, int x, int y) {
        this.map = map;
        this.x = x;
        this.y = y;
    }
}