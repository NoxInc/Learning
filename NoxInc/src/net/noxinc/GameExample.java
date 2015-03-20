package net.noxinc;

import java.util.Scanner;
import net.noxinc.world.Map;
import net.noxinc.world.Location;
import net.noxinc.units.Player;


public class GameExample {
    

    public static void main(String[] args) 
    {
        Scanner myScanner = new Scanner(System.in);
        Map map = new Map(30, 10);
        Player player = new Player(map, 2, 2);

        map.createOpenMap();
        
        map.setLocation(5, 5, new Location('x').setDamage(3));
        map.setLocation(20, 5, new Location('x').setDamage(10));
        map.setLocation(10, 8, new Location('x').setDamage(3));
        
        Map house = new Map(9, 9);
        house.createOpenMap();
        
        map.setLocation(8, 0, new Location('O').setWarpZone(house, 4, 7));
        
        house.setLocation(4, 8, new Location('O').setWarpZone(map, 8, 1));
        
        house.setLocation(4, 1, new Location('H').setDamage(-10));
         
        while (!player.isDead()) 
        {
            System.out.println("Current health: " + player.getHealth());
            
            player.printInMap();
        
            System.out.println("Where would you like to go?");
            System.out.println("1. Up");
            System.out.println("2. Left");
            System.out.println("3. Down");
            System.out.println("4. Right");
            
            switch(myScanner.nextInt()) {
                case 1:
                    player.movePlayer(0, -1);
                    break;
                case 2:
                    player.movePlayer(-1, 0);
                    break;
                case 3:
                    player.movePlayer(0, 1);
                    break;
                case 4:
                    player.movePlayer(1, 0);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
    
}