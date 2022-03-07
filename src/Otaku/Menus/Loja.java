package Otaku.Menus;
 
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import Otaku.Main;
import Otaku.API.API;
import Otaku.Eventos.ScoreB;
import Otaku.Files.Stats;

public class Loja implements Listener {

    private static Stats s = Stats.getClasse();
   
    private static ItemStack Vidro = API.create(Material.STAINED_GLASS_PANE, 15, 1, " ");
    
    private static ItemStack QuickDropper = API.create(Material.MUSHROOM_SOUP, "§e• QuickDropper", API.lore("§7Valor: §f65 mil Valis"));
    private static ItemStack Mago = API.create(Material.POTION,"§e• Mago", API.lore("§7Valor: §f65 mil Valis"));
    private static ItemStack Switcher = API.create(Material.SNOW_BALL, "§e• Switcher", API.lore("§7Valor: §f75 mil Valis"));
    private static ItemStack Viper = API.create(Material.SPIDER_EYE, "§e• Viper", API.lore("§7Valor: §f90 mil Valis"));
    
	private static ItemStack Carteira = API.create(Material.LEATHER, "§8» §aSua Carteira:", API.lore("§7➥ §Você possui: §e0 Valis"));
	private static ItemStack LojaV = API.create(Material.EMERALD, "§8» §aLoja de VIPs", API.lore("§7➥ Compre VIPs no site."));
	private static ItemStack Perm = API.create(Material.INK_SACK, 8, 1, "§7➥ Permissoes");
	private static ItemStack Kits = API.create(Material.INK_SACK, 10, 1, "§b➥ Kits");
	private static ItemStack Caixas = API.create(Material.INK_SACK, 8, 1, "§7➥ Caixas");

    public static void menu(Player p) {
		Inventory inv = Bukkit.createInventory(p, 45, "§7» §cLoja [KITS]");
		
		API.firstEmpty(inv, Vidro);
		Carteira = API.create(Material.LEATHER, "§8» §aSua Carteira:", API.lore("§7➥ Você possui: §e" + s.getValis(p) + " Valis"));
		inv.setItem(4, Perm);
		inv.setItem(3, Kits);
		inv.setItem(5, Caixas);
		
		inv.setItem(10, Carteira);
		inv.setItem(16, LojaV);
		
		inv.setItem(28, QuickDropper);
		inv.setItem(29, Switcher);
		inv.setItem(33, Mago);
		inv.setItem(34, Viper);
		p.openInventory(inv);
    }
	@EventHandler
    public void inv(InventoryClickEvent e) {
    	Inventory inv = e.getInventory();
    	if (e.getWhoClicked() instanceof Player) {
    		Player p = (Player) e.getWhoClicked();
    		if (e.getCurrentItem() != null) {
    			if (inv.getTitle().equals("§7» §cLoja [KITS]")) {
    				if (e.getClick() == ClickType.LEFT) {
    					if (e.getCurrentItem().equals(Vidro)) {
    						menu(p);
    						e.setCancelled(true);
    						return;
    					}
    					if (e.getCurrentItem().equals(LojaV)) {
    						Bukkit.dispatchCommand(p, "site");
    						p.closeInventory();
    						e.setCancelled(true);
    						return;
    					}
    					if (e.getCurrentItem().equals(Perm)) {
    						p.closeInventory(); 
    						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
    							public void run() {
    								 LojaPerm.menuPerm(p);
    							}
    						}, 0L);
    						API.som(p, Sound.CAT_HIT, 1.5F);
    						return;
    					}
    					if (e.getCurrentItem().equals(Carteira)) {
    						menu(p);
    						e.setCancelled(true);
    						return;
    					}
    					if (e.getCurrentItem().equals(Caixas)) {
    						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
    							public void run() {
    								 CaixaLoja.menuC(p);
    							}
    						}, 0L);
    						API.som(p, Sound.CAT_HIT, 1.5F);
    						e.setCancelled(true);
    						return;
    					}
    					if (e.getCurrentItem().equals(Kits)) {
    						e.setCancelled(true);
    						menu(p);
    						return;
    					}
    					if (e.getCurrentItem().equals(QuickDropper)) {
    						e.setCancelled(true);
    						p.closeInventory();
    						if (API.hP(p, "kit.quickdropper")) {
    							API.msg(p, API.prefix + "§cVoce ja possui esse kit.");
    							return;
    						}
    						if (s.getValis(p) >= 65000) {
    							s.removeValis(p, 65000);
    							API.msg(p, API.prefix + "§aVoce comprou o kit QuickDropper, §e- 65 mil Valis");
    							API.msg(p, API.prefix + "§cVocê deve relogar para seu kit ser adicionado!");
    							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex " + p.getName() + " add kit.quickdropper");
    						}else{
    							int conta = 65000 - s.getValis(p);
    							API.msg(p, API.prefix + "§cFaltam " + conta + " Valis §cpara poder comprar esse kit!");
    							
    							return;
    						}
    					}
    					if (e.getCurrentItem().equals(Mago)) {
    						e.setCancelled(true);
    						p.closeInventory();
    						if (API.hP(p, "kit.mago")) {
    							API.msg(p, API.prefix + "§cVoce ja possui esse kit.");
    							return;
    						}
    						if (s.getValis(p) >= 65000) {
    							s.removeValis(p, 65000);
    							API.msg(p, API.prefix + "§aVoce comprou o kit Mago, §e- 65 mil Valis");
    							API.msg(p, API.prefix + "§cVocê deve relogar para seu kit ser adicionado!");
    							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex " + p.getName() + " add kit.mago");
    						}else{
    							int conta = 65000 - s.getValis(p);
    							API.msg(p, API.prefix + "§cFaltam " + conta + " Valis §cpara poder comprar esse kit!");
    							
    							return;
    						}
    					}
    					if (e.getCurrentItem().equals(Switcher)) {
    						e.setCancelled(true);
    						p.closeInventory();
    						if (API.hP(p, "kit.switcher")) {
    							API.msg(p, API.prefix + "§cVoce ja possui esse kit.");
    							return;
    						}
    						if (s.getValis(p) >= 75000) {
    							s.removeValis(p, 75000);
    							API.msg(p, API.prefix + "§aVoce comprou o kit Switcher, §e- 65 mil Valis");
    							API.msg(p, API.prefix + "§cVocê deve relogar para seu kit ser adicionado!");
    							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex " + p.getName() + " add kit.switcher");
    						}else{
    							int conta = 75000 - s.getValis(p);
    							API.msg(p, API.prefix + "§cFaltam " + conta + " Valis §cpara poder comprar esse kit!");
    							
    							return;
    						}
    					}
    					if (e.getCurrentItem().equals(Viper)) {
    						e.setCancelled(true);
    						p.closeInventory();
    						if (API.hP(p, "kit.viper")) {
    							API.msg(p, API.prefix + "§cVoce ja possui esse kit.");
    							return;
    						}
    						if (s.getValis(p) >= 90000) {
    							s.removeValis(p, 90000);
    							API.msg(p, API.prefix + "§aVoce comprou o kit Viper, §e- 65 mil Valis");
    							API.msg(p, API.prefix + "§cVocê deve relogar para seu kit ser adicionado!");
    							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex " + p.getName() + " add kit.viper");
    						}else{
    							int conta = 90000 - s.getValis(p);
    							API.msg(p, API.prefix + "§cFaltam " + conta + " Valis §cpara poder comprar esse kit!");
    							return;
    						}
    					}
    					ScoreB.setSB(p);
    				}else{
    					menu(p);
    					e.setCancelled(true);
    				}
    			}
    		}
    	}
    }
}