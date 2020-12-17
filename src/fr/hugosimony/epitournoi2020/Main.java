package fr.hugosimony.epitournoi2020;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.hugosimony.epitournoi2020.commands.ModoCommand;
import fr.hugosimony.epitournoi2020.commands.PlayerCommand;
import fr.hugosimony.epitournoi2020.listeners.OnClick;
import fr.hugosimony.epitournoi2020.listeners.OnConnexion;
import fr.hugosimony.epitournoi2020.listeners.OnCraft;
import fr.hugosimony.epitournoi2020.listeners.OnDamageAndFood;
import fr.hugosimony.epitournoi2020.listeners.OnDamageByPlayer;
import fr.hugosimony.epitournoi2020.listeners.OnMove;
import fr.hugosimony.epitournoi2020.race.RacePlayer;
import fr.hugosimony.epitournoi2020.race.RaceState;

public class Main extends JavaPlugin {
	
	public static Main main;
	
	public static final Location spawn = new Location(Bukkit.getWorld("world"), 29, 24, 99, 180, 0);
	
	public State state;
	public boolean testingSolo;
	public ArrayList<RacePlayer> players = new ArrayList<RacePlayer>();
	public HashMap<Player, RaceScoreboard> scoreboard = new HashMap<Player, RaceScoreboard>();
	public ArrayList<String> playersDone = new ArrayList<String>();
	public ArrayList<String> timePlayersDone = new ArrayList<String>();
	public ArrayList<String> playersDoneElytra = new ArrayList<String>();
	public HashMap<Integer, String> leaderboard = new HashMap<Integer, String>();
	public int craft;
	public int time;
	public int rank;

	//**********************************************************************
	@Override
	public void onEnable() {
		System.out.println("Plugin EPITOURNOI 2020 started");
		
		main = this;
		
		state = State.WAITING;
		
		testingSolo = false;
		craft = 1;
		
		time = 0;
		rank = 1;
		
		// Listeners
		
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new OnMove(), this);
		pm.registerEvents(new OnDamageAndFood(), this);
		pm.registerEvents(new OnDamageByPlayer(), this);
		pm.registerEvents(new OnConnexion(), this);
		pm.registerEvents(new OnCraft(), this);
		pm.registerEvents(new OnClick(), this);
		pm.registerEvents(new Weather(), this);
		
		// Commandes :
		getCommand("say").setExecutor(new ModoCommand());
		getCommand("start").setExecutor(new ModoCommand());
		getCommand("login").setExecutor(new PlayerCommand());
		getCommand("reset").setExecutor(new PlayerCommand());
		
	}
	
	@Override
	public void onDisable() {
		System.out.println("Plugin EPITOURNOI 2020 finished");
	}
	
	//**********************************************************************
	// Globlal functions
	
	public static boolean isGameFinished() {
		for(RacePlayer rplayer : Main.main.players)
			if(!rplayer.finished) return false;
		return true;
	}
	
	public static void hidePlayers(Player player) {
		for(RacePlayer rplayer : Main.main.players) {
			if(!rplayer.player.getName().equals(player.getName()))
				player.hidePlayer(rplayer.player);
		}
	}
	
	public static void showPlayers(Player player) {
		for(RacePlayer rplayer : Main.main.players) {
			if(!rplayer.player.getName().equals(player.getName()))
				player.showPlayer(rplayer.player);
		}
	}
	
	public static void makeLeaderboard() {
		for(RacePlayer rplayer : Main.main.players) {
			if(rplayer.raceState == RaceState.ELYTRA) {
				if(Main.main.leaderboard.containsKey(70 - rplayer.countElytraCp))
					Main.main.leaderboard.put(70 - rplayer.countElytraCp, Main.main.leaderboard.get(70 - rplayer.countElytraCp) + " " + rplayer.player.getName());
				else
					Main.main.leaderboard.put(70 - rplayer.countElytraCp, rplayer.player.getName());
			}
			else if(rplayer.raceState == RaceState.CRAFT) {
				if(Main.main.leaderboard.containsKey(71))
					Main.main.leaderboard.put(71, Main.main.leaderboard.get(71) + " " + rplayer.player.getName());
				else
					Main.main.leaderboard.put(71, rplayer.player.getName());
			}
		}
	}
	
	public static void printLeaderboard() {
		Bukkit.broadcastMessage("§a[EPITOURNOI] §eClassement :");
		int i = 0;
		for(; i < Main.main.playersDone.size(); i++)
			Bukkit.broadcastMessage("§6 #" + i + " " + Main.main.playersDone.get(i) + "§e (" + Main.main.timePlayersDone.get(i) + ")");
		int max = Main.main.playersDoneElytra.size() + i;
		for(; i < max; i++)
			Bukkit.broadcastMessage("§6 #" + i + " " + Main.main.playersDoneElytra.get(i) + "§e (30:00)");
		int x = 1;
		for(; x <= 71; x++) {
			if(Main.main.leaderboard.containsKey(x)) {
				String[] players = Main.main.leaderboard.get(x).split(" ");
				for(String player : players)
					Bukkit.broadcastMessage("§6 #" + i + " " + player + "§e (30:00)");
				i++;
			}
		}
	}
	
	//**********************************************************************
	// Private classes

	private class Weather implements Listener {
		@EventHandler
		public void onWeatherChange(WeatherChangeEvent event) {
			if(event.toWeatherState())
				event.setCancelled(true);
		}
	}
	
}
