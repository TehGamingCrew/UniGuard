package com.tehgamingcrew.bukkit.UniGuard;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class blockListeners implements Listener {

	public UniGuard plugin;

	public blockListeners(UniGuard pluginInstance) {
		this.plugin = pluginInstance;
	}

	@EventHandler()
	public void onBlockPlaceEvent(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		if (plugin.permission.has(player, plugin.vars.usePerm)
				|| plugin.permission.has(player, plugin.vars.adminPerm)) {
			if (!plugin.permission.has(player, plugin.vars.adminPerm)) {
				
			} else {
				// do nothing, player has full acces
			}
		} else {
			// no permission
			event.setCancelled(true);
			plugin.methods.noPermission(player);
		}
	}

	@EventHandler()
	public void onBlockBreakEvent(BlockBreakEvent event) {

	}

}
