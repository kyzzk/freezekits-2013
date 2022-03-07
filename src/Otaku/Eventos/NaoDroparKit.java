package Otaku.Eventos;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

import Otaku.Main;
import Otaku.Skill.ArrayL;

public class NaoDroparKit implements Listener {
	
	public Main plugin;
	  
	  public NaoDroparKit(Main main)
	  {
	    main = this.plugin;
	  }
	  
	  @EventHandler
	  public void onDrop(PlayerDropItemEvent e)
	  {
	    if (e.getItemDrop().getItemStack().getType() == Material.NAME_TAG)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.ENDER_CHEST)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.ANVIL)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.MAGMA_CREAM)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.STAINED_GLASS_PANE)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.PAPER)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.IRON_SWORD)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.DIAMOND_SWORD)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.IRON_FENCE)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.NETHER_FENCE)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.FIREWORK)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.FISHING_ROD)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.SNOW_BALL)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.SADDLE)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.IRON_FENCE)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.ENCHANTED_BOOK)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.TNT)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.WATCH)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.REDSTONE_BLOCK)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.LAPIS_BLOCK)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.WOOD_BUTTON)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.FEATHER)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.LEASH)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.CHEST)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.BOOK)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.NETHER_STAR)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.BONE)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.GHAST_TEAR)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.STONE_SWORD)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.WOOD_SWORD)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.IRON_SWORD)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.DIAMOND_SWORD)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.GOLDEN_APPLE)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.SUGAR)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.NETHER_FENCE)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.STONE_BUTTON)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.STONE_AXE)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.STICK)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.ARROW)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.COMPASS)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.WATER_BUCKET)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.ENCHANTED_BOOK)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.ENDER_CHEST)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.DIAMOND)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.WATER_BUCKET)
	    {
	      e.setCancelled(true);
	      return;
	    }
	    if (e.getItemDrop().getItemStack().getType() == Material.GOLD_AXE)
	    {
	      e.setCancelled(true);
	      return;
	    }
	  }
}
