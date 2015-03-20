package net.noxinc.world;

import net.noxinc.units.Player;

public class Location { 
    
	//the symbol to be shown on the map
    private char symbol;
	
	//a solid location prevents the palyer to move there
    private boolean solid = false;
	
	//the damage the player takes from going to this location(only damages the player once)
    private int damage = 0;
	
	//the target fro a warp
    private Map warpToMap;
    private int warpToX;
    private int warpToY;
    
	
	//Create a new location
    public Location(char symbol) {
        this.symbol = symbol;
    }
    
    protected char getSymbol() {
        return symbol;
    }
    
	//set if it's solid or not, it returns the Location itself to be able to chain the methods together
    public Location setSolid(boolean value) {
        solid = value;
        
        return this;
    }
    
	//set the damage it deals, it returns the Location itself to be able to chain the methods together
    public Location setDamage(int value) {
        damage = value;
        
        return this;
    }
    
	//set the warp zone, it returns the Location itself to be able to chain the methods together
    public Location setWarpZone(Map map, int x, int y) {
        warpToMap = map;
        warpToX = x;
        warpToY = y;
        
        return this;
    }
    
    public boolean isSolid() {
        return solid;
    }
    
	//called when a player arrives at this location
    public void onPlayerArrive(Player player) {
        if (damage != 0) {
            player.decreaseHealth(damage);
            symbol = ' ';
            damage = 0;
        }
        
        if(warpToMap != null) {
            player.warpTo(warpToMap, warpToX, warpToY);
        }
    }
}