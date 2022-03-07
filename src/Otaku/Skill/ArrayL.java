/*     */ package Otaku.Skill;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
import java.util.List;

/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.inventory.meta.ItemMeta;

import Otaku.Warps.mlg;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ArrayL
/*     */   implements Listener
/*     */ {
	public static List<Player> cooldownm = new ArrayList();
/*  19 */   public static HashMap<CommandSender, CommandSender> replies = new HashMap();
/*  20 */   public static ArrayList<String> admin = new ArrayList();
/*  22 */   public static ArrayList<String> invis = new ArrayList();
public static ArrayList<Player> chat = new ArrayList<Player>();
/*  23 */   public static ArrayList<String> reload = new ArrayList();
/*  24 */   public static ArrayList<String> kits = new ArrayList();
/*  25 */   public static ArrayList<String> skeleton = new ArrayList();
public static ArrayList<String> mute = new ArrayList();
/*  26 */   public static ArrayList<String> hg = new ArrayList();
/*  27 */   public static ArrayList<String> whister = new ArrayList();
/*  28 */   public static ArrayList<String> arqueiro = new ArrayList();
/*  29 */   public static ArrayList<String> stomper = new ArrayList();
/*  30 */   public static ArrayList<String> Trocador = new ArrayList();
/*  31 */   public static ArrayList<String> viper = new ArrayList();
/*  32 */   public static ArrayList<String> cooldown = new ArrayList();
/*  33 */   public static ArrayList<String> thor = new ArrayList();
/*  34 */   public static ArrayList<String> launcher = new ArrayList();
/*  35 */   public static ArrayList<String> boxer = new ArrayList();
/*  36 */   public static ArrayList<String> turtle = new ArrayList();
public static ArrayList<String> Forcefield = new ArrayList();
public static ArrayList<String> Forcefielddano = new ArrayList();
/*  37 */   public static ArrayList<String> kitfreeze = new ArrayList();
/*  38 */   public static ArrayList<String> construiroon = new ArrayList();
/*  39 */   public static ArrayList<String> construiroff = new ArrayList();
/*  40 */   public static ArrayList<String> flash = new ArrayList();
/*  42 */   public static ArrayList<String> anchor = new ArrayList();
/*  43 */   public static ArrayList<String> bomber = new ArrayList();
/*  44 */   public static ArrayList<String> bowman = new ArrayList();
/*  45 */   public static ArrayList<String> jumper = new ArrayList();
public static ArrayList<String> rain = new ArrayList();
/*  46 */   public static ArrayList<String> enderhg = new ArrayList();
/*  47 */   public static ArrayList<String> urgal = new ArrayList();
/*  48 */   public static ArrayList<String> pyro = new ArrayList();
/*  49 */   public static ArrayList<String> monk = new ArrayList();
/*  50 */   public static ArrayList<String> Teleporter = new ArrayList();
/*  51 */   public static ArrayList<String> fisherman = new ArrayList();
/*  52 */   public static ArrayList<String> reaper = new ArrayList();
/*  53 */   public static ArrayList<String> vanished = new ArrayList();
/*  54 */   public static ArrayList<String> frosty = new ArrayList();
/*  55 */   public static ArrayList<String> pisca = new ArrayList();
/*  56 */   public static ArrayList<String> specialist = new ArrayList();
/*  57 */   public static ArrayList<String> switcher = new ArrayList();
/*  58 */   public static ArrayList<String> snail = new ArrayList();
/*  59 */   public static ArrayList<String> milkman = new ArrayList();
/*  60 */   public static ArrayList<String> flat = new ArrayList();
/*  61 */   public static ArrayList<String> kangaroo = new ArrayList();
/*  63 */   public static ArrayList<String> camel = new ArrayList();
/*  64 */   public static ArrayList<String> cooldown1 = new ArrayList();
/*  65 */   public static ArrayList<String> grappler = new ArrayList();
/*  66 */   public static ArrayList<String> poseidon = new ArrayList();
/*  67 */   public static ArrayList<String> fireman = new ArrayList();
/*  68 */   public static ArrayList<String> wither = new ArrayList();
/*  69 */   public static ArrayList<String> Checkcooldown = new ArrayList();
/*  70 */   public static ArrayList<String> tank = new ArrayList();
/*  71 */   public static ArrayList<String> endermage = new ArrayList();
/*  72 */   public static ArrayList<String> phantom = new ArrayList();
/*  73 */   public static ArrayList<String> desafio = new ArrayList();
/*  74 */   public static ArrayList<String> ninja = new ArrayList();
/*  75 */   public static ArrayList<String> darkmage = new ArrayList();
/*  76 */   public static ArrayList<String> soldado = new ArrayList();
/*  78 */   public static ArrayList<String> madman = new ArrayList();
/*  79 */   public static ArrayList<String> grandpa = new ArrayList();
/*  80 */   public static ArrayList<String> ghost = new ArrayList();
/*  81 */   public static ArrayList<String> barbarian = new ArrayList();
/*  82 */   public static ArrayList<String> spiderman = new ArrayList();
/*  83 */   public static ArrayList<String> berserker = new ArrayList();
/*  84 */   public static ArrayList<String> indio = new ArrayList();
/*  85 */   public static ArrayList<String> ryu = new ArrayList();
/*  87 */   public static ArrayList<String> lobisomem = new ArrayList();
/*  88 */   public static ArrayList<String> granadier = new ArrayList();
/*  89 */   public static ArrayList<String> rhino = new ArrayList();
/*  90 */   public static ArrayList<String> alien = new ArrayList();
/*  91 */   public static ArrayList<String> hulk = new ArrayList();
/*  93 */   public static ArrayList<String> vitality = new ArrayList();
/*  94 */   public static ArrayList<String> quickdropper = new ArrayList();
/*  95 */   public static ArrayList<String> pvp = new ArrayList();
/*  96 */   public static ArrayList<String> usandokit = new ArrayList();
/*  97 */   public static ArrayList<String> confuse = new ArrayList();
            public static ArrayList<String> gladiator = new ArrayList();
            public static ArrayList<String> viking = new ArrayList();
            public static ArrayList<String> gladgladiator = new ArrayList();
            public static ArrayList<String> Ferro2 = new ArrayList();
            public static ArrayList<String> Red2 = new ArrayList();
            public static ArrayList<String> Terra2 = new ArrayList();
            public static ArrayList<Player> Tempo = new ArrayList();
            public static ArrayList<String> critical = new ArrayList();
            public static ArrayList<String> Avatar = new ArrayList();
            public static ArrayList<String> AvatarH = new ArrayList();
            public static ArrayList<String> C4 = new ArrayList();
            public static ArrayList<String> temscore = new ArrayList();
            public static ArrayList<String> ntemscore = new ArrayList();
/*     */   
/*     */   public static void darSopas(Player p) {
/* 100 */     for (int x = 0; x < 35; x++) {
/* 101 */       ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
/* 102 */       ItemMeta sopameta = sopa.getItemMeta();
/* 103 */       sopameta.setDisplayName("§7+ + 3,5  §4�?�");
/* 104 */       sopa.setItemMeta(sopameta);
/* 105 */       p.getInventory().addItem(new ItemStack[] { new ItemStack(sopa) });
/*     */     }
/*     */   }
/*     */   
/*     */   public static void resetKit(Player p)
/*     */   {
/* 111 */     kits.remove(p.getName());
/* 112 */     hg.remove(p.getName());
/* 113 */     arqueiro.remove(p.getName());
/* 114 */     fisherman.remove(p.getName());
              Deshfire.Armadura.remove(p.getName());
              Deshfire.Cooldown.remove(p.getName());
              Deshfire.cooldownm.remove(p.getName());
              mlg.MLG.remove(p.getName());
              Sonic.Armadura.remove(p.getName());
              Sonic.Cooldown.remove(p.getName());
              Sumo.sumo.remove(p.getName());
              Sonic.cooldownm.remove(p.getName());
              critical.remove(p.getName());
              gladgladiator.remove(p.getName());
              gladiator.remove(p.getName());
              Avatar.remove(p.getName());
              Avatar.remove(p.getName());
              rain.remove(p.getName());
              Forcefield.remove(p.getName());
              Forcefielddano.remove(p.getName());
              AvatarH.remove(p.getName());
              C4.remove(p.getName());
              viking.remove(p.getName());
/* 115 */     stomper.remove(p.getName());
              anchor.remove(p.getName());
              quickdropper.remove(p.getName());
/* 116 */     reaper.remove(p.getName());
/* 117 */     kangaroo.remove(p.getName());
/* 118 */     urgal.remove(p.getName());
/* 119 */     fireman.remove(p.getName());
/* 120 */     viper.remove(p.getName());
/* 121 */     poseidon.remove(p.getName());
/* 122 */     pyro.remove(p.getName());
/* 123 */     whister.remove(p.getName());
/* 124 */     camel.remove(p.getName());
/* 125 */     endermage.remove(p.getName());
/* 126 */     darkmage.remove(p.getName());
/* 127 */     soldado.remove(p.getName());
/* 128 */     tank.remove(p.getName());
/* 129 */     desafio.remove(p.getName());
/* 130 */     anchor.remove(p.getName());
/* 131 */     ninja.remove(p.getName());
/* 132 */     grappler.remove(p.getName());
/* 133 */     Trocador.remove(p.getName());
/* 134 */     specialist.remove(p.getName());
/* 135 */     milkman.remove(p.getName());
/* 136 */     tank.remove(p.getName());
/* 137 */     thor.remove(p.getName());
/* 138 */     frosty.remove(p.getName());
/* 139 */     launcher.remove(p.getName());
/* 140 */     flash.remove(p.getName());
/* 141 */     skeleton.remove(p.getName());
/* 142 */     turtle.remove(p.getName());
/* 143 */     monk.remove(p.getName());
/* 144 */     snail.remove(p.getName());
/* 145 */     jumper.remove(p.getName());
/* 146 */     switcher.remove(p.getName());
/* 148 */     wither.remove(p.getName());
/* 149 */     phantom.remove(p.getName());
/* 150 */     reload.remove(p.getName());
/* 151 */     cooldown.remove(p.getName());
/* 152 */     cooldown1.remove(p.getName());
/* 154 */     madman.remove(p.getName());
/* 155 */     grandpa.remove(p.getName());
/* 156 */     ghost.remove(p.getName());
/* 157 */     barbarian.remove(p.getName());
/* 158 */     spiderman.remove(p.getName());
/* 159 */     berserker.remove(p.getName());
/* 160 */     Teleporter.remove(p.getName());
/* 161 */     indio.remove(p.getName());
/* 162 */     ryu.remove(p.getName());
/* 164 */     lobisomem.remove(p.getName());
/* 165 */     granadier.remove(p.getName());
/* 166 */     rhino.remove(p.getName());
/* 167 */     alien.remove(p.getName());
/* 168 */     hulk.remove(p.getName());
/* 169 */     critical.remove(p.getName());
/* 170 */     vitality.remove(p.getName());
/* 171 */     quickdropper.remove(p.getName());
/* 172 */     usandokit.remove(p.getName());
/* 173 */     pvp.remove(p.getName());
/* 174 */     boxer.remove(p.getName());
/* 175 */     confuse.remove(p.getName());
/* 176 */     Metodos.setAbility(p, "Nenhum");
/*     */   }
/*     */ }


/* Location:              C:\Users\pcnote\Desktop\PublicG2.jar!\zKits\ArrayL.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */