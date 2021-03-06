package cc.co.evenprime.bukkit.nocheat.data;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import cc.co.evenprime.bukkit.nocheat.NoCheatData;

public class SpeedhackData {

	public int lastCheckTicks = 0; // timestamp of last check for speedhacks
	public Location setBackPoint = null;
	public int eventsSinceLastCheck = 0; // used to identify speedhacks
	public final int violationsInARow[] =  { 0, 0, 0 };
	public int violationsInARowTotal = 0;

	public static SpeedhackData get(Player p) {

		NoCheatData data = NoCheatData.getPlayerData(p);

		if(data.speedhack == null) {
			data.speedhack = new SpeedhackData();
		}

		return data.speedhack;
	}
}
