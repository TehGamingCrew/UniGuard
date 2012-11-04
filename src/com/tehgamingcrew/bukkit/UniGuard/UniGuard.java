package com.tehgamingcrew.bukkit.UniGuard;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class UniGuard extends JavaPlugin {

	// external classes
	public methods methods;

	// Standard Necessary Vars
	public PluginManager pm;
	public PluginDescriptionFile pdFile;
	public Logger log;

	@Override
	public void onEnable() {
		methods = new methods(this);

		methods.initDefVars();
		methods.setCommands();


		methods.sendEnabledMessage();
	}

	@Override
	public void onDisable() {
		methods.sendDisabledMessage();
	}
}
