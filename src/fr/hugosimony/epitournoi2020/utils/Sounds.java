package fr.hugosimony.epitournoi2020.utils;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

import fr.hugosimony.epitournoi2020.Main;
import fr.hugosimony.epitournoi2020.race.RacePlayer;

public class Sounds {
	
	public static void playSound(Sound sound) {
		for(RacePlayer racePlayer : Main.main.players) {
			Player player = racePlayer.player;
			player.playSound(player.getLocation(), sound, 50, 20);
		}
	}
	
}
