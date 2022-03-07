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
import Otaku.Eventos.CaixaAPI;
import Otaku.Eventos.ScoreB;
import Otaku.Files.Stats;

public class CaixaLoja implements Listener {
	
    public static Stats s = Stats.getClasse();
    
    private static ItemStack Vidro = API.create(Material.STAINED_GLASS_PANE, 15, 1, " ");	
	
	private static ItemStack Carteira = API.create(Material.LEATHER, "§8» §aSua Carteira:", API.lore("§7➥ §Você possui: §e0 Valis"));
	private static ItemStack LojaV = API.create(Material.EMERALD, "§8» §aLoja de VIPs", API.lore("§7➥ Compre VIPs no site."));
	private static ItemStack CaixasW = API.create(Material.INK_SACK, 10, 1, "§b➥ Caixas");
	private static ItemStack KitsX = API.create(Material.INK_SACK, 8, 1, "§7➥ Kits");
	private static ItemStack PermZ = API.create(Material.INK_SACK, 8, 1, "§7➥ Permissoes");
	
	private static ItemStack Caixas1x = API.create(Material.CHEST, "§e• 1 KEY", API.lore("§7Valor: §f10 mil Valis"));
	private static ItemStack Caixas3x = API.create(Material.CHEST, "§e• 3 KEY", API.lore("§7Valor: §f25 mil Valis"));
	private static ItemStack Caixas10x = API.create(Material.CHEST, "§e• 10 KEY", API.lore("§7Valor: §f80 mil Valis"));
	
	private static ItemStack se = API.create(Material.INK_SACK, 8, 1, " ");
	private static ItemStack OpenCaixa = API.create(Material.CHEST, "§8» §aAbrir Caixa", API.lore("§7➥ Voce precisa de Keys para abrir", "", "§7➥ Voce possui: 0 Keys"));
	private static ItemStack ComoCaixa = API.create(Material.CHEST, "§8» §aComo conseguir Keys", API.lore("§7➥ Voce consegue Keys comprando", "§7➥ Na loja dquirindo VIP ou em Eventos"));
	private static ItemStack LojaCaixa = API.create(Material.CHEST, "§8» §aLoja de Keys", API.lore("§7➥ Aqui voce pode adquirir Keys", "§7➥ Para poder abrir as caixas."));
	
