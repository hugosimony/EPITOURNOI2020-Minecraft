package fr.hugosimony.epitournoi2020.race;

import java.util.Collections;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import fr.hugosimony.epitournoi2020.Main;
import fr.hugosimony.epitournoi2020.State;
import fr.hugosimony.epitournoi2020.timers.StartingTimer;

public class Pvp {
	
	private static final int minX = 9;
	private static final int minZ = 18;
	
	// 36 players maximum !
	public static void teleportPlayers() throws InterruptedException {
		World wolrd = Bukkit.getWorld("world");
		int len = Main.main.players.size();
		// Randomize spawn
		Collections.shuffle(Main.main.players);
		// Teleportations
		int x = 0;
		int y = 0;
		for(int i = 0; i < len && Main.main.state == State.STARTING; i++) {
			RacePlayer rplayer = Main.main.players.get(i);
			Player player = rplayer.player;
			Bukkit.broadcastMessage("§a[EPITOURNOI] §9Téléportation de §6" + player.getName() + "§9.");
			rplayer.xRespawn = minX + 35-(x*7);
			rplayer.zRespawn = minZ + 35-(y*7);
			x++;
			if(x > 6) {
				x = 0;
				y++;
			}
			player.teleport(new Location(wolrd, rplayer.xRespawn, 22, rplayer.zRespawn, -90, -90));
			rplayer.teleported = true;
			// Inventory
			PlayerInventory inv = player.getInventory();
			inv.setHelmet(new ItemStack(Material.IRON_HELMET));
			inv.setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
			inv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
			inv.setBoots(new ItemStack(Material.IRON_BOOTS));
			inv.setItem(0, new ItemStack(Material.IRON_SWORD));
			if(i < len - 1)
			Thread.sleep(500);
		}
		StartingTimer task = new StartingTimer();
		task.runTaskTimer(Main.main, 0, 20);
	}
	
	public static RacePlayer getLastPlayer() {
		int count = 0;
		RacePlayer rp = null;
		for(RacePlayer rplayer : Main.main.players) {
			if(rplayer.raceState == RaceState.PVP) {
				if(count!=0)
					return null;
				rp = rplayer;
				count++;
			}
		}
		return rp;
	}
	
}
