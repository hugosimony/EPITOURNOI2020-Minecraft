package fr.hugosimony.epitournoi2020.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import fr.hugosimony.epitournoi2020.race.RacePlayer;
import fr.hugosimony.epitournoi2020.race.RaceState;
import fr.hugosimony.epitournoi2020.utils.Utils;

public class OnDamageAndFood implements Listener {

	@EventHandler
	public void onEntityDamaged(EntityDamageEvent event) {
		Entity entity = event.getEntity();
		if (entity instanceof Player) {
			Player player = (Player) event.getEntity();
			RacePlayer rplayer = Utils.getRacePlayer(player);
			if(rplayer == null || rplayer.raceState != RaceState.PVP || rplayer.cooldown)
				event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onFoodChanged(FoodLevelChangeEvent event) {
		event.setCancelled(true);
	}
	
}
