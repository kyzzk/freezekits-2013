package Otaku.Eventos;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import Otaku.API.API;
import Otaku.API.KitAPI;
import Otaku.Files.Stats;
import Otaku.Warps.Warp;

public class Join implements Listener {
	
	Stats s = Stats.getClasse();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void join(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		e.setJoinMessage(null);		
		KitAPI.setKit(p, "Spawn");
		Warp.removeW(p);
		API.cI(p);
		API.rT(p);
		if (!p.hasPlayedBefore()) {
			Stats.getClasse().giveStats(p);
		    API.msg(p,"    §8» §bFreeze§fKits    ");
			API.msg(p,"§f➥        §7Bem-vindo ao servidor foi adicionado 1k de Valis em sua conta! ");
		    API.msg(p,"§f➥        §7Players Online  §a" + Bukkit.getServer().getOnlinePlayers().length + "/40");
			API.msg(p,"  ");
			s.addValis(p, 1000);
		}else{
		    API.msg(p,"    §8» §bFreeze§fKits    ");
			API.msg(p,"§f➥        §7Obrigado por jogar em nosso servidor!");
		    API.msg(p,"§f➥        §7Players Online  §a" + Bukkit.getServer().getOnlinePlayers().length + "/40");
			API.msg(p,"  ");	
		}
		
		API.darItemsSpawn(p);
		
		ScoreB.setSB(p);
		API.teleport(p, API.getLocationWarp("Lobby"));
	}
}