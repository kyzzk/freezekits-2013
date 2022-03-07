package Otaku.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Otaku.API.API;
import Otaku.Eventos.ScoreB;
import Otaku.Menus.JoinInventory;

public class Cmds implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("score")) {
				if (ScoreB.ScoreOFF.contains(p.getName())) {
					ScoreB.ScoreOFF.remove(p.getName());
					API.msg(p, API.prefix + "§aVoce ativou sua ScoreBoard.");
					ScoreB.setSB(p);
					return true;
				}else{
					ScoreB.ScoreOFF.add(p.getName());
					ScoreB.setSB(p);
					API.msg(p, API.prefix + "§cVoce desativou sua ScoreBoard.");
					return true;
				}
			}
			if (cmd.getName().equalsIgnoreCase("help") || (cmd.getName().equalsIgnoreCase("ajuda"))) {
				JoinInventory.helpMenu(p);
			}
		}else{
			sender.sendMessage(API.prefix + "§cSomente players podem usar este comando!");
		}
		return true;
	}
}
