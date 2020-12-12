package fr.hugosimony.epitournoi2020;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.hugosimony.epitournoi2020.commands.ModoCommand;
import fr.hugosimony.epitournoi2020.commands.PlayerCommand;
import fr.hugosimony.epitournoi2020.listeners.OnConnexion;
import fr.hugosimony.epitournoi2020.listeners.OnCraft;
import fr.hugosimony.epitournoi2020.listeners.OnDamageAndFood;
import fr.hugosimony.epitournoi2020.listeners.OnDamageByPlayer;
import fr.hugosimony.epitournoi2020.listeners.OnMove;
import fr.hugosimony.epitournoi2020.race.RacePlayer;

public class Main extends JavaPlugin {
	
	public static Main main;
	
	public static final Location spawn = new Location(Bukkit.getWorld("world"), 29, 24, 99, 180, 0);
	
	public State state;
	public ArrayList<RacePlayer> players = new ArrayList<RacePlayer>();
	public HashMap<Player, RaceScoreboard> scoreboard = new HashMap<Player, RaceScoreboard>();
	public int craft;
	public int time;

	//**********************************************************************
	@Override
	public void onEnable() {
		System.out.println("Plugin EPITOURNOI 2020 started");
		
		main = this;
		
		state = State.WAITING;
		craft = 1;
		
		time = 0;
		
		// Listeners
		
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new OnMove(), this);
		pm.registerEvents(new OnDamageAndFood(), this);
		pm.registerEvents(new OnDamageByPlayer(), this);
		pm.registerEvents(new OnConnexion(), this);
		pm.registerEvents(new OnCraft(), this);
		
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
	
}
