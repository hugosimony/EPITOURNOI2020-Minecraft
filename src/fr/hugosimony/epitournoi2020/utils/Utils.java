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
	
}
