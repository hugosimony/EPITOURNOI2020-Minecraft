package fr.hugosimony.epitournoi2020.listeners;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import fr.hugosimony.epitournoi2020.Main;
import fr.hugosimony.epitournoi2020.State;
import fr.hugosimony.epitournoi2020.race.Craft;
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
 						player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 50, 20);
 						player.sendMessage("§a[EPITOURNOI] §9Bravo vous avez fini le jump 1.");
 					}
 				}
 				// Level 2
 				else if(rplayer.jumpCheckpoint == 2) {
 					if(loc.getY() >= 18 && loc.getX() > 26 && loc.getX() < 30 && loc.getZ() < -29) {
 						rplayer.jumpCheckpoint++;
 	 					player.teleport(Jump.getGoodCheckpoint(3));
 						player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 50, 20);
 						player.sendMessage("§a[EPITOURNOI] §9Bravo vous avez fini le jump 2.");
 					}
 				}
 				// Level 3
 				else if(rplayer.jumpCheckpoint == 3) {
 					if(loc.getY() >= 19 && loc.getX() > 46 && loc.getX() < 50 && loc.getZ() < -29) {
 						rplayer.jumpCheckpoint++;
 	 					player.teleport(Jump.getGoodCheckpoint(4));
 						player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 50, 20);
 						player.sendMessage("§a[EPITOURNOI] §9Bravo vous avez fini le jump 3.");
 					}
 				}
 				// Level 4
 				else if(rplayer.jumpCheckpoint == 4) {
 					if(loc.getY() >= 20 && loc.getX() > 66 && loc.getX() < 70 && loc.getZ() < -29) {
 						rplayer.jumpCheckpoint++;
 	 					player.teleport(Jump.getGoodCheckpoint(5));
 						player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 50, 20);
 						player.sendMessage("§a[EPITOURNOI] §9Bravo vous avez fini le jump 4.");
 					}
 				}
 				// Level 5
 				else if(rplayer.jumpCheckpoint == 5) {
 					if(loc.getY() >= 20 && loc.getX() > 86 && loc.getX() < 90 && loc.getZ() < -29) {
 						player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 50, 20);
 						player.sendMessage("§a[EPITOURNOI] §9Bravo vous avez fini le jump 5.");
 						player.sendMessage("§a[EPITOURNOI] §9Bravo vous avez fini l'épreuve de jump !\n"
 								+ "§9Vous passez désormais à l'épreuve de craft.");
 						rplayer.raceState = RaceState.CRAFT;
 						rplayer.player.teleport(Craft.craftLocation);
 						Craft.resetCraft(rplayer);
 					}
 				}
 			}
 			else if(rplayer.raceState == RaceState.ELYTRA) {
 				if(player.getLocation().getY() < 0)
 					player.teleport(Elytra.eltyraLocation);
 				Elytra.checkCheckpoints(rplayer, loc.getX(), loc.getY(), loc.getZ());
 			}
 		}
	}
	
}
