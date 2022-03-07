/*     */ package Otaku.Menus;
import java.util.ArrayList;

/*     */ 
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.ItemMeta;

import Otaku.Main;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Warps
/*     */   implements Listener
/*     */ {
/*     */   public Main plugin;
/*     */   private Main main;
/*     */   public static Enum check;
/*     */   
/*     */   public Warps()
/*     */   {
/*  30 */     this.main = this.plugin;
/*     */   }
/*     */   

public static void guiEventos(Player p)
/*     */   {
/*  35 */     Inventory inv = Bukkit.getServer().createInventory(p, InventoryType.HOPPER, "§cEVENTOS");
/*     */     
ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
/*  26 */     ItemMeta metav = vidro.getItemMeta();
/*  28 */     vidro.setItemMeta(metav);
ItemStack like = new ItemStack(Material.CAKE);
/* 132 */     ItemMeta metalike = like.getItemMeta();
/* 133 */     metalike.setDisplayName("§7RDM §6(EVENTO DOMINGO)");
/* 134 */     like.setItemMeta(metalike);
/* 135 */     inv.setItem(1, like);

              ItemStack like1 = new ItemStack(Material.WOOL);
/* 132 */     ItemMeta metalike1 = like1.getItemMeta();
/* 133 */     metalike1.setDisplayName("§7RDM §6(EVENTO SABADO)");
/* 134 */     like1.setItemMeta(metalike1);
/* 135 */     inv.setItem(3, like1);
ItemStack[] arrayOfItemStack;
int descpyro = (arrayOfItemStack = inv.getContents()).length;
for (int metapyro = 0; metapyro < descpyro; metapyro++)
{
  ItemStack item = arrayOfItemStack[metapyro];
  if (item == null) {
    inv.setItem(inv.firstEmpty(), vidro);
  }
}
p.openInventory(inv);
}


public static void guiWarps(Player p)
/*     */   {
/*  35 */     Inventory inv = Bukkit.getServer().createInventory(p, 27, "§cWARPS");
/*     */     
/*  37 */     ItemStack vidro = new ItemStack(Material.getMaterial(102));
/*  39 */     ItemMeta metav = vidro.getItemMeta();
/*  41 */     vidro.setItemMeta(metav);
ItemStack vidro2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
/*  26 */     ItemMeta metav2 = vidro2.getItemMeta();
/*  28 */     vidro2.setItemMeta(metav2);
ItemStack like = new ItemStack(Material.GLASS);
/* 132 */     ItemMeta metalike = like.getItemMeta();
/* 133 */     metalike.setDisplayName("§aFPS");
ArrayList<String> nova = new ArrayList();
nova.add("§fTreine Seu PvP sem LAG !");
metalike.setLore(nova);
/* 134 */     like.setItemMeta(metalike);
/* 135 */     inv.setItem(11, like);

ItemStack like1 = new ItemStack(Material.BLAZE_ROD);
/* 132 */     ItemMeta metalike1 = like1.getItemMeta();
/* 133 */     metalike1.setDisplayName("§a1v1");
ArrayList<String> nova1 = new ArrayList();
nova1.add("§fTreine Seu x1");
metalike1.setLore(nova1);
/* 134 */     like1.setItemMeta(metalike1);
/* 135 */     inv.setItem(12, like1);
ItemStack like11 = new ItemStack(Material.LAVA_BUCKET);
/* 132 */     ItemMeta metalike11 = like11.getItemMeta();
/* 133 */     metalike11.setDisplayName("§aLAVA CHALLENG");
ArrayList<String> nova11 = new ArrayList();
nova11.add("§fTreine Seu Refil!");
metalike11.setLore(nova11);
/* 134 */     like11.setItemMeta(metalike11);
/* 135 */     inv.setItem(13, like11);

ItemStack bow71 = new ItemStack(Material.STICK);
ItemMeta bowmeta71 = bow71.getItemMeta();
bowmeta71.setDisplayName("§aKnock");
bowmeta71.addEnchant(Enchantment.KNOCKBACK, 2, true);         
ArrayList<String> lore91 = new ArrayList();
lore91.add("§fTá Relogado? Seu Lugar é aqui.");
bowmeta71.setLore(lore91);
bow71.setItemMeta(bowmeta71);
inv.setItem(15, bow71);;

ItemStack like111 = new ItemStack(Material.WATER_BUCKET);
/* 132 */     ItemMeta metalike111 = like111.getItemMeta();
/* 133 */     metalike111.setDisplayName("§aMLG");
ArrayList<String> nova111 = new ArrayList();
nova111.add("§fTreine Seu Mlg e Ganhe Dinheiro!");
metalike111.setLore(nova111);
/* 134 */     like111.setItemMeta(metalike111);
/* 135 */     inv.setItem(14, like111);
ItemStack[] arrayOfItemStack;
int descpyro = (arrayOfItemStack = inv.getContents()).length;
for (int metapyro = 0; metapyro < descpyro; metapyro++)
{
  ItemStack item = arrayOfItemStack[metapyro];
  if (item == null) {
    inv.setItem(inv.firstEmpty(), vidro2);
  }
}
p.openInventory(inv);
}
/*     */     
@EventHandler
public void onPlayerCLickInventry(InventoryClickEvent e)
{
  Player p = (Player)e.getWhoClicked();
  if ((e.getInventory().getTitle().equalsIgnoreCase("§cWARPS")) && 
    (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
  {
    e.setCancelled(true);
    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a1v1"))
    {
      p.closeInventory();
      p.chat("/1v1");
      p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
    }
    e.setCancelled(true);
    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aFPS"))
    {
      p.closeInventory();
      p.chat("/fps");
      p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
    }
    e.setCancelled(true);
    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aKnock"))
    {
      p.closeInventory();
      p.chat("/knock");
      p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
    }
    e.setCancelled(true);
    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aLAVA CHALLENG"))
    {
      p.closeInventory();
      p.chat("/lava");
      p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
    }
    e.setCancelled(true);
    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aMLG"))
    {
      p.closeInventory();
      p.chat("/mlg");
      p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
    }
    }
}
/*     */ 
/*     */ 
/*     */ 
/*     */ @EventHandler
/*     */   public void ASD(InventoryClickEvent e)
/*     */   {
/* 165 */     Player p = (Player)e.getWhoClicked();
/* 166 */     if ((e.getInventory().getTitle().equalsIgnoreCase("§cEVENTOS")) && 
/* 167 */       (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))
/*     */     {
/* 169 */       e.setCancelled(true);
/* 187 */       if (e.getCurrentItem().getType() == Material.CAKE)
/*     */       {
/* 189 */         p.closeInventory();
/* 190 */         p.chat("/rdm");
p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
/* 191 */         return;
/*     */       }
/*     */       
                if (e.getCurrentItem().getType() == Material.WOOL)
/*     */       {
/* 189 */         p.closeInventory();
/* 190 */         p.chat("/mdr");
p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
/* 191 */         return;
/*     */       }
}
}
}


/* Location:              C:\Users\pcnote\Desktop\PublicG2.jar!\zGuis\Warps.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */