package fr.hugosimony.epitournoi2020.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.hugosimony.epitournoi2020.Main;
import fr.hugosimony.epitournoi2020.State;
import fr.hugosimony.epitournoi2020.timers.StartingTimer;

public class ModoCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		//**********************************************************************************
		// /say
		
		if(cmd.getName().equalsIgnoreCase("say")) {
			if(sender.isOp()) {
				String message = "";
				if(sender instanceof Player)
					message = "§6[Organisateur] " + ((Player) sender).getName() + " : §9";
				else
					message = "§6[Console] §9";
				if(args.length == 0) {
					if(sender instanceof Player)
						((Player) sender).sendMessage("§c[Erreur] La commande est §6/say (message)§c.");
					else
						System.out.println("[Erreur] La commande est /say (message).");
					return false;
				}
				for(String s: args) message+=s+" ";
				Bukkit.broadcastMessage("§9§m----------------------------------------------");
				Bukkit.broadcastMessage(message);
				Bukkit.broadcastMessage("§9§m----------------------------------------------");
				return true;
			}
			Player player = (Player) sender;
			player.sendMessage("§c[Erreur] Vous n'avez pas la permission de faire cette commande.");
			return false;
		}
		
		//**********************************************************************************
		// /start
				
		if(cmd.getName().equalsIgnoreCase("start")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				if(player.isOp()) {
					if(args.length == 0) {
						if(Main.main.state == State.WAITING) {
							Main.main.state = State.STARTING;
							StartingTimer task = new StartingTimer();
							task.runTaskTimer(Main.main, 0, 20);
							return true;
						}
						player.sendMessage("§c[Erreur] La partie a déjà démarré.");
						return false;
					}
					if(args.length == 1 && args[0].equalsIgnoreCase("cancel")) {
						if(Main.main.state == State.STARTING) {
							Main.main.state = State.WAITING;
							player.sendMessage("§9Vous avez arrêté le démarrage.");
							return true;
						}
						player.sendMessage("§c[Erreur] La partie n'est pas en démarrage.");
						return false;
					}
					player.sendMessage("§c[Erreur] La commande est §6/start §cou §6/start cancel§c.");
					return false;
				}
				player.sendMessage("§c[Erreur] Vous n'avez pas la permission de faire cette commande.");
				return false;
			}
			System.out.println("[Erreur] Vous ne pouvez pas faire cette commande.");
			return false;
		}
		
		return false; // Default
	}

}
