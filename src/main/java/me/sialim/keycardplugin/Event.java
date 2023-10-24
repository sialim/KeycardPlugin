package me.sialim.keycardplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Openable;
import org.bukkit.block.data.type.Door;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import javax.swing.*;

public class Event implements Listener{
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e)
    {
        Plugin plugin = Bukkit.getPluginManager().getPlugin("KeycardPlugin");
        Player p = e.getPlayer(); Action a = e.getAction();
        if(a==Action.RIGHT_CLICK_BLOCK)
        {
            ItemStack item = p.getInventory().getItemInMainHand();
            Block block = e.getClickedBlock();
            if(item.getType()==Material.PAPER)
            {
                if(e.getClickedBlock()!=null&&e.getClickedBlock().getType()==Material.IRON_DOOR)
                {
                    ItemMeta itemM = item.getItemMeta();
                    if(itemM!=null&&itemM.hasDisplayName() && ((itemM.getDisplayName().equals(ChatColor.WHITE + "" + ChatColor.BOLD + "Ultimate Nurse Keycard"))||
                    (itemM.getDisplayName().equals(ChatColor.WHITE + "" + ChatColor.BOLD + "Ultimate Lucky Student Keycard"))))
                    {
                        if(isNurseDoor(block.getLocation()))
                        {
                            BlockData doorData = block.getBlockData();
                            ((Openable) doorData).setOpen(true);
                            block.setBlockData(doorData);
                        }
                    }
                    if(itemM!=null&&itemM.hasDisplayName() && ((itemM.getDisplayName().equals(ChatColor.WHITE + "" + ChatColor.BOLD + "Ultimate Tattoo Artist Keycard"))||
                            (itemM.getDisplayName().equals(ChatColor.WHITE + "" + ChatColor.BOLD + "Ultimate Lucky Student Keycard"))))
                    {
                        if(isTattooDoor(block.getLocation()))
                        {
                            BlockState blockState=block.getState();
                            if(blockState instanceof Door)
                            {
                                Door door = (Door) blockState.getBlockData();
                                boolean isDoorOpen=door.isOpen();
                                door.setOpen(!isDoorOpen);
                                blockState.setBlockData(door);
                                blockState.update();
                            }
                        }
                    }
                    if(itemM!=null&&itemM.hasDisplayName() && ((itemM.getDisplayName().equals(ChatColor.WHITE + "" + ChatColor.BOLD + "Ultimate Leader Keycard"))||
                            (itemM.getDisplayName().equals(ChatColor.WHITE + "" + ChatColor.BOLD + "Ultimate Lucky Student Keycard"))))
                    {
                        if(isTattooDoor(block.getLocation()))
                        {
                            BlockState blockState=block.getState();
                            if(blockState instanceof Door)
                            {
                                Door door = (Door) blockState.getBlockData();
                                boolean isDoorOpen=door.isOpen();
                                door.setOpen(!isDoorOpen);
                                blockState.setBlockData(door);
                                blockState.update();
                            }
                        }
                    }
                }
            }
        }
    }
    private boolean isNurseDoor(Location location)
    {
        if((location.getWorld().getName().equals("ZOMBIEAPOC")) &&
        (location.getBlockX()==309&&location.getBlockZ()==289&&(location.getBlockY()==-53||location.getBlockY()==-52))
        ||(location.getBlockX()==315&&location.getBlockZ()==282&&(location.getBlockY()==-53||location.getBlockY()==-52))
        ) return true;
        return false;
    }
    private boolean isTattooDoor(Location location)
    {
        if((location.getWorld().getName().equals("ZOMBIEAPOC")) &&
                (location.getBlockX()==309&&location.getBlockZ()==330&&(location.getBlockY()==-60||location.getBlockY()==-59))
                ||(location.getBlockX()==309&&location.getBlockZ()==331&&(location.getBlockY()==-60||location.getBlockY()==-59))
                ||(location.getBlockX()==309&&location.getBlockZ()==340&&(location.getBlockY()==-60||location.getBlockY()==-59))
                ||(location.getBlockX()==309&&location.getBlockZ()==341&&(location.getBlockY()==-60||location.getBlockY()==-59))
        )return true;
        return false;
    }
    private boolean isLeaderDoor(Location location)
    {
        if((location.getWorld().getName().equals("ZOMBIEAPOC")) &&
                (location.getBlockX()==316&&location.getBlockZ()==350&&(location.getBlockY()==-59||location.getBlockY()==-60))
        )return true;
        return false;
    }
}
