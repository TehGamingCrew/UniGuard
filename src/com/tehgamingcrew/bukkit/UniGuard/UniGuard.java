package com.tehgamingcrew.bukkit.UniGuard;

import java.util.logging.Logger;

import net.milkbowl.vault.permission.Permission;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

public class UniGuard extends JavaPlugin {

	// external classes
	public methods methods;
	public Vars vars;
	// Standard Necessary Vars
	public PluginManager pm;
	public PluginDescriptionFile pdFile;
	public Logger log;

	// command executors

	// listeners
	public blockListeners blocklistener;

	// vault vars
	public Permission permission;

	// worldguard
	public WorldGuardPlugin worldguard;

	@Override
	public void onEnable() {
		methods = new methods(this);
		vars = new Vars(this);

		methods.initDefVars();
		methods.setCommands();

		methods.checkDependencies();

		methods.setupPermissions();

		worldguard = methods.getWorldGuard();

		pm.registerEvents(blocklistener, this);

		// Code

		methods.sendEnabledMessage();
	}

	@Override
	public void onDisable() {
		methods.sendDisabledMessage();
	}
}
