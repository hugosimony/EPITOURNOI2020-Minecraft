package fr.hugosimony.epitournoi2020.timers;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import fr.hugosimony.epitournoi2020.Main;
import fr.hugosimony.epitournoi2020.RaceScoreboard;
import fr.hugosimony.epitournoi2020.race.RacePlayer;
import fr.hugosimony.epitournoi2020.race.RaceState;

public class GlobalTimer extends BukkitRunnable {

	@Override
	public void run() {
		if(Main.main.time >= 1799) { // 30 minutes
			Bukkit.broadcastMessage("§a[EPITOURNOI] §9Fin de la course !");
			this.cancel();
		}
		Main.main.time++;
		for(RacePlayer rplayer : Main.main.players) {
			if(!rplayer.finished) {
				if(rplayer.raceState == RaceState.PVP)
					rplayer.timePvp++;
				else if(rplayer.raceState == RaceState.JUMP)
					rplayer.timeJump++;
				else if(rplayer.raceState == RaceState.CRAFT)
					rplayer.timeCraft++;
				else if(rplayer.raceState == RaceState.ELYTRA)
					rplayer.timeElytra++;
				rplayer.time++;
			}
		}
		RaceScoreboard.updateScoreBoard();
	}

}
