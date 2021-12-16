package org.zlfn;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CompassMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Random;

import static org.zlfn.PvPlugin.*;


public class EvListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e)
    {
        e.getPlayer().discoverRecipe(NamespacedKey.minecraft("trackingcompass1"));
        e.getPlayer().discoverRecipe(NamespacedKey.minecraft("trackingcompass2"));
        e.getPlayer().discoverRecipe(NamespacedKey.minecraft("trackingcompass3"));
        e.getPlayer().discoverRecipe(NamespacedKey.minecraft("trackingcompass4"));
        e.getPlayer().discoverRecipe(NamespacedKey.minecraft("trackingcompass5"));
        e.getPlayer().discoverRecipe(NamespacedKey.minecraft("trackingcompass6"));
        e.getPlayer().discoverRecipe(NamespacedKey.minecraft("trackingcompass7"));
        e.getPlayer().discoverRecipe(NamespacedKey.minecraft("trackingcompass8"));
        e.getPlayer().discoverRecipe(NamespacedKey.minecraft("trackingcompass9"));
    }
    @EventHandler
    public void onPlayerClicks(PlayerInteractEvent e)
    {

        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
            if(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(TRAKING))
            {
                CompassMeta cm = (CompassMeta) e.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                Player randomPlayer;
                ItemStack reitem = compass1;

                switch(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getEnchantLevel(TRAKING))
                    {
                        case 1: reitem = compass1; break;
                        case 2: reitem = compass2; break;
                        case 3: reitem = compass3; break;
                        case 4: reitem = compass4; break;
                        case 5: reitem = compass5; break;
                        case 6: reitem = compass6; break;
                        case 7: reitem = compass7; break;
                        case 8: reitem = compass8; break;
                        case 9: reitem = compass9; break;
                        default:break;
                    }

                    e.getPlayer().getInventory().setItemInMainHand(reitem);
                if(e.getPlayer().isSneaking()) return;


                if(e.getPlayer().getWorld().getPlayers().size()==1)
                {
                    e.getPlayer().sendTitle("찾을 대상이 없습니다!","",1,20,5);
                    return;
                }
                while(true) {
                    randomPlayer = (Player) e.getPlayer().getWorld().getPlayers().toArray()[new Random().nextInt(Bukkit.getOnlinePlayers().size())];
                    if (randomPlayer != e.getPlayer()) break;
                }
                cm.setLodestoneTracked(false);


                double distance = e.getPlayer().getLocation().distance(randomPlayer.getLocation());
                int Trackinglevel = e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getEnchantLevel(TRAKING);

                Location lodelocation;
                int[] errorc = {500,400,300,250,200,150,125,100,0};
                float error = (float)errorc[Trackinglevel]/(float)100;
                int errors = (int)(distance*error);
                int reverse1 = Math.random() < 0.5 ? -1 : 1;
                int reverse2 = Math.random() < 0.5 ? -1 : 1;

                lodelocation = new Location(randomPlayer.getWorld(), randomPlayer.getLocation().getX()+reverse1*Math.random()*errors, 0, randomPlayer.getLocation().getZ()+reverse2*Math.random()*errors);
                cm.setLodestone(lodelocation);
                e.getPlayer().getInventory().getItemInMainHand().setItemMeta(cm);

                ItemMeta meta = e.getPlayer().getInventory().getItemInMainHand().getItemMeta();
                meta.setDisplayName(reitem.getItemMeta().getDisplayName() + " (" + randomPlayer.getName() + ")");
                e.getPlayer().getInventory().getItemInMainHand().setItemMeta(meta);

                e.getPlayer().sendTitle( randomPlayer.getName() + " 추적 중","",1,20,5);
            }
    }
}
