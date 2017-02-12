package com.mrsweeter.dreamreloader;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.mrsweeter.dreamreloader.Commands.Commands;

public class DreamReloader extends JavaPlugin	{
	
	Logger log = Logger.getLogger("Minecraft");
	YamlConfiguration config;
	File configFile;
	private static PluginManager pm = Bukkit.getPluginManager();

	public void onEnable() {

		// Generate/repair config
		// saveDefaultConfig();

		// Listen event on server
		// pm = getServer().getPluginManager();

		// EventListener
		getCommand("dreamReload").setExecutor(new Commands(this));

		log.info(Color.GREEN + "=============== " + Color.YELLOW + "DreamReloader enable" + Color.GREEN + " ===============" + Color.RESET);

	}

	public void onDisable() {
		
		log.info(Color.GREEN + "=============== " + Color.YELLOW + "DreamReloader disable" + Color.GREEN + " ===============" + Color.RESET);

	}

	public static PluginManager getPluginManager() {
		return pm;
	}

}
