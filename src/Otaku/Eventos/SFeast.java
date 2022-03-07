/*    */ package Otaku.Eventos;
/*    */ 
/*    */ import org.bukkit.Bukkit;
import Otaku.Main;
import Otaku.API.API;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SFeast
/*    */ {
/*    */   public static void start()
/*    */   {
             Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable()
/*    */     {
/*    */       public void run()
/*    */       {
	/* 23 */         Bukkit.broadcastMessage(" ");
/* 23 */         Bukkit.broadcastMessage(API.prefix + "§7ATENÇAO! O Feast vai spawnar em 1 minuto.");
/* 23 */         Bukkit.broadcastMessage(" ");
/*    */       }
/*    */       
/* 27 */     }, 0L, 4860);
             
/* 19 */     Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable()
/*    */     {
/*    */       public void run()
/*    */       {
	/* 23 */         Bukkit.broadcastMessage(" ");
/* 23 */         Bukkit.broadcastMessage(API.prefix + "§7ATENÇAO! O Feast vai spawnar em 3 segundos.");
/* 23 */         Bukkit.broadcastMessage(" ");
/*    */       }
/*    */       
/* 27 */     }, 0L, 6000L);

/* 28 */     Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable()
/*    */     {
/*    */       public void run()
/*    */       {
	/* 23 */         Bukkit.broadcastMessage(" ");
/* 23 */         Bukkit.broadcastMessage(API.prefix + "§7ATENÇAO! O Feast vai spawnar em 2 segundos.");
/* 23 */         Bukkit.broadcastMessage(" ");
/*    */       }
/*    */       
/*    */ 
/* 36 */     }, 0L, 6020L);

/* 37 */     Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable()
/*    */     {
/*    */       public void run()
/*    */       {
	/* 23 */         Bukkit.broadcastMessage(" ");
/* 23 */         Bukkit.broadcastMessage(API.prefix + "§7ATENÇAO! O Feast vai spawnar em 1 segundo.");
/* 23 */         Bukkit.broadcastMessage(" ");
/*    */       }
/*    */       
/*    */ 
/* 45 */     }, 0L, 6040L);
/*    */     
/* 47 */     Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable()
/*    */     {
/*    */       public void run()
/*    */       {
	/* 23 */         Bukkit.broadcastMessage(" ");
/* 23 */         Bukkit.broadcastMessage(API.prefix + "§7ATENÇAO! O Feast spawnou.");
/* 23 */         Bukkit.broadcastMessage(" ");
/* 52 */         Ffeast.miniFeast();
/*    */       }
/*    */       
/* 55 */     }, 0L, 6060L);
             Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable()
/*    */     {
/*    */       public void run()
/*    */       {
	/* 23 */         Bukkit.broadcastMessage(" ");
/* 23 */         Bukkit.broadcastMessage(API.prefix + "§7ATENÇAO! O Feast foi removido.");
/* 23 */         Bukkit.broadcastMessage(" ");
/* 52 */         Ffeast.miniFeast1();
/*    */       }
/*    */       
/* 55 */     }, 0L, 6700L);
/*    */   }
/*    */   
/*    */   public static void start1()
/*    */   {
/* 60 */     Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable()
/*    */     {
/*    */ 
/*    */ 
/*    */       public void run() {
}
/*    */ 
/*    */ 
/* 68 */     }, 0L, 20L);
/*    */   }
}