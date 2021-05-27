package fr.hugosimony.epitournoi2020.listeners;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.hugosimony.epitournoi2020.Main;
import fr.hugosimony.epitournoi2020.RaceScoreboard;
import fr.hugosimony.epitournoi2020.State;
import fr.hugosimony.epitournoi2020.race.RacePlayer;
import fr.hugosimony.epitournoi2020.race.RaceState;
import fr.hugosimony.epitournoi2020.utils.Utils;

public class OnConnexion implements Listener {

	@EventHandler(priority = EventPriority.HIGH)
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		event.setJoinMessage("§a[+] §6" + player.getName());
		if(Main.main.state == State.WAITING && !Utils.isPlayerLoggedin(player)) {
			player.setGameMode(GameMode.ADVENTURE);
			player.teleport(Main.spawn);
			RacePlayer.clear(player);
		}
		else {
			/*
		    if(contains(Main.main.players, player))
		    	Main.main.players.add(findPlayer(player));
		    else {
		    	RacePlayer racePlayer = new RacePlayer(player);
		    	Main.main.players.add(racePlayer);
		    }*/
			RacePlayer racePlayer = Utils.getRacePlayer(player);
			if(racePlayer == null || racePlayer.finished) {
				for(RacePlayer rp : Main.main.players)
					rp.player.hidePlayer(player);
				player.setGameMode(GameMode.SPECTATOR);
				event.setJoinMessage(null);
			}
			else {
				player.setGameMode(GameMode.ADVENTURE);
				if(racePlayer.raceState != RaceState.PVP)
					Main.hidePlayers(player);
			}
		}
		
		RaceScoreboard sb = new RaceScoreboard(player);
		sb.sendLine();
		sb.set();
		RaceScoreboard.updateScoreBoard();
	}
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		event.setQuitMessage("§c[-] §6" + player.getName());
		RaceScoreboard.updateScoreBoard();
	}
	
	/*
	public boolean contains(ArrayList<RacePlayer> list, Player player) {
		boolean founded = false;
		for(RacePlayer p: list) {
			if(player.getName().equalsIgnoreCase(p.player.getName()))
				founded = true;
		}
		return founded;
	}
	
	public RacePlayer findPlayer(Player player) {
		
		RacePlayer p = null;
		for(RacePlayer player_: Main.main.players) {
			if(player_.player.getName().equalsIgnoreCase(player.getName())) {
				player_.player = player;
				p = player_;
			}
		}
		return p;
	}*/
}
