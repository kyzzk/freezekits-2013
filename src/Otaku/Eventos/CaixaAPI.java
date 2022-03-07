package Otaku.Eventos;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import Otaku.Main;
import Otaku.API.API;
import Otaku.Files.Stats;

public class CaixaAPI implements Listener {
	
	private static Stats s = Stats.getClasse();

	@SuppressWarnings("unused")
	private static HashMap<String, Long> cooldown = new HashMap<String, Long>();

	public static void playFirework(Location location, Color color, Player p) {
		Firework firework = (Firework) location.getWorld().spawn(location, Firework.class);
		FireworkMeta fMeta = firework.getFireworkMeta();
		fMeta.addEffect(FireworkEffect.builder().withColor(color).build());
		firework.setFireworkMeta(fMeta);
		firework.setVelocity(new Vector(0.0D, -1.0D, 0.0D));
	}

	public void playFirework(Location location, FireworkEffect effecta, Player p) {
		Firework firework = (Firework) location.getWorld().spawn(location, Firework.class);
		FireworkMeta fMeta = firework.getFireworkMeta();
		fMeta.addEffect(effecta);
		firework.setFireworkMeta(fMeta);
	}
	@SuppressWarnings("deprecation")
	public static void Inventario(Player p) {
		Inventory random = Bukkit.createInventory(p, 27, "§7» §cCaixas");
		
		s.removeKey(p);

		ItemStack vidro = new ItemStack(Material.getMaterial(102));
		ItemMeta vidrometa = vidro.getItemMeta();
		vidrometa.setDisplayName("§7➥ Abrindo...");
		vidro.setItemMeta(vidrometa);

		ItemStack vidro1 = new ItemStack(Material.getMaterial(160));
		vidro1.setDurability((short) 7);
		ItemMeta vidrometa1 = vidro1.getItemMeta();
		vidrometa1.setDisplayName("§7➥ Abrindo...");
		vidro1.setItemMeta(vidrometa1);

		ItemStack vidrovermelho = new ItemStack(Material.getMaterial(160),1 ,(short)2);
		vidrovermelho.setDurability((short) 14);
		ItemMeta vidrovermelhoa = vidrovermelho.getItemMeta();
		vidrovermelhoa.setDisplayName("§7➥ Abrindo...");
		vidrovermelho.setItemMeta(vidrovermelhoa);

		ItemStack vidropreto = new ItemStack(Material.getMaterial(160),1 ,(short)4);
		vidropreto.setDurability((short) 0);
		ItemMeta vidropretoa = vidropreto.getItemMeta();
		vidropretoa.setDisplayName("§7➥ Abrindo...");
		vidropreto.setItemMeta(vidropretoa);
		
		ItemStack vidropreto2 = new ItemStack(Material.getMaterial(160),1 ,(short)15);
		vidropreto2.setDurability((short) 15);
		ItemMeta vidropretoa2 = vidropreto2.getItemMeta();
		vidropretoa2.setDisplayName("§7➥ Abrindo...");
		vidropreto2.setItemMeta(vidropretoa2);
		
	    random.setItem(0, vidropreto2);
	    random.setItem(1, vidropreto2);
	    random.setItem(2, vidropreto2);
	    random.setItem(3, vidropreto2);
	    random.setItem(4, vidropreto2);
	    random.setItem(5, vidropreto2);
	    random.setItem(6, vidropreto2);
	    random.setItem(7, vidropreto2);
	    random.setItem(8, vidropreto2);
	    random.setItem(18, vidropreto2);
	    random.setItem(19, vidropreto2);
	    random.setItem(20, vidropreto2);
	    random.setItem(21, vidropreto2);
	    random.setItem(22, vidropreto2);
	    random.setItem(23, vidropreto2);
	    random.setItem(24, vidropreto2);
	    random.setItem(25, vidropreto2);
	    random.setItem(26, vidropreto2);
	    
		  ItemStack grandpa = new ItemStack(Material.STICK);
		  ItemMeta grandpaa = grandpa.getItemMeta();
		  grandpaa.setDisplayName("§7GrandPa");
		  grandpa.setItemMeta(grandpaa);
		  ItemStack viking = new ItemStack(Material.DOUBLE_PLANT);
		  ItemMeta vikinga = viking.getItemMeta();
		  vikinga.setDisplayName("§7Viking");
		  viking.setItemMeta(vikinga);
		  
		  ItemStack money = new ItemStack(Material.DOUBLE_PLANT);
		  ItemMeta moneya = money.getItemMeta();
		  moneya.setDisplayName("§7➥ §c500 Valis");
		  money.setItemMeta(moneya);
		  ItemStack money2 = new ItemStack(Material.DOUBLE_PLANT);
		  ItemMeta money2a = money2.getItemMeta();
		  money2a.setDisplayName("§7➥ §c800 Valis");
		  money2.setItemMeta(money2a);
		  ItemStack money3 = new ItemStack(Material.DOUBLE_PLANT);
		  ItemMeta money3a = money3.getItemMeta();
		  money3a.setDisplayName("§7➥ §c1000 Valis");
		  money3.setItemMeta(money3a);
		  ItemStack money4 = new ItemStack(Material.DOUBLE_PLANT);
		  ItemMeta money4a = money4.getItemMeta();
		  money4a.setDisplayName("§7➥ §c1200 Valis");
		  money4.setItemMeta(money4a);
		  ItemStack money5 = new ItemStack(Material.DOUBLE_PLANT);
		  ItemMeta money5a = money5.getItemMeta();
		  money5a.setDisplayName("§7➥ §c4000 Valis");
		  money5.setItemMeta(money5a);
		  
		  ItemStack caixa = new ItemStack(Material.CHEST);
		  ItemMeta metacaixa = caixa.getItemMeta();
		  metacaixa.setDisplayName("§7➥ §c2 Caixas");
		  caixa.setAmount(2);
		  caixa.setItemMeta(metacaixa);
		  
		  ItemStack caixa5 = new ItemStack(Material.BREAD);
		  ItemMeta metacaixa5 = caixa5.getItemMeta();
		  metacaixa5.setDisplayName("§7➥ §c1 Pao");
		  caixa5.setItemMeta(metacaixa);
		  
		  ItemStack caixa1 = new ItemStack(Material.CHEST);
		  ItemMeta metacaixa1 = caixa1.getItemMeta();
		  metacaixa1.setDisplayName("§7➥ §cCaixa");
		  caixa1.setAmount(1);
		  caixa1.setItemMeta(metacaixa1);

		  ItemStack xp = new ItemStack(Material.POTION);
		  ItemMeta xpa = xp.getItemMeta();
		  xpa.setDisplayName("§7Mago");
		  xp.setItemMeta(xpa);
		  
		  ItemStack grappler = new ItemStack(Material.LEASH);
		  ItemMeta grapplera = grappler.getItemMeta();
		  grapplera.setDisplayName("§7Grappler");
		  grappler.setItemMeta(grapplera);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				random.setItem(9, vidrovermelho);
				p.getWorld().playSound(p.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 5L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				random.setItem(10, vidropreto);
				p.getWorld().playSound(p.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 10L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				random.setItem(11, vidrovermelho);
				p.getWorld().playSound(p.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 15L);

		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				random.setItem(12, vidropreto);
				p.getWorld().playSound(p.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 20L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				random.setItem(13, vidrovermelho);
				p.getWorld().playSound(p.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 25L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				random.setItem(14, vidropreto);
				p.getWorld().playSound(p.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 30L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				random.setItem(15, vidrovermelho);
				p.getWorld().playSound(p.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 35L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				random.setItem(16, vidropreto);
				p.getWorld().playSound(p.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 40L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				random.setItem(17, vidrovermelho);
				p.getWorld().playSound(p.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 45L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				random.setItem(9, vidro1);
				random.setItem(10, vidro1);
				random.setItem(11, vidro1);
				random.setItem(12, vidro1);
				random.setItem(13, vidro1);
				random.setItem(14, vidro1);
				random.setItem(15, vidro1);
				random.setItem(16, vidro1);
				random.setItem(17, vidro1);
				p.getWorld().playSound(p.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 50L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				random.setItem(9, vidropreto);
				p.getWorld().playSound(p.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 55L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				random.setItem(10, vidrovermelho);
				p.getWorld().playSound(p.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 65L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				random.setItem(11, vidropreto);
				p.getWorld().playSound(p.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 70L);

		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				random.setItem(12, vidrovermelho);
				p.getWorld().playSound(p.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 75L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				random.setItem(13, vidropreto);
				p.getWorld().playSound(p.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 80L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				random.setItem(14, vidrovermelho);
				p.getWorld().playSound(p.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 85L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				random.setItem(15, vidropreto);
				p.getWorld().playSound(p.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 90L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				random.setItem(16, vidrovermelho);
				p.getWorld().playSound(p.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 95L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				random.setItem(17, vidropreto);
				p.getWorld().playSound(p.getLocation(), Sound.NOTE_PLING, 10F, 10F);
			}
		}, 100L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				Random r = new Random();
				int gg = r.nextInt(12);

				if (gg == 0) {
					p.getWorld().playSound(p.getLocation(), Sound.CLICK, 10F, 10F);
					random.setItem(13, caixa5);
					API.msg(p, " ");
					API.msg(p, API.prefix + "§aVoce ganhou: §eUm Pao");
					API.msg(p, " ");
					p.getInventory().addItem(API.create(Material.BREAD, "§7➥ §6Pao"));
				}
				if (gg == 1) {
					p.getWorld().playSound(p.getLocation(), Sound.CLICK, 10F, 10F);
					random.setItem(13, xp);
					API.msg(p, " ");
					API.msg(p, API.prefix + "§aVoce ganhou: §eKit Mago");
					API.msg(p, " ");
					 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kit.Mago");
				}
				if (gg == 2) {
					p.getWorld().playSound(p.getLocation(), Sound.CLICK, 10F, 10F);
					random.setItem(13, grappler);
					API.msg(p, " ");
					API.msg(p, API.prefix + "§aVoce ganhou: §eKit Grappler");
					API.msg(p, " ");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kit.grappler");
				}
				if (gg == 3) {
					p.getWorld().playSound(p.getLocation(), Sound.CLICK, 10F, 10F);
					random.setItem(13, caixa5);
					API.msg(p, " ");
					API.msg(p, API.prefix + "§aVoce ganhou: §eUm Pao");
					API.msg(p, " ");
					p.getInventory().addItem(API.create(Material.BREAD, "§7➥ §6Pao"));
				}
				if (gg == 4) {
					p.getWorld().playSound(p.getLocation(), Sound.CLICK, 10F, 10F);
					random.setItem(13, caixa5);
					API.msg(p, " ");
					API.msg(p, API.prefix + "§aVoce ganhou: §eUm Pao");
					API.msg(p, " ");
					p.getInventory().addItem(API.create(Material.BREAD, "§7➥ §6Pao"));
				}
				if (gg == 5) {
					p.getWorld().playSound(p.getLocation(), Sound.CLICK, 10F, 10F);
					random.setItem(13, caixa5);
					API.msg(p, " ");
					API.msg(p, API.prefix + "§aVoce ganhou: §eUm Pao");
					API.msg(p, " ");
					p.getInventory().addItem(API.create(Material.BREAD, "§7➥ §6Pao"));
				}
				if (gg == 6) {
					p.getWorld().playSound(p.getLocation(), Sound.CLICK, 10F, 10F);
					random.setItem(13, caixa);
					s.addKeys(p);
					s.addKeys(p);
					API.msg(p, " ");
					API.msg(p, API.prefix + "§aVoce ganhou: §e2 Keys");
					API.msg(p, " ");
				}
				if (gg == 7) {
					p.getWorld().playSound(p.getLocation(), Sound.CLICK, 10F, 10F);
					random.setItem(13, caixa1);
					s.addKeys(p);
					API.msg(p, " ");
					API.msg(p, API.prefix + "§aVoce ganhou: §e1 Key");
					API.msg(p, " ");
				}
				if (gg == 8) {
					p.getWorld().playSound(p.getLocation(), Sound.CLICK, 10F, 10F);
					random.setItem(13, money);
					s.addValis(p, 500);
					API.msg(p, " ");
					API.msg(p, API.prefix + "§aVoce ganhou: §e500 Valis");
					API.msg(p, " ");
				}
				if (gg == 9) {
					p.getWorld().playSound(p.getLocation(), Sound.CLICK, 10F, 10F);
					random.setItem(13, money2);
					s.addValis(p, 800);
					API.msg(p, " ");
					API.msg(p, API.prefix + "§aVoce ganhou: §e800 Valis");
					API.msg(p, " ");
				}
				if (gg == 10) {
					p.getWorld().playSound(p.getLocation(), Sound.CLICK, 10F, 10F);
					random.setItem(13, money3);
					s.addValis(p, 1000);
					API.msg(p, " ");
					API.msg(p, API.prefix + "§aVoce ganhou: §e1000 Valis");
					API.msg(p, " ");
				}
				if (gg == 11) {
					p.getWorld().playSound(p.getLocation(), Sound.CLICK, 10F, 10F);
					random.setItem(13, money4);
					s.addValis(p, 1200);
					API.msg(p, " ");
					API.msg(p, API.prefix + "§aVoce ganhou: §e1200 Valis");
					API.msg(p, " ");
				}
				if (gg == 12) {
					p.getWorld().playSound(p.getLocation(), Sound.CLICK, 10F, 10F);
					random.setItem(13, money5);
					s.addValis(p, 4000);
					API.msg(p, " ");
					API.msg(p, API.prefix + "§aVoce ganhou: §e4000 Valis");
					API.msg(p, " ");
				}
				}
		}, 110L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				p.closeInventory();
				ScoreB.setSB(p);
				playFirework(p.getLocation(), Color.RED, p.getPlayer());
				playFirework(p.getLocation(), Color.LIME, p.getPlayer());
				playFirework(p.getLocation(), Color.AQUA, p.getPlayer());
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						playFirework(p.getLocation(), Color.ORANGE, p.getPlayer());
						playFirework(p.getLocation(), Color.GREEN, p.getPlayer());
						playFirework(p.getLocation(), Color.PURPLE, p.getPlayer());
					}
				}, 20L);
			}
		}, 130L);
		p.openInventory(random);
	}
	 @SuppressWarnings("deprecation")
	@EventHandler
	 /*     */   public void ASD(InventoryClickEvent e)
	 /*     */   {
	 /* 166 */     if ((e.getInventory().getTitle().equalsIgnoreCase("§7» §cCaixas")) && 
	 /* 167 */       (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
	 /*     */     {
		 e.setCancelled(true);
	 /* 187 */       if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE)
	 /*     */       {
	                   e.setCancelled(true);
	 /* 191 */         return;
	 /*     */       }
	 }
	 }
}
