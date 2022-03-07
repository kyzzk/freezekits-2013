package Otaku.Eventos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import Otaku.API.KitAPI;
import Otaku.Files.Stats;

public class ScoreB implements Listener {

	public static ArrayList<String> ScoreOFF = new ArrayList<>();
	private static Stats S = Stats.getClasse();
	
	@SuppressWarnings("deprecation")
	public static void setSB(Player p) {
		
		for (Objective objeto : p.getScoreboard().getObjectives()) {
		    objeto.unregister();
		}
		if (ScoreOFF.contains(p.getName())) {
			return;
		}
		Scoreboard score = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective o = score.registerNewObjective("Gui", "Otaku");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName("§bFreeze§fKits");
			    
		o.getScore("§1").setScore(10);
		o.getScore(Bukkit.getOfflinePlayer("§7Matou:§f ")).setScore(9);
		o.getScore(Bukkit.getOfflinePlayer("§7Morreu:§f ")).setScore(8);
		o.getScore(Bukkit.getOfflinePlayer("§7Streak:§f ")).setScore(7);
		o.getScore(Bukkit.getOfflinePlayer("§2")).setScore(6);
		o.getScore(Bukkit.getOfflinePlayer("§7Clan:§f ")).setScore(5);
		o.getScore(Bukkit.getOfflinePlayer("§7Kit:§f ")).setScore(4);
		o.getScore(Bukkit.getOfflinePlayer("§7Valis:§f ")).setScore(3);
		o.getScore(Bukkit.getOfflinePlayer("§3")).setScore(2);
		o.getScore(Bukkit.getOfflinePlayer("§7/score")).setScore(1);
			    		 
		score.registerNewTeam("kills").addPlayer(Bukkit.getOfflinePlayer("§7Matou:§f "));
		score.registerNewTeam("deaths").addPlayer(Bukkit.getOfflinePlayer("§7Morreu:§f "));
		score.registerNewTeam("streak").addPlayer(Bukkit.getOfflinePlayer("§7Streak:§f "));
		score.registerNewTeam("valis").addPlayer(Bukkit.getOfflinePlayer("§7Valis:§f "));
		score.registerNewTeam("kit").addPlayer(Bukkit.getOfflinePlayer("§7Kit:§f "));
		score.registerNewTeam("clan").addPlayer((Bukkit.getOfflinePlayer("§7Clan:§f ")));
			 
	    score.getTeam("kills").setSuffix(String.valueOf(S.getKills(p)));
		score.getTeam("deaths").setSuffix(String.valueOf(S.getDeaths(p)));
		score.getTeam("streak").setSuffix(String.valueOf(S.getStreak(p)));
		score.getTeam("valis").setSuffix(String.valueOf(S.getValis(p)));
		score.getTeam("clan").setSuffix(String.valueOf(S.getClan(p)));
		score.getTeam("kit").setSuffix(String.valueOf(KitAPI.getKit(p)));
		p.setScoreboard(score);
	}
}