	public static void menuC2(Player p) {
		Inventory inv2 = Bukkit.createInventory(p, 45, "§7» §cCaixas");
		
		API.firstEmpty(inv2, Vidro);
		OpenCaixa = API.create(Material.CHEST, "§8» §aAbrir Caixa", API.lore("§7➥ Voce necessita de 1 Key para abrir", "", "§7➥ Voce possui: §e" + s.getKeys(p) + " Keys"));
		inv2.setItem(29, ComoCaixa);
		inv2.setItem(31, OpenCaixa);
		inv2.setItem(33, LojaCaixa);
		 LojaV = API.create(Material.EMERALD, "§8» §6Loja de VIPs", API.lore("§7➥ Compre VIPs no site."));
		inv2.setItem(4, LojaV);
		inv2.setItem(3, se);
		inv2.setItem(5, se);
		p.openInventory(inv2);
	}
	public static void menuC(Player p) {
		Inventory inv2 = Bukkit.createInventory(p, 45, "§7» §cLoja [KEYS PARA CAIXAS]");
		
		API.firstEmpty(inv2, Vidro);
		Carteira = API.create(Material.LEATHER, "§8» §aSua Carteira:", API.lore("§7➥ Você possui: §e" + s.getValis(p) + " Valis"));
		inv2.setItem(4, PermZ);
		inv2.setItem(3, KitsX);
		inv2.setItem(5, CaixasW);
		
		inv2.setItem(10, Carteira);
		inv2.setItem(16, LojaV);
		
		inv2.setItem(29, Caixas1x);
		inv2.setItem(31, Caixas3x);
		inv2.setItem(33, Caixas10x);
		p.openInventory(inv2);
	}
	@EventHandler
    public void inv(InventoryClickEvent e) {
    	Inventory inv = e.getInventory();
    	if (e.getWhoClicked() instanceof Player) {
    		Player p = (Player) e.getWhoClicked();
    		if (e.getCurrentItem() != null) {
    			if (inv.getTitle().equals("§7» §cLoja [KEYS PARA CAIXAS]")) {
    				if (e.getClick() == ClickType.LEFT) {
    					if (e.getCurrentItem().equals(Vidro)) {
    						menuC(p);
    						e.setCancelled(true);
    						return;
    					}
    					if (e.getCurrentItem().equals(CaixasW)) {
    						e.setCancelled(true);
    						menuC(p);
    						return;
    					}
    					if (e.getCurrentItem().equals(LojaV)) {
    						Bukkit.dispatchCommand(p, "site");
    						p.closeInventory();
    						e.setCancelled(true);
    						return;
    					}
    					if (e.getCurrentItem().equals(PermZ)) {
    						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
    							public void run() {
    								 LojaPerm.menuPerm(p);
    							}
    						}, 0L);
    						return;
    					}
    					if (e.getCurrentItem().equals(Carteira)) {
    						menuC(p);
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
    					if (e.getCurrentItem().equals(Caixas1x)) {
    						e.setCancelled(true);
    						p.closeInventory();
    						if (s.getValis(p) >= 10000) {
    							s.removeValis(p, 10000);
    							API.msg(p, API.prefix + "§aVoce comprou 1 KEY, §e- 10 mil Valis");

    							s.addKeys(p);
    						}else{
    							int conta = 10000 - s.getValis(p);
    							API.msg(p, API.prefix + "§cFaltam " + conta + " Valis §cpara poder comprar essa KEY!");
    							
    							return;
    						}
    					}
    					if (e.getCurrentItem().equals(Caixas3x)) {
    						e.setCancelled(true);
    						p.closeInventory();
    						if (s.getValis(p) >= 25000) {
    							s.removeValis(p, 25000);
    							API.msg(p, API.prefix + "§aVoce comprou 3 KEYs, §e- 25 mil Valis");

    							s.addKeys(p);
    							s.addKeys(p);
    							s.addKeys(p);
    						}else{
    							int conta = 25000 - s.getValis(p);
    							API.msg(p, API.prefix + "§cFaltam " + conta + " Valis §cpara poder comprar essa KEY!");
    							
    							return;
    						}
    					}
    					if (e.getCurrentItem().equals(Caixas10x)) {
    						e.setCancelled(true);
    						p.closeInventory();
    						if (s.getValis(p) >= 80000) {
    							s.removeValis(p, 80000);
    							API.msg(p, API.prefix + "§aVoce comprou 1 KEY, §e- 80 mil Valis");
    							s.addKeys(p);
    							s.addKeys(p);
    							s.addKeys(p);
    							s.addKeys(p);
    							s.addKeys(p);
    							s.addKeys(p);
    							s.addKeys(p);
    							s.addKeys(p);
    							s.addKeys(p);
    							s.addKeys(p);
    						}else{
    							int conta = 80000 - s.getValis(p);
    							API.msg(p, API.prefix + "§cFaltam " + conta + " Valis §cpara poder comprar essa KEY!");
    							
    							return;
    						}
    					}
    					ScoreB.setSB(p);
    				}else{
    					menuC(p);
    					e.setCancelled(true);
    				}
    			}
       			if (inv.getTitle().equals("§7» §cCaixas")) {
    				if (e.getClick() == ClickType.LEFT) {
    					if (e.getCurrentItem().equals(Vidro)) {
    						menuC2(p);
    						e.setCancelled(true);
    						return;
    					}
    					if (e.getCurrentItem().equals(LojaV)) {
    						Bukkit.dispatchCommand(p, "site");
    						p.closeInventory();
    						e.setCancelled(true);
    						return;
    					}
    					if (e.getCurrentItem().equals(LojaCaixa)) {
    						e.setCancelled(true);
    						API.som(p, Sound.CLICK, 2.0F);
    						menuC(p);
    						return;
    					}
    					if (e.getCurrentItem().equals(ComoCaixa)) {
    						e.setCancelled(true);
    						menuC2(p);
    						return;
    					}
    					if (e.getCurrentItem().equals(OpenCaixa)) {
    						e.setCancelled(true);
    						API.som(p, Sound.LEVEL_UP, 2.0F);
    						if (s.getKeys(p) >= 1) {
    							CaixaAPI.Inventario(p);
    						}else{
    							API.msg(p, API.prefix + "§cVoce nao possui Keys!");
    							p.closeInventory();
    						}
    						return;
    					}
    					if (e.getCurrentItem().equals(se)) {
    						e.setCancelled(true);
    						menuC2(p);
    						return;
    					}
    				}else{
    					menuC(p);
    					e.setCancelled(true);
    				}
    			}
    		}
    	}
    }
}