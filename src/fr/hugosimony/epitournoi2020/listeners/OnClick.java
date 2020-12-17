package fr.hugosimony.epitournoi2020.listeners;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.hugosimony.epitournoi2020.Main;
import fr.hugosimony.epitournoi2020.race.RacePlayer;
import fr.hugosimony.epitournoi2020.race.RaceState;
import fr.hugosimony.epitournoi2020.utils.Utils;
public class OnClick implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler(priority=EventPriority.HIGH)
	public void onPlayerUse(PlayerInteractEvent event){
	    Player player = event.getPlayer();
	    if((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) && player.getItemInHand().getType() == Material.FIREWORK){
	    	RacePlayer rplayer = Utils.getRacePlayer(player);
	    	if(rplayer != null && rplayer.raceState == RaceState.ELYTRA) {
	    		if(rplayer.countFirework >= 39) {
	    			ItemStack it = new ItemStack(Material.FIREWORK);
	    			it.setAmount(64);
	    			ItemMeta meta = it.getItemMeta();
	    			meta.setDisplayName("§c+ 10 Secondes");
	    			it.setItemMeta(meta);
	    			player.setItemInHand(it);
	    			if(rplayer.countFirework != 39) {
	    				rplayer.time+=10;
		    			if(rplayer.time > 17999) {
		    				rplayer.timeElytra += 17999 - rplayer.time - 10;
		    				rplayer.time = 17999;
		    				Main.main.playersDoneElytra.add(player.getName());
		    				player.setGameMode(GameMode.SPECTATOR);
		    				Main.showPlayers(player);
		    				rplayer.raceState = RaceState.END;
		    				rplayer.finished = true;
		    				rplayer.clear();
		    			}
		    			else
		    				rplayer.timeElytra += 10;
		    			player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_HURT, 50, 20);
	    			}
	    			rplayer.countFirework++;
	    		}
	    		else {
	    			player.getItemInHand().setAmount(40-rplayer.countFirework);
	    			rplayer.countFirework++;
	    		}
	    	}
	    }
	}
	
}
