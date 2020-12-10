package fr.hugosimony.epitournoi2020.race;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Jump {
	
	public static final Location checkpoint1 = new Location(Bukkit.getWorld("world"), 8.5, 4, -9.5, -180, 0);
	public static final Location checkpoint2 = new Location(Bukkit.getWorld("world"), 28.5, 4, -9.5, -180, 0);
	public static final Location checkpoint3 = new Location(Bukkit.getWorld("world"), 48.5, 4, -9.5, -180, 0);
	public static final Location checkpoint4 = new Location(Bukkit.getWorld("world"), 68.5, 4, -9.5, -180, 0);
	public static final Location checkpoint5 = new Location(Bukkit.getWorld("world"), 88.5, 4, -9.5, -180, 0);
	
	public static Location getGoodCheckpoint(int checkpoint) {
		if(checkpoint == 1)
			return checkpoint1;
		if(checkpoint == 2)
			return checkpoint2;
		if(checkpoint == 3)
			return checkpoint3;
		if(checkpoint == 4)
			return checkpoint4;
		return checkpoint5;		
	}
}
