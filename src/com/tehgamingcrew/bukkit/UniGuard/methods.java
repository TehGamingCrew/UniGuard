package com.tehgamingcrew.bukkit.UniGuard;

import net.milkbowl.vault.permission.Permission;

import org.bukkit.plugin.RegisteredServiceProvider;



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
		
		
		//set up permissions using vault
		public boolean setupPermissions() {
			RegisteredServiceProvider<Permission> permissionProvider = plugin.getServer()
					.getServicesManager().getRegistration(
							net.milkbowl.vault.permission.Permission.class);
			if (permissionProvider != null) {
				plugin.permission = permissionProvider.getProvider();
			}
			return (plugin.permission != null);
		}
}
