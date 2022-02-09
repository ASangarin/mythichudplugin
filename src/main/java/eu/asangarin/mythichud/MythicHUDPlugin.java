package eu.asangarin.mythichud;

import eu.asangarin.mythichud.cmd.MythicHUDCommand;
import eu.asangarin.mythichud.core.MHChannels;
import eu.asangarin.mythichud.core.PacketHandler;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class MythicHUDPlugin extends JavaPlugin {
	private static MythicHUDPlugin plugin;

	@Getter
	private final PacketHandler handler = new PacketHandler();

	@Override
	public void onEnable() {
		plugin = this;
		// Register all the channels needed for incoming/outgoing packets.
		Bukkit.getMessenger().registerIncomingPluginChannel(plugin, MHChannels.HANDSHAKE, handler);

		Bukkit.getMessenger().registerOutgoingPluginChannel(plugin, MHChannels.ADD_INSTANCE);
		Bukkit.getMessenger().registerOutgoingPluginChannel(plugin, MHChannels.REMOVE_INSTANCE);

		// Set up command
		MythicHUDCommand cmd = new MythicHUDCommand();
		PluginCommand command = getCommand("mythichud");
		if (command != null) {
			command.setExecutor(cmd);
			command.setTabCompleter(cmd);
		}

		saveDefaultConfig();
		reload();
	}

	@Override
	public void onDisable() {
		// Unregister the channels
		Bukkit.getMessenger().unregisterIncomingPluginChannel(plugin);
		Bukkit.getMessenger().unregisterOutgoingPluginChannel(plugin);
		plugin = null;
	}

	// mythicfabric reload
	public void reload() {
		reloadConfig();
	}

	public static MythicHUDPlugin get() {
		return plugin;
	}
}
