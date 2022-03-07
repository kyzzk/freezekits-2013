package Otaku.API;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_7_R3.ChatSerializer;
import net.minecraft.server.v1_7_R3.PacketPlayOutChat;

public class JsonMessage
{
  private String message;
  
  public JsonMessage(String message)
  {
    this.message = ("[\"\", {\"text\":\"" + message + "\"");
  }
  
  public void addComand(String comando)
  {
    this.message = (this.message + ",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"" + comando + "\"}");
  }
  
  public void addSugestao(String comando)
  {
    this.message = (this.message + ",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + comando + "\"}");
  }
  
  public void addURL(String link)
  {
    this.message = (this.message + ",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"" + link + "\"}");
  }
  
  public void enviarOnline()
  {
    Player[] arrayOfPlayer;
    @SuppressWarnings("deprecation")
	int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
    for (int i = 0; i < j; i++)
    {
      Player s1 = arrayOfPlayer[i];
      PacketPlayOutChat packet = new PacketPlayOutChat(ChatSerializer.a(this.message + "}]"));
      ((CraftPlayer)s1).getHandle().playerConnection.sendPacket(packet);
    }
  }
  
  public void enviar(Player p)
  {
    PacketPlayOutChat packet = new PacketPlayOutChat(ChatSerializer.a(this.message + "}]"));
    ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
  }
}
