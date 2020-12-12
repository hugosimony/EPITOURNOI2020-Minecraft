package fr.hugosimony.epitournoi2020.timers;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitRunnable;

import fr.hugosimony.epitournoi2020.Main;
import fr.hugosimony.epitournoi2020.State;
import fr.hugosimony.epitournoi2020.race.RacePlayer;
import fr.hugosimony.epitournoi2020.race.RaceState;
import fr.hugosimony.epitournoi2020.utils.Sounds;

public class StartingTimer extends BukkitRunnable {

	private int timer = 10;
	
	@Override
	public void run() {
		if(Main.main.state != State.STARTING) {
			Bukkit.broadcastMessage("§a[EPITOURNOI] §9Le lancement a été annulé !");
			this.cancel();
		}
		else {
			if(timer == 10 || (timer <= 5 && timer > 0)) {
				Sounds.playSound(Sound.ENTITY_ARROW_HIT_PLAYER);
				Bukkit.broadcastMessage("§a[EPITOURNOI] §9La partie commence dans " + timer + " seconde" + (timer == 1 ? "" : "s") + " !");
			}
			else if(timer == 0) {
				Sounds.playSound(Sound.ENTITY_PLAYER_LEVELUP);
				Bukkit.broadcastMessage("§a[EPITOURNOI] §9La partie commence !");
				Main.main.state = State.GAME;
				for(RacePlayer rplayer : Main.main.players)
					rplayer.raceState = RaceState.PVP;
				for(RacePlayer rplayer : Main.main.players) {
					rplayer.kills = 3;
					rplayer.checkKills();
				}
				GlobalTimer task = new GlobalTimer();
				task.runTaskTimer(Main.main, 0, 20);
				this.cancel();
			}
			timer--;
		}
	}

}
