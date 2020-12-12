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
import fr.hugosimony.epitournoi2020.utils.Utils;

public class OnConnexion implements Listener {

	@EventHandler(priority = EventPriority.HIGH)
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		event.setJoinMessage("§a[+] §6" + player.getName());
		if(Main.main.state == State.WAITING && !Utils.isPlayerLoggedin(player)) {
			player.setGameMode(GameMode.ADVENTURE);
			player.teleport(Main.spawn);
		}
		else if(Utils.getRacePlayer(player) == null) {
			player.setGameMode(GameMode.SPECTATOR);
			event.setJoinMessage(null);
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
}
