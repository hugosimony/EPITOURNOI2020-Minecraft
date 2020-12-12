package fr.hugosimony.epitournoi2020.utils;

import org.bukkit.entity.Player;

import fr.hugosimony.epitournoi2020.Main;
import fr.hugosimony.epitournoi2020.race.RacePlayer;

public class Utils {

	public static boolean isPlayerLoggedin(Player player) {
		for(RacePlayer rplayer : Main.main.players) {
			if(rplayer.player.getName().equals(player.getName()))
				return true;
		}
		return false;
	}
	
	public static RacePlayer getRacePlayer(Player player) {
		RacePlayer rplayer = null;
		for(RacePlayer rplayer_ : Main.main.players) {
			if(rplayer_.player.getName().equals(player.getName()))
				rplayer = rplayer_;
		}
		return rplayer;
	}
	
	public static boolean isIn(double xmin, double xmax, double ymin, double ymax, double zmin, double zmax, double x, double y, double z) {
		return xmin <= x && xmax >= x && ymin <= y && ymax >= y && zmin <= z && zmax >= z;
	}
	
}
