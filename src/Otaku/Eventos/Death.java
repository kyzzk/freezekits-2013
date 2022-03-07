package Otaku.Eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import Otaku.Main;
import Otaku.API.API;
import Otaku.API.KitAPI;
import Otaku.Files.Stats;

public class Death implements Listener {
	
	private static Stats s = Stats.getClasse();
	
	@EventHandler
	public void death(PlayerDeathEvent e) {
		Player p = e.getEntity();
		e.setDeathMessage(null);
		
		API.rT(p);
		KitAPI.setKit(p, "Spawn");
		s.clearStreak(p);
		e.getDrops().clear();
	
		new BukkitRunnable() {
			public void run() {
				if (e.getEntity() instanceof Player) {
					e.getEntity().spigot().respawn();
			}
			}
		}.runTask(Main.getPlugin());
	}
}
