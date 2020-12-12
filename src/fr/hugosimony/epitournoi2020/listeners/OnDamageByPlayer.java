package fr.hugosimony.epitournoi2020.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import fr.hugosimony.epitournoi2020.Main;
import fr.hugosimony.epitournoi2020.race.RacePlayer;
import fr.hugosimony.epitournoi2020.race.RaceState;
import fr.hugosimony.epitournoi2020.utils.Utils;

public class OnDamageByPlayer implements Listener {

	@EventHandler
	public void onPvp(EntityDamageByEntityEvent event) {
		Entity entity = event.getEntity();
		if (entity instanceof Player && event.getDamager() instanceof Player) {
			Player player = (Player) event.getEntity();
			Player damager = (Player) event.getDamager();
			RacePlayer rplayer = Utils.getRacePlayer(player);
			RacePlayer rdamager = Utils.getRacePlayer(damager);
			if(rplayer != null && rplayer.raceState == RaceState.PVP && rdamager != null && rdamager.raceState == RaceState.PVP) {
				if(rdamager.cooldown)
					event.setCancelled(true);
				else if(event.getDamage() >= player.getHealth()) {
					event.setCancelled(true);
					rplayer.cooldown = true;
					Bukkit.getScheduler().runTaskLater(Main.main, () -> {rplayer.cooldown = false;},60);
					player.teleport(new Location(player.getWorld(), rplayer.xRespawn, 22, rplayer.zRespawn));
					player.setHealth(20);
					damager.sendMessage("§a[EPITOURNOI] §9Vous avez tué §6" + player.getName() + "§9 !");
					rdamager.kills++;
					rdamager.checkKills();
				}
			}
		}
	}
	
}
