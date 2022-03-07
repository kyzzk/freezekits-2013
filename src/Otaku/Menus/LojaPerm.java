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

public class LojaPerm implements Listener {
	
    private static Stats s  = Stats.getClasse();
    
    private static ItemStack Vidro = API.create(Material.STAINED_GLASS_PANE, 15, 1, " ");	
	
	private static ItemStack Carteira = API.create(Material.LEATHER, "§8» §aSua Carteira:", API.lore("§7➥ §Você possui: §e0 Valis"));
	private static ItemStack LojaV = API.create(Material.EMERALD, "§8» §aLoja de VIPs", API.lore("§7➥ Compre VIPs no site."));
	private static ItemStack Caixas = API.create(Material.INK_SACK, 8, 1, "§7➥ Caixas");
	private static ItemStack KitsX = API.create(Material.INK_SACK, 8, 1, "§7➥ Kits");
	private static ItemStack PermM = API.create(Material.INK_SACK, 10, 1, "§b➥ Permissoes");
	
	private static ItemStack Color = API.create(Material.ARROW, "§e• Falar §aC§2O§3L§4O§5R§6I§7D§dO", API.lore("§7Valor: §f100 mil Valis"));
	private static ItemStack EntrarFull = API.create(Material.COMPASS, "§e• Entrar server Cheio", API.lore("§7Valor: §f120 mil Valis"));
	
	public static void menuPerm(Player p) {
		Inventory inv2 = Bukkit.createInventory(p, 45, "§7» §cLoja [PERMISSOES]");
		
		API.firstEmpty(inv2, Vidro);
		Carteira = API.create(Material.LEATHER, "§8» §aSua Carteira:", API.lore("§7➥ Você possui: §e" + s.getValis(p) + " Valis"));
		inv2.setItem(4, PermM);
		inv2.setItem(3, KitsX);
		inv2.setItem(5, Caixas);
		
		inv2.setItem(10, Carteira);
		inv2.setItem(16, LojaV);
		
		inv2.setItem(29, Color);
		inv2.setItem(33, EntrarFull);
		p.openInventory(inv2);
	}
	@EventHandler
    public void inv(InventoryClickEvent e) {
    	Inventory inv = e.getInventory();
    	if (e.getWhoClicked() instanceof Player) {
    		Player p = (Player) e.getWhoClicked();
    		if (e.getCurrentItem() != null) {
    			if (inv.getTitle().equals("§7» §cLoja [PERMISSOES]")) {
    				if (e.getClick() == ClickType.LEFT) {
    					if (e.getCurrentItem().equals(Vidro)) {
    						menuPerm(p);
    						e.setCancelled(true);
    						return;
    					}
    					if (e.getCurrentItem().equals(LojaV)) {
    						Bukkit.dispatchCommand(p, "site");
    						p.closeInventory();
    						e.setCancelled(true);
    						return;
    					}
    					if (e.getCurrentItem().equals(PermM)) {
    						menuPerm(p);
    						return;
    					}
    					if (e.getCurrentItem().equals(Carteira)) {
    						menuPerm(p);
    						e.setCancelled(true);
    						return;
    					}
    					if (e.getCurrentItem().equals(KitsX)) {
    						e.setCancelled(true);
    						p.closeInventory();
    						API.som(p, Sound.CAT_HIT, 1.5F);
    						Loja.menu(p);
    						return;
    					}
    					if (e.getCurrentItem().equals(Caixas)) {
    						e.setCancelled(true);
    						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
    							public void run() {
    								 CaixaLoja.menuC(p);
    							}
    						}, 0L);
    						API.som(p, Sound.CAT_HIT, 1.5F);
    						return;
    					}
    					if (e.getCurrentItem().equals(Color)) {
    						e.setCancelled(true);
    						p.closeInventory();
    						if (API.hP(p, "fkits.color")) {
    							API.msg(p, API.prefix + "§cVoce ja pode falar colorido.");
    							return;
    						}
    						if (s.getValis(p) >= 100000) {
    							s.removeValis(p, 100000);
    							API.msg(p, API.prefix + "§aVoce comprou a Perm de falar Colorido, §e- 100 mil Valis");
    							API.msg(p, API.prefix + "§cVocê deve relogar para poder falar colorido!");
    							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex " + p.getName() + " add fkits.color");
    						}else{
    							int conta = 100000 - s.getValis(p);
    							API.msg(p, API.prefix + "§cFaltam " + conta + " Valis §cpara poder comprar essa permissao!");
    							
    							return;
    						}
    					}
    					if (e.getCurrentItem().equals(EntrarFull)) {
    						e.setCancelled(true);
    						p.closeInventory();
    						if (API.hP(p, "fkits.full")) {
    							API.msg(p, API.prefix + "§cVoce ja pode entrar com o server cheio.");
    							return;
    						}
    						if (s.getValis(p) >= 120000) {
    							s.removeValis(p, 120000);
    							API.msg(p, API.prefix + "§aVoce comprou a Perm de Entrar no server Cheio, §e- 120 mil Valis");
    							API.msg(p, API.prefix + "§cVocê deve relogar para seu kit ser adicionado!");
    							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex " + p.getName() + " add fkits.full");
    						}else{
    							int conta = 120000 - s.getValis(p);
    							API.msg(p, API.prefix + "§cFaltam " + conta + " Valis §cpara poder comprar essa permissao!");
    							
    							return;
    						}
    					}
    					ScoreB.setSB(p);
    				}else{
    					menuPerm(p);
    					e.setCancelled(true);
    				}
    			}
    		}
    	}
    }
}