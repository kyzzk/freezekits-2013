package Otaku.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Otaku.API.API;
import Otaku.Files.Stats;

public class Clan implements CommandExecutor {
	//nao decompile seu lixo
	
	private static Stats s = Stats.getClasse();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("clan")) {
				if (args.length == 0) {
					API.msg(p, API.prefix + "§cUse /clan <help>");
					return true;
				}
				if (args.length == 1) {
					
				}
			}
		}else{
			sender.sendMessage(API.prefix + "§cSomente players podem usar este comando!");
		}
		return true;
	}
}
