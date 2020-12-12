package fr.hugosimony.epitournoi2020.listeners;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.hugosimony.epitournoi2020.race.Craft;
import fr.hugosimony.epitournoi2020.race.RacePlayer;
import fr.hugosimony.epitournoi2020.utils.Utils;

public class OnCraft implements Listener {

	@EventHandler
    public void onCraft(CraftItemEvent event){
		ItemStack item = event.getInventory().getResult();
		if(item != null) {
			Player player = (Player) event.getWhoClicked();
			RacePlayer rplayer = Utils.getRacePlayer(player);
			if(rplayer != null) {
				if(Craft.checkCraft(rplayer, item)) {
					rplayer.checkCrafts();
					player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 50, 20);
					ItemMeta itemMeta = item.getItemMeta();
					itemMeta.setDisplayName("§aItem terminé !");
					item.setItemMeta(itemMeta);
				}
			}
		}
	}
	
}
