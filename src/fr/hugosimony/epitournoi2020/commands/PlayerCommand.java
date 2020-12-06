package fr.hugosimony.epitournoi2020.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.hugosimony.epitournoi2020.Main;
import fr.hugosimony.epitournoi2020.race.RacePlayer;
import fr.hugosimony.epitournoi2020.utils.Utils;

public class PlayerCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		//**********************************************************************************
		// /say
		
		if(cmd.getName().equalsIgnoreCase("login")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				if(!Utils.isPlayerLoggedin(player)) {
					if(args.length == 2) {
						Main.main.players.add(new RacePlayer(player));
					}
					player.sendMessage("§c[Erreur] La commande est §6/login <id> <password>§c.");
					return false;
				}
				player.sendMessage("§c[Erreur] Vous êtes déjà connecté.");
				return false;
			}
			System.out.println("[Erreur] Vous ne pouvez pas faire cette commande.");
			return false;
		}
		return false;
	}

}
