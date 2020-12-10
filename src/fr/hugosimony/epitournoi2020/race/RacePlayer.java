package fr.hugosimony.epitournoi2020.race;

import org.bukkit.entity.Player;

public class RacePlayer {

	public Player player;
	public RaceState raceState;
	public int jumpCheckpoint;
	
	public RacePlayer(Player player) {
		this.player = player;
		raceState = RaceState.JUMP;
		jumpCheckpoint = 1;
	}
	
}
