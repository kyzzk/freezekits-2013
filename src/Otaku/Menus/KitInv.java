package Otaku.Menus;
 
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import Otaku.API.API;
import Otaku.Files.Stats;

public class KitInv implements Listener {

    private static Stats s = Stats.getClasse();
   
    private static ItemStack Vidro = API.create(Material.STAINED_GLASS_PANE, 15, 1, " ");
    
    public static void menu(Player p) {
		Inventory inv = Bukkit.createInventory(p, 45, "§7» §cKits");
		
		API.firstEmpty(inv, Vidro);
		p.openInventory(inv);
    }
	@EventHandler
    public void inv(InventoryClickEvent e) {
    	Inventory inv = e.getInventory();
    	if (e.getWhoClicked() instanceof Player) {
    		Player p = (Player) e.getWhoClicked();
    		if (e.getCurrentItem() != null) {
    			if (inv.getTitle().equals("§7» §cKits")) {
    				if (e.getClick() == ClickType.LEFT) {
    					if (e.getCurrentItem().equals(Vidro)) {
    						menu(p);
    						e.setCancelled(true);
    						return;
    					}
    				
    				}else{
    					menu(p);
    					e.setCancelled(true);
    				}
    			}
    		}
    	}
    }
}