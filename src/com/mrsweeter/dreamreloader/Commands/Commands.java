package com.mrsweeter.dreamreloader.Commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import com.mrsweeter.dreamreloader.DreamReloader;

public class Commands implements CommandExecutor, TabCompleter {
	
	private PluginManager pm = DreamReloader.getPluginManager();
	private List<String> DreamPlugin = Arrays.asList("DreamCauldron","DreamSkull","DreamMessage");
	
	public Commands(DreamReloader main) {
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
		
		if (sender.hasPermission("dreamReloader.reloadAll"))	{
			if (commandLabel.toLowerCase().equals("dreamreload"))	{
				if (args.length == 0)	{
					
					for (Plugin jp : pm.getPlugins())	{
						if (DreamPlugin.contains(jp.getName()))	{
							pm.disablePlugin(jp);
							pm.enablePlugin(jp);
						}
					}
					return true;
					
				} else if (args.length == 1)	{
					if (args[0].equals("config"))	{
						
						for (Plugin jp : pm.getPlugins())	{
							if (DreamPlugin.contains(jp.getName()))	{
								jp.reloadConfig();
								sender.sendMessage("§c[§aDreamReloader§c] §7Reload of " + jp.getName() + "-Configuration complete");
							}
						}
						return true;
						
					} else if (DreamPlugin.contains(args[0]))	{
						if (pm.getPlugin(args[0]) == null)	{
							sender.sendMessage("§c[§aDreamReloader§c] §cPlugin " + args[0] + " is missing");
						} else	{
							if (sender instanceof Player)	{
								sender.sendMessage("§c[§aDreamReloader§c] §cPlease check §a/help " + args[0]);
							} else	{
								sender.sendMessage("§c[§aDreamReloader§c] §cPlease check §a/? " + args[0]);
							}
						}
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String commandLabel, String[] args) {
		/*
		 * List<String> arg1 = Arrays.asList("create", "launch", "remove");
		 * List<String> arg2 = Arrays.asList("board", "game"); List<String>
		 * fList = Lists.newArrayList();
		 * 
		 * if (args.length == 1) { for (String s : arg1) { if
		 * (s.startsWith(args[0])) { fList.add(s); } } return fList; }
		 * 
		 * if (args.length == 2) { for (String s : arg2) { if
		 * (s.startsWith(args[1])) { fList.add(s); } } return fList; }
		 */
		return null;
	}

}
