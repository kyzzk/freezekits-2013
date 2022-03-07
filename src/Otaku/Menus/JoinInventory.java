package Otaku.Menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import Otaku.API.API;
import Otaku.API.KitAPI;
import Otaku.Files.Stats;

public class JoinInventory implements Listener{
	
	public static Warps warps;
	public static LojaPerm perm;
	public static Loja lojakits;
    public static Stats s = Stats.getClasse();
	
	private static ItemStack Vidro = API.create(Material.STAINED_GLASS_PANE, 15, 1, " ");
	private static ItemStack Caixa = API.create(Material.ENDER_CHEST, "§8» §aCaixas", API.lore("§7➥ Tente tirar sorte grande num", "§7➥ Sorteio onde só é cobrado uma Key."));
	private static ItemStack Loja = API.create(Material.EMERALD, "§8» §aLoja", API.lore("§7➥ Compre permissions, kits, keys com", "§7➥ Dinheiro do jogo(Valis), também podera", "§7➥ Adquirir VIPs(Apenas com dinheiro Real)"));
	private static ItemStack Help = API.create(Material.REDSTONE_COMPARATOR, "§8» §aAjuda", API.lore("§7➥ Aqui voce pode tirar algumas", "§7➥ Duvidas em relacao ao servidor."));
	private static ItemStack Carteira = API.create(Material.LEATHER, "§8» §aSua Carteira:", API.lore("§7➥ §Você possui: §e0 Valis"));
	
	private static ItemStack HelpI = API.create(Material.PAPER, "§8» §6Ajuda", API.lore("§7➥ Essas sao algumas das duvidas", "§7➥ Mais comuns no servidor."));
	private static ItemStack TagYT = API.create(Material.INK_SACK, 12, 1, "§8» §bTag YT");
	private static ItemStack Trial = API.create(Material.INK_SACK, 13, 1, "§8» §dTrial");
	private static ItemStack LojaI = API.create(Material.INK_SACK, 10, 1, "§8» §aLoja");
	
	public static void menu(Player p) {
		Inventory inv = Bukkit.createInventory(p, 54, "§7» §cMenu");
		
		API.firstEmpty(inv, Vidro);
		inv.setItem(13, Caixa);
		inv.setItem(28, Loja);
		inv.setItem(34, Help);
		Carteira = API.create(Material.LEATHER, "§8» §aSua Carteira:", API.lore("§7➥ Você possui: §e" + s.getValis(p) + " Valis"));
		inv.setItem(40, Carteira);
		p.openInventory(inv);
	}
	public static void helpMenu(Player p) {
		Inventory inv = Bukkit.createInventory(p, 36, "§7» §cAjuda");
		
		API.firstEmpty(inv, Vidro);
		inv.setItem(4, HelpI);
		inv.setItem(20, TagYT);
		inv.setItem(22, Trial);
		inv.setItem(24, LojaI);
		p.openInventory(inv);
	}
	@EventHandler
	public void itemclick(InventoryClickEvent e) {
		Inventory inv = e.getInventory();
		if (e.getWhoClicked() instanceof Player) {
			Player p = (Player) e.getWhoClicked();
			if (e.getCurrentItem() != null) {
				if (inv.getTitle().equals("§7» §cAjuda")) {
					if (e.getClick() == ClickType.LEFT) {
						if (e.getCurrentItem().equals(LojaI)) {
							p.closeInventory();
							e.setCancelled(true);
					        API.msg(p, "  ");
					        API.msg(p, "§7» §aInfo: Loja");
					        API.msg(p, "  ");
					        API.msg(p, "§7➥ Voce pode adquirir VIP com preços.");
					        API.msg(p, "§7➥ Exelentes no site use /site");
					        API.msg(p, "§7➥ E veja qual o satisfaz!");
					        API.msg(p, " ");
					        API.msg(p, "§8[TODAS AS INFORMAÇOES SOBRE A COMPRA ESTAO NO SITE]");
					        API.msg(p, "  ");
					        return;
						}
						if (e.getCurrentItem().equals(Trial)) {
							p.closeInventory();
							e.setCancelled(true);
					        API.msg(p, "  ");
					        API.msg(p, "§7» §aInfo: §cTrial");
					        API.msg(p, "  ");
					        API.msg(p, "§7➥ Voce devera responder o formulario.");
					        API.msg(p, "§7➥ Use: /trial e faça o form.");
					        API.msg(p, " ");
					        API.msg(p, "§8[NAO FALE PARA OS STAFFS VEREM SEU FORM]");
					        API.msg(p, "  ");
					        return;
						}
						if (e.getCurrentItem().equals(TagYT)) {
							p.closeInventory();
							e.setCancelled(true);
					        API.msg(p, "  ");
					        API.msg(p, "§7» §aInfo: §bTagYT");
					        API.msg(p, "  ");
					        API.msg(p, "§7➥ Ter no minimo 400 inscritos.");
					        API.msg(p, "§7➥ Gravar um video no server");
					        API.msg(p, "§7➥ Pegar no minimo 40 likes.");
					        API.msg(p, " ");
					        API.msg(p, "§8[CASO TENHA OS REQS ENTRA EM CONTATO COM UM STAFF]");
					        API.msg(p, "  ");
					        return;
						}
						if (e.getCurrentItem().equals(Vidro)) {
							e.setCancelled(true);
							helpMenu(p);
							return;
						}
						if (e.getCurrentItem().equals(HelpI)) {
							e.setCancelled(true);
							helpMenu(p);
							return;
						}
					}else{
						helpMenu(p);
						e.setCancelled(true);
					}
				}
				if (inv.getTitle().equals("§7» §cMenu")) {
					if (e.getClick() == ClickType.LEFT) {
						if (e.getCurrentItem().equals(Vidro)) {
							e.setCancelled(true);
							menu(p);
							return;
						}
						if (e.getCurrentItem().equals(Caixa)) {
							e.setCancelled(true);
							Otaku.Menus.CaixaLoja.menuC2(p);
							API.som(p, Sound.CLICK, 2.0F);
							return;
						}
						if (e.getCurrentItem().equals(Loja)) {
							e.setCancelled(true);
							Otaku.Menus.Loja.menu(p);
							API.som(p, Sound.CLICK, 2.0F);
							return;
						}
						if (e.getCurrentItem().equals(Help)) {
							e.setCancelled(true);
							helpMenu(p);
							API.som(p, Sound.CLICK, 2.0F);
							return;
						}
						if (e.getCurrentItem().equals(Carteira)) {
							e.setCancelled(true);
							menu(p);
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
	@EventHandler
	public void interact(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (KitAPI.getKit(p).equals("Spawn")) {
			if (p.getItemInHand().getType() == Material.ANVIL) {
				if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
					e.setCancelled(true);
					menu(p);
					API.som(p, Sound.LEVEL_UP, 2.0F);
					return;
				}else{
					e.setCancelled(true);
					return;
				}
			}
			if (p.getItemInHand().getType() == Material.ENDER_CHEST) {
				if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
					e.setCancelled(true);
					KitInv.menu(p);
					API.som(p, Sound.LEVEL_UP, 2.0F);
					return;
				}else{
					e.setCancelled(true);
					return;
				}
			}
			if (p.getItemInHand().getType() == Material.BOOK) {
				if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
					e.setCancelled(true);
					Warps.guiWarps(p);
					API.som(p, Sound.LEVEL_UP, 2.0F);
					return;
				}else{
					e.setCancelled(true);
					return;
				}
			}
		}
	}
}
