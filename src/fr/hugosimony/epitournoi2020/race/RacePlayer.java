package fr.hugosimony.epitournoi2020.race;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import fr.hugosimony.epitournoi2020.Main;
import fr.hugosimony.epitournoi2020.RaceScoreboard;

public class RacePlayer {
	
	public static final int neededKills = 3;

	public Player player;
	public RaceState raceState;
	public boolean teleported;
	public boolean cooldown;
	public int kills;
	public int xRespawn;
	public int zRespawn;
	public int jumpCheckpoint;
	public boolean[] craftsDone;
	public boolean[] elytraCheckpoints;
	public int countElytraCp;
	public int time;
	public int timePvp;
	public int timeJump;
	public int timeCraft;
	public int timeElytra;
	public boolean finished;
	
	public RacePlayer(Player player) {
		this.player = player;
		raceState = RaceState.WAITING;
		time = 0;
		timePvp = 0;
		timeJump = 0;
		timeCraft = 0;
		timeElytra = 0;
		teleported = false;
		cooldown = false;
		kills = 0;
		jumpCheckpoint = 1;
		craftsDone = new boolean[9];
		for(int i = 0; i < craftsDone.length; i++)
			craftsDone[i] = false;
		countElytraCp = 0;
		elytraCheckpoints = new boolean[71];
		elytraCheckpoints[0] = true;
		for(int i = 1; i < elytraCheckpoints.length; i++)
			elytraCheckpoints[i] = false;
		finished = false;
	}
	
	public void checkKills() {
		if(kills == neededKills) {
			player.sendMessage("§a[EPITOURNOI] §9Bravo vous avez fini l'épreuve de PVP !\n"
					+ "§9Vous passez désormais à l'épreuve de jump.");
			raceState = RaceState.JUMP;
			player.setHealth(20);
			// Clear
			clear();
			player.teleport(Jump.getGoodCheckpoint(1));
			Main.hidePlayers(player);
			RacePlayer rp = Pvp.getLastPlayer();
			if(rp != null) {
				rp.player.sendMessage("§a[EPITOURNOI] §9Vous êtes le dernier à l'épreuve de PVP. Vous serez téléporté dans 30 secondes.");
				Bukkit.getScheduler().runTaskLater(Main.main, () -> {
					if(rp.raceState == RaceState.PVP) {
						rp.raceState = RaceState.JUMP;
						rp.clear();
						rp.player.teleport(Jump.getGoodCheckpoint(1));
						rp.player.sendMessage("§a[EPITOURNOI] §9Bravo vous avez fini l'épreuve de PVP !\n"
								+ "§9Vous passez désormais à l'épreuve de jump.");
						Main.hidePlayers(rp.player);
					}
				},600);
			}
		}
	}

	public void checkCrafts() {
		int i = 0; for(; i < craftsDone.length && craftsDone[i]; i++);
		if(i == craftsDone.length) {
			player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 50, 20);
			player.sendMessage("§a[EPITOURNOI] §9Bravo vous avez fini l'épreuve de craft !\n"
					+ "§9Vous passez désormais à l'épreuve d'elytra.");
			player.teleport(Elytra.eltyraLocation);
			raceState = RaceState.ELYTRA;
			clear();
			player.getInventory().setChestplate(new ItemStack(Material.ELYTRA));
			player.getInventory().addItem(new ItemStack(Material.FIREWORK, 40));
		}
	}
	
	public void setElytraCheckpoint(int cp) {
		player.playSound(player.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 50, 20);
		elytraCheckpoints[cp] = true;
		countElytraCp++;
		if(countElytraCp == 70) {
			player.sendMessage("§a[EPITOURNOI] §9Bravo vous avez fini l'épreuve d'Elytra !");
			Bukkit.broadcastMessage("§a[EPITOURNOI] §6" + player.getName() + " a fini la course !");
			player.setGameMode(GameMode.SPECTATOR);
			Main.showPlayers(player);
			raceState = RaceState.END;
			finished = true;
		}
		RaceScoreboard.updateScoreBoard();
	}
	
	public void clear() {
		player.getInventory().clear();
		player.getInventory().setHelmet(null);
		player.getInventory().setChestplate(null);
		player.getInventory().setLeggings(null);
		player.getInventory().setBoots(null);
	}
	
	public static void clear(Player player) {
		player.getInventory().clear();
		player.getInventory().setHelmet(null);
		player.getInventory().setChestplate(null);
		player.getInventory().setLeggings(null);
		player.getInventory().setBoots(null);
	}
	
	public static int[] getStatusOfRacePlayers() {
		int[] status = {0, 0, 0, 0, 0};
		for(RacePlayer rplayer : Main.main.players) {
			if(rplayer.raceState == RaceState.PVP)
				status[0]++;
			else if(rplayer.raceState == RaceState.JUMP)
				status[1]++;
			else if(rplayer.raceState == RaceState.CRAFT)
				status[2]++;
			else if(rplayer.raceState == RaceState.ELYTRA)
				status[3]++;
			else if(rplayer.raceState == RaceState.END)
				status[4]++;
		}
		return status;
	}
}
