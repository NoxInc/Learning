package net.noxinc.world.cells;

import net.noxinc.units.Player;
import net.noxinc.world.Map;

public class CellPotion extends Cell 
{
	private int healing;

	public CellPotion(Map map, int healing) {
		super('H', "", map);
		this.healing = healing;
		setCollectable();
		setMaxStackSize(5);
		setName("HP-Pot (" + healing + ")");
	}
	
	@Override
	public boolean use(Player player){
		player.modifyHpBy(5);
		return true;
	}

}
