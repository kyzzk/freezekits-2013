package Otaku.Eventos;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import Otaku.API.API;
import Otaku.API.KitAPI;

@SuppressWarnings("deprecation")
public class Events implements Listener {
	
	@EventHandler
	public void nofood(FoodLevelChangeEvent e) {
		e.setFoodLevel(20);
	}
	@EventHandler
	public void sopa(PlayerInteractEvent e) {
	    Player p = e.getPlayer();
	    Damageable hp = p;
	    if (hp.getHealth() != 20.0D) {
	      int sopa = 7;
	      if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && (p.getItemInHand().getTypeId() == 282)) {
	        p.setHealth(hp.getHealth() + sopa > hp.getMaxHealth() ? hp.getMaxHealth() : hp.getHealth() + sopa);
	        p.getPlayer().playSound(p.getPlayer().getLocation(), Sound.BURP, 5.0F, 5.0F);
	        if (!KitAPI.getKit(p).equals("QuickDropper")) {
	          p.setItemInHand(API.create(Material.BOWL, "§8» §cPote de Merda"));
	        }
	        else {
	          p.getItemInHand().setType(Material.BOWL);
	          p.getPlayer().getInventory().remove(p.getItemInHand());
	          p.getInventory().remove(new ItemStack(Material.BOWL, 1));
	          p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.BOWL));
	          p.updateInventory();
	        }
	      }
	    }
	}
	@EventHandler
	public void buss(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (p.getItemInHand().getType() == Material.COMPASS) {
			if (e.getAction() != Action.PHYSICAL) {
				if (!KitAPI.getKit(p).equals("Spawn")) {
					Boolean have = false;
					for (Entity ent : p.getWorld().getEntities()) {
						if (ent.getType() == EntityType.PLAYER) {
							Player pr = (Player) ent;
							Location ploc = p.getLocation();
							Location prloc = pr.getLocation();
							if (ploc.distance(prloc) > 10.0D) {
								p.setCompassTarget(prloc);
					            API.msg(p, API.prefix + "§aBússola apontada para: §e" + pr.getName() + " §7[Distância: " + (int)pr.getLocation().distance(p.getLocation()) + "]");
					            have = true;
							}
						}
						if (have) {
							return;
						}
					}
				    if (!have.booleanValue()) {
				      API.msg(p, API.prefix + "§aNao foi encontrado players, §eFeast §7[Distância: " + (int)p.getLocation().distance(API.getLocationWarp("Feast")) + "]");
				      p.setCompassTarget(API.getLocationWarp("Feast"));
				    }
				}
			}
		}
	}
}
