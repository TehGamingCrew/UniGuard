package com.tehgamingcrew.bukkit.UniGuard;

import java.util.logging.Logger;

import net.milkbowl.vault.permission.Permission;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class UniGuard extends JavaPlugin {

	// external classes
	public methods methods;
	public Vars vars;
	// Standard Necessary Vars
	public PluginManager pm;
	public PluginDescriptionFile pdFile;
	public Logger log;

	// vault vars
	public Permission permission;

	@Override
	public void onEnable() {
		methods = new methods(this);
		vars = new Vars(this);
		
		methods.initDefVars();
		methods.setCommands();
		
		methods.checkDependencies();
		
		methods.setupPermissions();
		
		
		
		methods.sendEnabledMessage();
	}

	@Override
	public void onDisable() {
		methods.sendDisabledMessage();
	}
}
