package fr.hugosimony.epitournoi2020.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.hugosimony.epitournoi2020.Main;
import fr.hugosimony.epitournoi2020.RaceScoreboard;
import fr.hugosimony.epitournoi2020.State;
import fr.hugosimony.epitournoi2020.race.Craft;
import fr.hugosimony.epitournoi2020.race.RacePlayer;
import fr.hugosimony.epitournoi2020.race.RaceState;
import fr.hugosimony.epitournoi2020.utils.Utils;

public class PlayerCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		//**********************************************************************************
		// /login
		
		if(cmd.getName().equalsIgnoreCase("login")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				if(Main.main.state == State.WAITING) {
					if(!Utils.isPlayerLoggedin(player)) {
						if(args.length == 2) {
							Main.main.players.add(new RacePlayer(player));
							RaceScoreboard.updateScoreBoard();
						}
						player.sendMessage("§c[Erreur] La commande est §6/login <id> <password>§c.");
						return false;
					}
					Main.showPlayers(player);
					player.sendMessage("§c[Erreur] Vous êtes déjà connecté.");
					return false;
				}
				player.sendMessage("§c[Erreur] La partie n'est plus en phase de préparation.");
				return false;
			}
			System.out.println("[Erreur] Vous ne pouvez pas faire cette commande.");
			return false;
		}
		
		//**********************************************************************************
		// /reset
		
		if(cmd.getName().equalsIgnoreCase("reset")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				RacePlayer rplayer = Utils.getRacePlayer(player);
				if(rplayer != null) {
					if(rplayer.raceState == RaceState.CRAFT) {
						Craft.resetCraft(rplayer);
						player.sendMessage("§a[EPITOURNOI] §9Vous avez réinitialisé vos crafts.");
						return true;
					}
					player.sendMessage("§c[Erreur] Vous n'êtes pas dans la phase de craft.");
					return false;
				}
				player.sendMessage("§c[Erreur] Vous n'êtes pas dans la partie.");
				return false;
			}
			System.out.println("[Erreur] Vous ne pouvez pas faire cette commande.");
			return false;
		}
		return false;
	}

}
