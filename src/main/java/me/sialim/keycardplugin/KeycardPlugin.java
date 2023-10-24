package me.sialim.keycardplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class KeycardPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Event(), this);
    }
}
