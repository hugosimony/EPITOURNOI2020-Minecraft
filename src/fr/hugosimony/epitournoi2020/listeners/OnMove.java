package fr.hugosimony.epitournoi2020.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import fr.hugosimony.epitournoi2020.Main;
import fr.hugosimony.epitournoi2020.State;
import fr.hugosimony.epitournoi2020.race.Elytra;
import fr.hugosimony.epitournoi2020.race.Jump;
import fr.hugosimony.epitournoi2020.race.RacePlayer;
import fr.hugosimony.epitournoi2020.race.RaceState;
import fr.hugosimony.epitournoi2020.utils.Utils;

public class OnMove implements Listener {

	@EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
		
		Player player = event.getPlayer();
 		Location loc = player.getLocation();
 		RacePlayer rplayer = Utils.getRacePlayer(player);
 		
 		if(rplayer != null) {
 			
 			if(rplayer.raceState == RaceState.WAITING && Main.main.state == State.STARTING && rplayer.teleported)
 				event.setCancelled(true);
 			
 			if(rplayer.raceState == RaceState.JUMP) {
 				// Respawn if falling
 				if(loc.getY() < 3)
 					player.teleport(Jump.getGoodCheckpoint(rplayer.jumpCheckpoint));
 				// Level 1
 				if(rplayer.jumpCheckpoint == 1) {
 					if(loc.getY() >= 19 && loc.getX() > 6 && loc.getX() < 10 && loc.getZ() < -29) {
 						rplayer.jumpCheckpoint++;
 	 					player.teleport(Jump.getGoodCheckpoint(2));
 						player.sendMessage("GG LEVEL 1 DONE");
 					}
 				}
 				// Level 2
 				else if(rplayer.jumpCheckpoint == 2) {
 					if(loc.getY() >= 18 && loc.getX() > 26 && loc.getX() < 30 && loc.getZ() < -29) {
 						rplayer.jumpCheckpoint++;
 	 					player.teleport(Jump.getGoodCheckpoint(3));
 						player.sendMessage("GG LEVEL 2 DONE");
 					}
 				}
 				// Level 3
 				else if(rplayer.jumpCheckpoint == 3) {
 					if(loc.getY() >= 19 && loc.getX() > 46 && loc.getX() < 50 && loc.getZ() < -29) {
 						rplayer.jumpCheckpoint++;
 	 					player.teleport(Jump.getGoodCheckpoint(4));
 						player.sendMessage("GG LEVEL 3 DONE");
 					}
 				}
 				// Level 4
 				else if(rplayer.jumpCheckpoint == 4) {
 					if(loc.getY() >= 20 && loc.getX() > 66 && loc.getX() < 70 && loc.getZ() < -29) {
 						rplayer.jumpCheckpoint++;
 	 					player.teleport(Jump.getGoodCheckpoint(5));
 						player.sendMessage("GG LEVEL 4 DONE");
 					}
 				}
 				// Level 5
 				else if(rplayer.jumpCheckpoint == 5) {
 					if(loc.getY() >= 20 && loc.getX() > 86 && loc.getX() < 90 && loc.getZ() < -29) {
 						//rplayer.raceState = RaceState.CRAFT;
 						player.sendMessage("GG LEVEL 5 DONE");
 						rplayer.player.teleport(new Location(rplayer.player.getWorld(), -300, 104, -300));
 						rplayer.raceState = RaceState.ELYTRA;
 						rplayer.clear(rplayer.player);
 						rplayer.player.getInventory().setChestplate(new ItemStack(Material.ELYTRA));
 						rplayer.player.getInventory().addItem(new ItemStack(Material.FIREWORK, 40));
 					}
 				}
 			}
 			else if(rplayer.raceState == RaceState.ELYTRA) {
 				Elytra.checkCheckpoints(rplayer, loc.getX(), loc.getY(), loc.getZ());
 			}
 		}
	}
	
}
