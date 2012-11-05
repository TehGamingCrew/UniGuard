package com.tehgamingcrew.bukkit.UniGuard;

import net.milkbowl.vault.permission.Permission;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

public class methods {

	private UniGuard plugin;

	public methods(UniGuard pluginInstance) {
		plugin = pluginInstance;
	}

	// initialize the standard vars
	public void initDefVars() {
		plugin.log = plugin.getLogger();
		plugin.pm = plugin.getServer().getPluginManager();
		plugin.pdFile = plugin.getDescription();
	}

	// set up the command
	public void setCommands() {
		// set the command executors to the correct classes
		// set the executors to the commands
	}

	// log the plugin enabled message to the console
	public void sendEnabledMessage() {
		this.logMessage(plugin.pdFile.getName() + " Version "
				+ plugin.pdFile.getVersion() + " is Enabled.");
	}

	// log the plugin disabled message to the console
	public void sendDisabledMessage() {
		this.logMessage(plugin.pdFile.getName() + " Version "
				+ plugin.pdFile.getVersion() + " is Disabled.");
	}

	// log message to console
	public void logMessage(String msg) {
		plugin.log.info(msg);
	}

	// set up permissions using vault
	public boolean setupPermissions() {
		RegisteredServiceProvider<Permission> permissionProvider = plugin
				.getServer()
				.getServicesManager()
				.getRegistration(net.milkbowl.vault.permission.Permission.class);
		if (permissionProvider != null) {
			plugin.permission = permissionProvider.getProvider();
		}
		return (plugin.permission != null);
	}

	// dependencies checker
	public void checkDependencies() {
		// check WorldGuard
		if (plugin.pm.getPlugin("WorldGuard") == null) {
			logMessage("WorldGuard not installed, Disabling UniGuard!");
			plugin.pm.disablePlugin(plugin);
			return;
		}
		// check WorldEdit
		if (plugin.pm.getPlugin("WorldEdit") == null) {
			plugin.pm.disablePlugin(plugin);
			logMessage("WorldEdit not installed, Disabling UniGuard!");
			return;
		}
		// check Vault
		if (plugin.pm.getPlugin("Vault") == null) {
			plugin.pm.disablePlugin(plugin);
			logMessage("Vault not installed, Disabling UniGuard!");
			return;
		}
	}

	// load worldguard
	public WorldGuardPlugin getWorldGuard() {
		Plugin tmpplugin = plugin.getServer().getPluginManager()
				.getPlugin("WorldGuard");

		// WorldGuard may not be loaded
		if (tmpplugin == null || !(tmpplugin instanceof WorldGuardPlugin)) {
			return null;
			// won't happen because of the dependencies checker.
		}
		return (WorldGuardPlugin) tmpplugin;
	}
	
	//send no permission message
	public void noPermission(Player p){
		p.sendMessage(ChatColor.RED + "You have no permission for that!");
	}
}
