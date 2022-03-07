package Otaku.Eventos;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import Otaku.Main;

public class JoinBan implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void entrar(PlayerLoginEvent e) {
		Player p = e.getPlayer();
		if (p.isBanned()) {
				e.setKickMessage(Main.m.getConfig().getString("SV").replace("&", "§") + "\n§7Sua conta foi Suspensa! \n\n§7Ocorreu Algum erro? \n§6Site§7: www.freezekits.wix.com");
				e.disallow(Result.KICK_OTHER, e.getKickMessage());
				for (Player all : Bukkit.getOnlinePlayers()) {
					if (all.hasPermission(Main.m.getConfig().getString("PermBan"))) {
						all.sendMessage("§7" + p.getName() + "§7 Esta Tentando Entrar Banido");
					}
				}
		}
		}
}
