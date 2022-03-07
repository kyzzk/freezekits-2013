package Otaku.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Otaku.API.API;
import Otaku.API.KitAPI;
import Otaku.Skill.Surprise;

public class Kit implements CommandExecutor {
		
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("kit")) {
				if (args.length == 0) {
					API.msg(p, API.prefix + "§cUse: /kit <nomedokit>");
					return true;
				}
				if (args.length == 1) {
					if (KitAPI.getKit(p) == "Spawn") {
						if (args[0].equalsIgnoreCase("PvP")) {
							KitAPI.setKit(p, "PvP");
							return true;
						}
						if (args[0].equalsIgnoreCase("Surprise")) {
							KitAPI.setKit(p, Surprise.get());
							return true;
						}
						if (args[0].equalsIgnoreCase("anchor")) {
							if (API.hP(p, "kit.anchor") || (API.hP(p, "kit.*"))) {
								KitAPI.setKit(p, "Anchor");
								return true;
							}
						}
						if (args[0].equalsIgnoreCase("avatar")) {
							if (API.hP(p, "kit.avatar") || (API.hP(p, "kit.*"))) {
								KitAPI.setKit(p, "Avatar");
								return true;
							}
						}
						if (args[0].equalsIgnoreCase("grappler")) {
							if (API.hP(p, "kit.grappler") || (API.hP(p, "kit.*"))) {
								KitAPI.setKit(p, "Grappler");
								return true;
							}
						}
						if (args[0].equalsIgnoreCase("DeshFire")) {
							if (API.hP(p, "kit.deshfire") || (API.hP(p, "kit.*"))) {
								KitAPI.setKit(p, "DeshFire");
								return true;
							}
						}
						if (args[0].equalsIgnoreCase("ForceField")) {
							if (API.hP(p, "kit.forcefield") || (API.hP(p, "kit.*"))) {
								KitAPI.setKit(p, "ForceField");
								return true;
							}
						}
						if (args[0].equalsIgnoreCase("Gladiator")) {
							if (API.hP(p, "kit.gladiator") || (API.hP(p, "kit.*"))) {
								KitAPI.setKit(p, "Gladiator");
								return true;
							}
						}
						if (args[0].equalsIgnoreCase("hulk")) {
							if (API.hP(p, "kit.hulk") || (API.hP(p, "kit.*"))) {
								KitAPI.setKit(p, "Hulk");
								return true;
							}
						}
						if (args[0].equalsIgnoreCase("Kangaroo")) {
							if (API.hP(p, "kit.kangaroo") || (API.hP(p, "kit.*"))) {
								KitAPI.setKit(p, "Kangaroo");
								return true;
							}
						}
						if (args[0].equalsIgnoreCase("mago")) {
							if (API.hP(p, "kit.mago") || (API.hP(p, "kit.*"))) {
								KitAPI.setKit(p, "Mago");
								return true;
							}
						}
						if (args[0].equalsIgnoreCase("Ninja")) {
							if (API.hP(p, "kit.ninja") || (API.hP(p, "kit.*"))) {
								KitAPI.setKit(p, "Ninja");
								return true;
							}
						}
						if (args[0].equalsIgnoreCase("Rain")) {
							if (API.hP(p, "kit.rain") || (API.hP(p, "kit.*"))) {
								KitAPI.setKit(p, "Rain");
								return true;
							}
						}
						if (args[0].equalsIgnoreCase("Sonic")) {
							if (API.hP(p, "kit.sonic") || (API.hP(p, "kit.*"))) {
								KitAPI.setKit(p, "Sonic");
								return true;
							}
						}
						if (args[0].equalsIgnoreCase("Stomper")) {
							if (API.hP(p, "kit.stomper") || (API.hP(p, "kit.*"))) {
								KitAPI.setKit(p, "Stomper");
								return true;
							}
						}
						if (args[0].equalsIgnoreCase("Sumo")) {
							if (API.hP(p, "kit.sumo") || (API.hP(p, "kit.*"))) {
								KitAPI.setKit(p, "Sumo");
								return true;
							}
						}
						if (args[0].equalsIgnoreCase("SuperNova")) {
							if (API.hP(p, "kit.supernova") || (API.hP(p, "kit.*"))) {
								KitAPI.setKit(p, "SuperNova");
								return true;
							}
						}
						if (args[0].equalsIgnoreCase("thor")) {
							if (API.hP(p, "kit.thor") || (API.hP(p, "kit.*"))) {
								KitAPI.setKit(p, "Thor");
								return true;
							}
						}
						KitAPI.giveKit(p);
					}else{
						API.msg(p, API.prefix + "§cVoce ja esta com um kit!");
					}
				}
			}
		}
		return false;
	}
}
