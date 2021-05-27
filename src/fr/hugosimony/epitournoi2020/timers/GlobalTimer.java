package fr.hugosimony.epitournoi2020.timers;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.hugosimony.epitournoi2020.Main;
import fr.hugosimony.epitournoi2020.RaceScoreboard;
import fr.hugosimony.epitournoi2020.race.Craft;
import fr.hugosimony.epitournoi2020.race.RacePlayer;
import fr.hugosimony.epitournoi2020.race.RaceState;

public class GlobalTimer extends BukkitRunnable {

	@Override
	public void run() {
		if(Main.main.time >= 1799) { // 30 minutes
			Bukkit.broadcastMessage("§a[EPITOURNOI] §9Fin de la course !");
			for(Player p : Bukkit.getOnlinePlayers()) {
				p.setGameMode(GameMode.SPECTATOR);
				RacePlayer.clear(p);
			}
			Main.makeLeaderboard();
			Main.printLeaderboard();
			Main.main.time = -1; // Just to be sure
			this.cancel();
		}
		else if(Main.main.time == 1199) {
			for(RacePlayer rplayer : Main.main.players) {
				if(rplayer.raceState == RaceState.JUMP) {
					rplayer.player.sendMessage("§a[EPITOURNOI] §9L'épreuve de jump est terminée.\n"
								+ "§9Vous passez désormais à l'épreuve de craft.");
					rplayer.raceState = RaceState.CRAFT;
					rplayer.player.teleport(Craft.craftLocation);
					Craft.resetCraft(rplayer);
				}
			}
		}
		Main.main.time++;
		for(RacePlayer rplayer : Main.main.players) {
			if(!rplayer.finished && rplayer.raceState != RaceState.ENDCRAFT && rplayer.raceState != RaceState.ENDELYTRA) {
				if(rplayer.time >= 1799) {
					rplayer.player.setGameMode(GameMode.SPECTATOR);
    				Main.showPlayers(rplayer.player);
    				if(rplayer.raceState == RaceState.CRAFT)
    					rplayer.raceState = RaceState.ENDCRAFT;
    				else if(rplayer.raceState == RaceState.ELYTRA)
    					rplayer.raceState = RaceState.ENDELYTRA;
    				rplayer.clear();
    				rplayer.time = 1800;
    				if(Main.isGameFinished())
    					Main.main.time = 1799;
				}
				else {
					if(rplayer.raceState == RaceState.PVP)
						rplayer.timePvp++;
					else if(rplayer.raceState == RaceState.JUMP) {
						rplayer.timeJump++;
						if(rplayer.timeJump == 600) {
							rplayer.player.sendMessage("§a[EPITOURNOI] §9L'épreuve de jump est terminée.\n"
									+ "§9Vous passez désormais à l'épreuve de craft.");
							rplayer.timeJump += 30 * (5 - rplayer.jumpCheckpoint);
							rplayer.time += 30 * (5 - rplayer.jumpCheckpoint);
							rplayer.raceState = RaceState.CRAFT;
							rplayer.player.teleport(Craft.craftLocation);
							Craft.resetCraft(rplayer);
						}
					}
					else if(rplayer.raceState == RaceState.CRAFT)
						rplayer.timeCraft++;
					else if(rplayer.raceState == RaceState.ELYTRA)
						rplayer.timeElytra++;
					rplayer.time++;
				}
			}
		}
		RaceScoreboard.updateScoreBoard();
	}

}
