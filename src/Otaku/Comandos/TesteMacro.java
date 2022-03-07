package Otaku.Comandos;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import Otaku.Main;

public class TesteMacro implements Listener, CommandExecutor {

	static final HashMap<String, Integer> Clicks = new HashMap<>();
	static final ArrayList<String> macro = new ArrayList<>();

	public static void testeMAcro(Player p, Player t) {
		p.sendMessage(Main.m.getConfig().getString("SV").replace("&", "§") + " §7Testando Macro No Jogador §e" + t.getName());
		macro.add(t.getName());
		Clicks.put(t.getName(), 0);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			@SuppressWarnings("deprecation")
			public void run() {
				p.sendMessage("§7§l----------------------------");
				p.sendMessage("§aPlayer Testado §7§o" + t.getName());
				p.sendMessage("§aClicks em 10 Segundos:  §7§o" + Clicks.get(t.getName()));
				p.sendMessage("§aClicks 1s §7§o" + Clicks.get(t.getName()) / 10);
				p.sendMessage("§7§l----------------------------");
				macro.remove(t.getName());
				if (Clicks.get(t.getName()) >= 450) {
					t.setBanned(true);
					t.kickPlayer("§cVoce foi Banido do Servidor por: Macro.\n §cBan Errado? Consulte um Administrador");
					Bukkit.broadcastMessage("§c§lBAN §7" + t.getName() + " §7Foi Banido Por Macro");
					;
				}
			}
		}, 20 * 10);
	}

	@EventHandler
	public void macro(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (macro.contains(p.getName())) {
			if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK ||
					e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				Clicks.put(p.getName(), Clicks.get(p.getName()) + 1);
			}
		}
	}

	@Override
	public final boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		Player p = (Player) Sender;
		if (p.hasPermission("kitpvp.admin")) {
			if (Args.length == 0) {
				p.sendMessage(Main.m.getConfig().getString("SV").replace("&", "§") + " §7Use /testmacro (Nick)");
				return true;
			}
			Player t = Bukkit.getPlayer(Args[0]);
			if (t != null) {
				testeMAcro(p, t);
			}
		}
		return false;
	}

}
