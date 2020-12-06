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
	
}
