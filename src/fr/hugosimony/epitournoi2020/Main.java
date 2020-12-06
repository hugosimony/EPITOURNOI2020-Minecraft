package fr.hugosimony.epitournoi2020;

import java.util.ArrayList;

import org.bukkit.plugin.java.JavaPlugin;

import fr.hugosimony.epitournoi2020.commands.ModoCommand;
import fr.hugosimony.epitournoi2020.commands.PlayerCommand;
import fr.hugosimony.epitournoi2020.race.RacePlayer;

public class Main extends JavaPlugin {
	
	public static Main main;
	
	public State state;
	public ArrayList<RacePlayer> players = new ArrayList<RacePlayer>();

	//**********************************************************************
	@Override
	public void onEnable() {
		System.out.println("Plugin EPITOURNOI 2020 started");
		
		main = this;
		
		state = State.WAITING;
		
		// Listeners
		
		//PluginManager pm = getServer().getPluginManager();
		
		// Commandes :
		getCommand("say").setExecutor(new ModoCommand());
		getCommand("start").setExecutor(new ModoCommand());
		getCommand("login").setExecutor(new PlayerCommand());
		
	}
	
	@Override
	public void onDisable() {
		System.out.println("Plugin EPITOURNOI 2020 finished");
	}
	
	//**********************************************************************
	
}
