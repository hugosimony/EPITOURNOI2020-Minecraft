package fr.hugosimony.epitournoi2020;

import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import fr.hugosimony.epitournoi2020.race.RacePlayer;
import fr.hugosimony.epitournoi2020.race.RaceState;
import fr.hugosimony.epitournoi2020.utils.Utils;

public class RaceScoreboard implements ScoreboardManager {

	public Objective objective;
	public Scoreboard scoreboard;
	public Player player;
	public String name = "";

	public RaceScoreboard(Player player) {
		this.player = player;
		this.scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
		if(Main.main.scoreboard.containsKey(player)) return;
		
		//*****************************************************************************
		
		this.name = "sb." + new Random().nextInt(77777);
		this.objective = scoreboard.registerNewObjective(name, "dummy");
		objective.setDisplayName("§a§l  EPITOURNOI    ");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		
		Main.main.scoreboard.put(player, this);
	}

	public void sendLine() {
		objective.getScore("§1§9§m --------------- ").setScore(10);
		objective.getScore("§6 Timer : 00:00").setScore(9);
		objective.getScore("§e  PVP : 0").setScore(8);
		objective.getScore("§e  Jump : 0").setScore(7);
		objective.getScore("§e  Craft : 0").setScore(6);
		objective.getScore("§e  Elytra : 0").setScore(5);
		objective.getScore("§e  Fini : 0").setScore(4);
		objective.getScore("§2§9§m --------------- ").setScore(3);
		objective.getScore("§e Joueurs Ingame ").setScore(2);
		objective.getScore(" §e§m-§r§e> ").setScore(1);
		objective.getScore("§3§9§m --------------- ").setScore(0);
	}
	
	public void set() {
		player.setScoreboard(scoreboard);
	}
	
	public void refresh() {
		//******************************************************************************************
		// Timer Général
		String time = new SimpleDateFormat("mm:ss").format(Main.main.time * 1000);
		String timePvp = "";
		String timeJump = "";
		String timeCraft = "";
		String timeElytra = "";
		RacePlayer rplayer = Utils.getRacePlayer(player);
		if(rplayer != null) {
			time = new SimpleDateFormat("mm:ss").format(rplayer.time * 1000);
			timePvp = new SimpleDateFormat("mm:ss").format(rplayer.timePvp * 1000);
			if(rplayer.raceState != RaceState.PVP && rplayer.raceState != RaceState.WAITING) timePvp = "§a" + timePvp;
			else if(rplayer.raceState == RaceState.PVP) timePvp = "§6" + timePvp;
			timeJump = new SimpleDateFormat("mm:ss").format(rplayer.timeJump * 1000);
			if(rplayer.raceState != RaceState.PVP && rplayer.raceState != RaceState.JUMP && rplayer.raceState != RaceState.WAITING) timeJump = "§a" + timeJump;
			else if(rplayer.raceState == RaceState.JUMP) timeJump = "§6" + timeJump;
			timeCraft = new SimpleDateFormat("mm:ss").format(rplayer.timeCraft * 1000);
			if(rplayer.raceState != RaceState.PVP && rplayer.raceState != RaceState.JUMP && rplayer.raceState != RaceState.CRAFT && rplayer.raceState != RaceState.WAITING) timeCraft = "§a" + timeCraft;
			else if(rplayer.raceState == RaceState.CRAFT) timeCraft = "§6" + timeCraft;
			timeElytra = new SimpleDateFormat("mm:ss").format(rplayer.timeElytra * 1000);
			if(rplayer.finished) {
				timeElytra = "§a" + timeElytra;
				time = "§2" + time;
			}
			else if(rplayer.raceState == RaceState.ELYTRA) timeElytra = "§6" + timeElytra;
		}
		for(String line: scoreboard.getEntries()) {
			if(line.contains("§6 Timer :")) {
				scoreboard.resetScores(line);
				objective.getScore("§6 Timer : " + time).setScore(9);
			}
			else if(line.contains(" §e§m-§r§e>")) {
				scoreboard.resetScores(line);
				objective.getScore(" §e§m-§r§e> " + Main.main.players.size() + "/30").setScore(1);
			}
			else {
				if(rplayer != null) {
					if(line.contains("§e  PVP : ")) {
						scoreboard.resetScores(line);
						objective.getScore("§e  PVP : " + timePvp).setScore(8);
					}
					else if(line.contains("§e  Jump : ")) {
						scoreboard.resetScores(line);
						objective.getScore("§e  Jump : " + timeJump).setScore(7);
					}
					else if(line.contains("§e  Craft : ")) {
						scoreboard.resetScores(line);
						objective.getScore("§e  Craft : " + timeCraft).setScore(6);
					}
					else if(line.contains("§e  Elytra : ")) {
						scoreboard.resetScores(line);
						objective.getScore("§e  Elytra : " + timeElytra).setScore(5);
					}
					else if(line.contains("§e  §m-§r§e> ") || line.contains("§e  Fini : ")) {
						scoreboard.resetScores(line);
						objective.getScore("§e  §m-§r§e> " + (rplayer.finished ? "§a" : "") + rplayer.countElytraCp + "/70").setScore(4);
					}
				}
				else {
					int[] status = RacePlayer.getStatusOfRacePlayers();
					if(line.contains("§e  PVP : ")) {
						scoreboard.resetScores(line);
						objective.getScore("§e  PVP : " + status[0]).setScore(8);
					}
					else if(line.contains("§e  Jump : ")) {
						scoreboard.resetScores(line);
						objective.getScore("§e  Jump : " + status[1]).setScore(7);
					}
					else if(line.contains("§e  Craft : ")) {
						scoreboard.resetScores(line);
						objective.getScore("§e  Craft : " + status[2]).setScore(6);
					}
					else if(line.contains("§e  Elytra : ")) {
						scoreboard.resetScores(line);
						objective.getScore("§e  Elytra : " + status[3]).setScore(5);
					}
					else if(line.contains("§e  Fini : ")) {
						scoreboard.resetScores(line);
						objective.getScore("§e  Fini : " + status[4]).setScore(4);
					}
				}
			}
		}
	}
	
	@Override
	public Scoreboard getMainScoreboard() {
		return scoreboard;
	}


	@Override
	public Scoreboard getNewScoreboard() {
		return null;
	}
	
	public static void updateScoreBoard() {
		for(Entry<Player, RaceScoreboard> s: Main.main.scoreboard.entrySet()) {
			RaceScoreboard sb = s.getValue();
			sb.refresh();
		}
	}
	
}
