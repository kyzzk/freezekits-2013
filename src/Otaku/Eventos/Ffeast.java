/*     */ package Otaku.Eventos;
/*     */ 
/*     */ import java.util.Random;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.block.Chest;
/*     */ import org.bukkit.configuration.ConfigurationSection;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ 
@SuppressWarnings("deprecation")
/*     */ public class Ffeast implements org.bukkit.event.Listener
/*     */ {
/*     */   public static void setSimulatorCords1(Player player)
/*     */   {
/*  19 */     ConfigurationSection list = Otaku.Main.getPlugin().getConfig().getConfigurationSection("MiniFeast");
/*  20 */     Location loc = player.getLocation();
/*  21 */     list.set("x", Integer.valueOf(loc.getBlockX()));
/*  22 */     list.set("y", Integer.valueOf(loc.getBlockY()));
/*  23 */     list.set("z", Integer.valueOf(loc.getBlockZ()));
/*  24 */     Otaku.Main.getPlugin().saveConfig(); }
/*     */   
/*     */   public static void miniFeast() { Player[] arrayOfPlayer;
/*  27 */    
int j = (arrayOfPlayer = org.bukkit.Bukkit.getServer().getOnlinePlayers()).length; for (int i = 0; i < j; i++) { Player p1 = arrayOfPlayer[i];
/*     */       
/*  29 */       ConfigurationSection list = Otaku.Main.getPlugin().getConfig().getConfigurationSection("MiniFeast");
/*  30 */       int x = ((Integer)list.get("x")).intValue();
((Integer)list.get("y")).intValue();
/*  32 */       int z = ((Integer)list.get("z")).intValue();
/*  33 */       Random r = new Random();
/*     */ 
/*  47 */       p1.getLocation().getWorld().getBlockAt(x + 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z - 1).setType(Material.CHEST);
/*  48 */       p1.getLocation().getWorld().getBlockAt(x + 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z +1).setType(Material.CHEST);
/*  49 */       p1.getLocation().getWorld().getBlockAt(x + 2, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z).setType(Material.CHEST);
/*  50 */       p1.getLocation().getWorld().getBlockAt(x - 2, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z).setType(Material.CHEST);
/*  51 */       p1.getLocation().getWorld().getBlockAt(x - 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z - 1).setType(Material.CHEST);
/*  52 */       p1.getLocation().getWorld().getBlockAt(x - 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z + 1).setType(Material.CHEST); 
p1.getLocation().getWorld().getBlockAt(x, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z + 2).setType(Material.CHEST);
p1.getLocation().getWorld().getBlockAt(x - 2, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z - 2).setType(Material.CHEST); 
p1.getLocation().getWorld().getBlockAt(x - 2, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z + 2).setType(Material.CHEST);
p1.getLocation().getWorld().getBlockAt(x + 2, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z - 2).setType(Material.CHEST); 
p1.getLocation().getWorld().getBlockAt(x + 2, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z + 2).setType(Material.CHEST);
p1.getLocation().getWorld().getBlockAt(x, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z - 2).setType(Material.CHEST);
/*     */       
/*     */ 

Chest b35 = (Chest)p1.getLocation().getWorld().getBlockAt(x + 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z - 1).getState();
/*     */       
/*     */       
/* 338 */       if (r.nextInt(100) <= 5) {
/* 339 */         b35.getBlockInventory().setItem(new Random().nextInt(b35.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_CHESTPLATE));
/*     */       }
/* 341 */       if (r.nextInt(100) <= 5) {
/* 342 */         b35.getBlockInventory().setItem(new Random().nextInt(b35.getBlockInventory().getSize()), new ItemStack(Material.GOLDEN_APPLE, 3));
/*     */       }
/* 344 */       if (r.nextInt(100) <= 5) {
/* 345 */         b35.getBlockInventory().setItem(new Random().nextInt(b35.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16424));
/*     */       }
if (r.nextInt(100) <= 5) {
/*  73 */         b35.getBlockInventory().setItem(new Random().nextInt(b35.getBlockInventory().getSize()), new ItemStack(Material.EXP_BOTTLE, 2));
/*     */       }
/*     */       
/* 348 */       if (r.nextInt(100) <= 5) {
/* 349 */         b35.getBlockInventory().setItem(new Random().nextInt(b35.getBlockInventory().getSize()), new ItemStack(Material.ARROW, 5));
/*     */       }
/*     */ 
/* 356 */       if (r.nextInt(100) <= 5) {
/* 357 */         b35.getBlockInventory().setItem(new Random().nextInt(b35.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_BOOTS));
/*     */       }

Chest f35 = (Chest)p1.getLocation().getWorld().getBlockAt(x + 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z + 1).getState();
/*     */       
/*     */       
/* 338 */       if (r.nextInt(100) <= 5) {
/* 339 */         f35.getBlockInventory().setItem(new Random().nextInt(f35.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_BOOTS));
/*     */       }
/* 341 */       if (r.nextInt(100) <= 5) {
/* 342 */         f35.getBlockInventory().setItem(new Random().nextInt(f35.getBlockInventory().getSize()), new ItemStack(Material.GOLDEN_APPLE, 3));
/*     */       }
/* 344 */       if (r.nextInt(100) <= 5) {
/* 345 */         f35.getBlockInventory().setItem(new Random().nextInt(f35.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16452));
/*     */       }
if (r.nextInt(100) <= 5) {
/*  73 */         f35.getBlockInventory().setItem(new Random().nextInt(f35.getBlockInventory().getSize()), new ItemStack(Material.MUSHROOM_SOUP, 4));
/*     */       }
/*     */       
/* 348 */       if (r.nextInt(100) <= 5) {
/* 349 */         f35.getBlockInventory().setItem(new Random().nextInt(f35.getBlockInventory().getSize()), new ItemStack(Material.ARROW, 5));
/*     */       }
/*     */ 
/* 356 */       if (r.nextInt(100) <= 5) {
/* 357 */         f35.getBlockInventory().setItem(new Random().nextInt(f35.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_BOOTS));
/*     */       }
Chest p35 = (Chest)p1.getLocation().getWorld().getBlockAt(x + 2, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z).getState();
/*     */       
/*     */       
/* 338 */       if (r.nextInt(100) <= 5) {
/* 339 */         p35.getBlockInventory().setItem(new Random().nextInt(p35.getBlockInventory().getSize()), new ItemStack(Material.CHAINMAIL_LEGGINGS));
/*     */       }
/* 341 */       if (r.nextInt(100) <= 5) {
/* 342 */         p35.getBlockInventory().setItem(new Random().nextInt(p35.getBlockInventory().getSize()), new ItemStack(Material.GOLDEN_APPLE, 3));
/*     */       }
/* 344 */       if (r.nextInt(100) <= 5) {
/* 345 */         p35.getBlockInventory().setItem(new Random().nextInt(p35.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16428));
/*     */       }
if (r.nextInt(100) <= 5) {
/*  73 */         p35.getBlockInventory().setItem(new Random().nextInt(p35.getBlockInventory().getSize()), new ItemStack(Material.EXP_BOTTLE, 5));
/*     */       }
if (r.nextInt(100) <= 5) {
/* 345 */         p35.getBlockInventory().setItem(new Random().nextInt(p35.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_CHESTPLATE));
/*     */       }
Chest m35 = (Chest)p1.getLocation().getWorld().getBlockAt(x - 2, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z).getState();
/*     */       
/*     */       
/* 338 */       if (r.nextInt(100) <= 5) {
/* 339 */         m35.getBlockInventory().setItem(new Random().nextInt(m35.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_CHESTPLATE));
/*     */       }
/* 341 */       if (r.nextInt(100) <= 5) {
/* 342 */         m35.getBlockInventory().setItem(new Random().nextInt(m35.getBlockInventory().getSize()), new ItemStack(Material.GOLDEN_APPLE, 3));
/*     */       }
/* 344 */       if (r.nextInt(100) <= 5) {
/* 345 */         m35.getBlockInventory().setItem(new Random().nextInt(m35.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16425));
/*     */       }
if (r.nextInt(100) <= 5) {
/*  73 */         m35.getBlockInventory().setItem(new Random().nextInt(m35.getBlockInventory().getSize()), new ItemStack(Material.EXP_BOTTLE));
/*     */       }
if (r.nextInt(100) <= 5) {
/*  73 */         m35.getBlockInventory().setItem(new Random().nextInt(m35.getBlockInventory().getSize()), new ItemStack(Material.BOW));
/*     */       }
/*     */       
/* 348 */       if (r.nextInt(100) <= 5) {
/* 349 */         m35.getBlockInventory().setItem(new Random().nextInt(m35.getBlockInventory().getSize()), new ItemStack(Material.ARROW, 5));
/*     */       }
/*     */ 
/* 356 */       if (r.nextInt(100) <= 5) {
/* 357 */         m35.getBlockInventory().setItem(new Random().nextInt(m35.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_BOOTS));
/*     */       }
Chest k35 = (Chest)p1.getLocation().getWorld().getBlockAt(x - 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z - 1).getState();
/*     */       
/*     */       
/* 338 */       if (r.nextInt(100) <= 5) {
/* 339 */         k35.getBlockInventory().setItem(new Random().nextInt(k35.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_CHESTPLATE));
/*     */       }
/* 341 */       if (r.nextInt(100) <= 5) {
/* 342 */         k35.getBlockInventory().setItem(new Random().nextInt(k35.getBlockInventory().getSize()), new ItemStack(Material.GOLDEN_APPLE, 3));
/*     */       }
if (r.nextInt(100) <= 5) {
/*  73 */         k35.getBlockInventory().setItem(new Random().nextInt(k35.getBlockInventory().getSize()), new ItemStack(Material.EXP_BOTTLE, 6));
/*     */       }
Chest i35 = (Chest)p1.getLocation().getWorld().getBlockAt(x - 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z - 1).getState();
/*     */       
/*     */       
/* 338 */       if (r.nextInt(100) <= 5) {
/* 339 */         i35.getBlockInventory().setItem(new Random().nextInt(i35.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_LEGGINGS));
/*     */       }
/* 341 */       if (r.nextInt(100) <= 5) {
/* 342 */         i35.getBlockInventory().setItem(new Random().nextInt(i35.getBlockInventory().getSize()), new ItemStack(Material.MUSHROOM_SOUP, 4));
/*     */       }
/* 344 */       if (r.nextInt(100) <= 5) {
/* 345 */         i35.getBlockInventory().setItem(new Random().nextInt(i35.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16419));
/*     */       }
if (r.nextInt(100) <= 5) {
/*  73 */         i35.getBlockInventory().setItem(new Random().nextInt(i35.getBlockInventory().getSize()), new ItemStack(Material.EXP_BOTTLE, 2));
/*     */       }
Chest y35 = (Chest)p1.getLocation().getWorld().getBlockAt(x - 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z + 1).getState();
/*     */       
/*     */       
/* 338 */       if (r.nextInt(100) <= 5) {
/* 339 */         y35.getBlockInventory().setItem(new Random().nextInt(y35.getBlockInventory().getSize()), new ItemStack(Material.GOLD_CHESTPLATE));
/*     */       }
/* 341 */       if (r.nextInt(100) <= 5) {
/* 342 */         y35.getBlockInventory().setItem(new Random().nextInt(y35.getBlockInventory().getSize()), new ItemStack(Material.MUSHROOM_SOUP, 4));
/*     */       }
if (r.nextInt(100) <= 5) {
/*  73 */         y35.getBlockInventory().setItem(new Random().nextInt(y35.getBlockInventory().getSize()), new ItemStack(Material.EXP_BOTTLE, 6));
/*     */       }
Chest h15 = (Chest)p1.getLocation().getWorld().getBlockAt(x, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z + 2).getState();
/*     */       
/*     */       
/* 338 */       if (r.nextInt(100) <= 5) {
/* 339 */         h15.getBlockInventory().setItem(new Random().nextInt(h15.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_LEGGINGS));
/*     */       }
/* 341 */       if (r.nextInt(100) <= 5) {
/* 342 */         h15.getBlockInventory().setItem(new Random().nextInt(h15.getBlockInventory().getSize()), new ItemStack(Material.MUSHROOM_SOUP, 4));
/*     */       }
/* 344 */       if (r.nextInt(100) <= 5) {
/* 345 */         h15.getBlockInventory().setItem(new Random().nextInt(h15.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16462));
/*     */       }
if (r.nextInt(100) <= 5) {
/*  73 */         h15.getBlockInventory().setItem(new Random().nextInt(h15.getBlockInventory().getSize()), new ItemStack(Material.EXP_BOTTLE, 5));
/*     */       }
Chest p15 = (Chest)p1.getLocation().getWorld().getBlockAt(x - 2, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z - 2).getState();
/*     */       
/*     */       
/* 338 */       if (r.nextInt(100) <= 5) {
/* 339 */         p15.getBlockInventory().setItem(new Random().nextInt(p15.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_LEGGINGS));
/*     */       }
/* 341 */       if (r.nextInt(100) <= 5) {
/* 342 */         p15.getBlockInventory().setItem(new Random().nextInt(p15.getBlockInventory().getSize()), new ItemStack(Material.MUSHROOM_SOUP, 4));
/*     */       }
if (r.nextInt(100) <= 5) {
/*  73 */         p15.getBlockInventory().setItem(new Random().nextInt(p15.getBlockInventory().getSize()), new ItemStack(Material.EXP_BOTTLE, 3));
/*     */       }
Chest o15 = (Chest)p1.getLocation().getWorld().getBlockAt(x - 2, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z + 2).getState();
/*     */       
/*     */       
/* 338 */       if (r.nextInt(100) <= 5) {
/* 339 */         o15.getBlockInventory().setItem(new Random().nextInt(o15.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_LEGGINGS));
/*     */       }
/* 341 */       if (r.nextInt(100) <= 5) {
/* 342 */         o15.getBlockInventory().setItem(new Random().nextInt(o15.getBlockInventory().getSize()), new ItemStack(Material.MUSHROOM_SOUP, 4));
/*     */       }
/* 344 */       if (r.nextInt(100) <= 5) {
/* 345 */         o15.getBlockInventory().setItem(new Random().nextInt(o15.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16462));
/*     */       }
if (r.nextInt(100) <= 5) {
/*  73 */         o15.getBlockInventory().setItem(new Random().nextInt(o15.getBlockInventory().getSize()), new ItemStack(Material.EXP_BOTTLE, 3));
/*     */       }
Chest f15 = (Chest)p1.getLocation().getWorld().getBlockAt(x - 2, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z + 2).getState();
/*     */       
/*     */       
/* 338 */       if (r.nextInt(100) <= 5) {
/* 339 */         f15.getBlockInventory().setItem(new Random().nextInt(f15.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_LEGGINGS));
/*     */       }
/* 341 */       if (r.nextInt(100) <= 5) {
/* 342 */         f15.getBlockInventory().setItem(new Random().nextInt(f15.getBlockInventory().getSize()), new ItemStack(Material.MUSHROOM_SOUP, 4));
/*     */       }
/* 344 */       if (r.nextInt(100) <= 5) {
/* 345 */         f15.getBlockInventory().setItem(new Random().nextInt(f15.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16458));
/*     */       }
if (r.nextInt(100) <= 5) {
/*  73 */         f15.getBlockInventory().setItem(new Random().nextInt(f15.getBlockInventory().getSize()), new ItemStack(Material.CHAINMAIL_BOOTS));
/*     */       }
Chest u15 = (Chest)p1.getLocation().getWorld().getBlockAt(x - 2, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z - 2).getState();
/*     */       
/*     */       
/* 338 */       if (r.nextInt(100) <= 5) {
/* 339 */         u15.getBlockInventory().setItem(new Random().nextInt(u15.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_LEGGINGS));
/*     */       }
/* 341 */       if (r.nextInt(100) <= 5) {
/* 342 */         u15.getBlockInventory().setItem(new Random().nextInt(u15.getBlockInventory().getSize()), new ItemStack(Material.MUSHROOM_SOUP, 4));
/*     */       }
if (r.nextInt(100) <= 5) {
/*  73 */         u15.getBlockInventory().setItem(new Random().nextInt(u15.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_HELMET));
/*     */       }
Chest op1 = (Chest)p1.getLocation().getWorld().getBlockAt(x + 2, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z - 2).getState();
/*     */       
/*     */       
/* 338 */       if (r.nextInt(100) <= 5) {
/* 339 */         op1.getBlockInventory().setItem(new Random().nextInt(op1.getBlockInventory().getSize()), new ItemStack(Material.IRON_HELMET));
/*     */       }
/* 341 */       if (r.nextInt(100) <= 5) {
/* 342 */         op1.getBlockInventory().setItem(new Random().nextInt(op1.getBlockInventory().getSize()), new ItemStack(Material.MUSHROOM_SOUP, 4));
/*     */       }
if (r.nextInt(100) <= 5) {
/*  73 */         op1.getBlockInventory().setItem(new Random().nextInt(op1.getBlockInventory().getSize()), new ItemStack(Material.CHAINMAIL_CHESTPLATE));
/*     */       }
Chest pj99 = (Chest)p1.getLocation().getWorld().getBlockAt(x + 2, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z + 2).getState();
/*     */       
/*     */       
/* 338 */       if (r.nextInt(100) <= 5) {
/* 339 */         pj99.getBlockInventory().setItem(new Random().nextInt(pj99.getBlockInventory().getSize()), new ItemStack(Material.CHAINMAIL_LEGGINGS));
/*     */       }
/* 341 */       if (r.nextInt(100) <= 5) {
/* 342 */         pj99.getBlockInventory().setItem(new Random().nextInt(pj99.getBlockInventory().getSize()), new ItemStack(Material.MUSHROOM_SOUP, 4));
/*     */       }
/* 344 */       if (r.nextInt(100) <= 5) {
/* 345 */         pj99.getBlockInventory().setItem(new Random().nextInt(pj99.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16450));
/*     */       }
if (r.nextInt(100) <= 5) {
/*  73 */         pj99.getBlockInventory().setItem(new Random().nextInt(pj99.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_LEGGINGS));
/*     */       }
Chest hu12 = (Chest)p1.getLocation().getWorld().getBlockAt(x, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z - 2).getState();
/*     */       
/*     */       
/* 338 */       if (r.nextInt(100) <= 5) {
/* 339 */         hu12.getBlockInventory().setItem(new Random().nextInt(hu12.getBlockInventory().getSize()), new ItemStack(Material.IRON_LEGGINGS, 1));
/*     */       }
/* 341 */       if (r.nextInt(100) <= 5) {
/* 342 */         hu12.getBlockInventory().setItem(new Random().nextInt(hu12.getBlockInventory().getSize()), new ItemStack(Material.MUSHROOM_SOUP, 4));
/*     */       }
/* 344 */       if (r.nextInt(100) <= 5) {
/* 345 */         hu12.getBlockInventory().setItem(new Random().nextInt(hu12.getBlockInventory().getSize()), new ItemStack(Material.POTION, 1, (short)16428));
/*     */       }
if (r.nextInt(100) <= 5) {
/*  73 */         hu12.getBlockInventory().setItem(new Random().nextInt(hu12.getBlockInventory().getSize()), new ItemStack(Material.LEATHER_HELMET));
/*     */       }
/*     */     }
}
public static void miniFeast1() { Player[] arrayOfPlayer;
/*  27 */     int j = (arrayOfPlayer = org.bukkit.Bukkit.getServer().getOnlinePlayers()).length; for (int i = 0; i < j; i++) { Player p1 = arrayOfPlayer[i];
/*     */       
/*  29 */       ConfigurationSection list = Otaku.Main.getPlugin().getConfig().getConfigurationSection("MiniFeast");
/*  30 */       int x = ((Integer)list.get("x")).intValue();
((Integer)list.get("y")).intValue();
/*  32 */       int z = ((Integer)list.get("z")).intValue();
new Random();
/*     */ 
/*  47 */       p1.getLocation().getWorld().getBlockAt(x + 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z - 1).setType(Material.AIR);
/*  48 */       p1.getLocation().getWorld().getBlockAt(x + 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z +1).setType(Material.AIR);
/*  49 */       p1.getLocation().getWorld().getBlockAt(x + 2, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z).setType(Material.AIR);
/*  50 */       p1.getLocation().getWorld().getBlockAt(x - 2, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z).setType(Material.AIR);
/*  51 */       p1.getLocation().getWorld().getBlockAt(x - 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z - 1).setType(Material.AIR);
/*  52 */       p1.getLocation().getWorld().getBlockAt(x - 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z + 1).setType(Material.AIR);
p1.getLocation().getWorld().getBlockAt(x, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z + 2).setType(Material.AIR);
p1.getLocation().getWorld().getBlockAt(x - 2, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z - 2).setType(Material.AIR);
p1.getLocation().getWorld().getBlockAt(x - 2, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z + 2).setType(Material.AIR);
p1.getLocation().getWorld().getBlockAt(x + 2, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z - 2).setType(Material.AIR);
p1.getLocation().getWorld().getBlockAt(x + 2, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z + 2).setType(Material.AIR);
p1.getLocation().getWorld().getBlockAt(x, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z - 2).setType(Material.AIR);
/*     */       
/*     */   }
/*     */ }
}


/* Location:              C:\Users\pcnote\Desktop\PublicG2.jar!\zManagers\Ffeast.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */