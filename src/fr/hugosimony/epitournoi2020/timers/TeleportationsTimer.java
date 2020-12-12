package fr.hugosimony.epitournoi2020.timers;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitRunnable;

import fr.hugosimony.epitournoi2020.Main;
import fr.hugosimony.epitournoi2020.State;
import fr.hugosimony.epitournoi2020.race.Pvp;
import fr.hugosimony.epitournoi2020.utils.Sounds;

public class TeleportationsTimer extends BukkitRunnable {

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
				Bukkit.broadcastMessage("§a[EPITOURNOI] §9Les téléportations commencent dans " + timer + " seconde" + (timer == 1 ? "" : "s") + " !");
			}
			else if(timer == 0) {
				Sounds.playSound(Sound.ENTITY_PLAYER_LEVELUP);
				Bukkit.broadcastMessage("§a[EPITOURNOI] §9Les téléportations commencent !");
				try {
					Pvp.teleportPlayers();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.cancel();
			}
			timer--;
		}
	}

}

