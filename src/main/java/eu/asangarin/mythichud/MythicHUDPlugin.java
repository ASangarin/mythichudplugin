package eu.asangarin.mythichud;

import eu.asangarin.mythichud.command.MythicHUDCommand;
import eu.asangarin.mythichud.config.Configuration;
import eu.asangarin.mythichud.manager.InstanceManager;
import eu.asangarin.mythichud.util.Log;
import eu.asangarin.mythichud.util.PacketHandler;
import io.lumine.mythic.bukkit.utils.plugin.LuminePlugin;
import lombok.Getter;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;

public final class MythicHUDPlugin extends LuminePlugin {
	private static MythicHUDPlugin plugin;

	@Getter
	private Configuration configuration;
	@Getter
	private PacketHandler handler;
	@Getter
	private InstanceManager instanceManager;

	@Override
	public void load() {
		plugin = this;
	}

	@Override
	public void enable() {
		this.saveDefaultConfig();

		bind(configuration = new Configuration(this));
		getConfiguration().load(this);

		handler = new PacketHandler(this);
		instanceManager = new InstanceManager();

		registerCommand("mythichud", new MythicHUDCommand(this));

		if (configuration.isMetricsEnabled()) {
			try {
				new Metrics(plugin, 15494);
				Log.info("Started up bStats Metrics");
			} catch (Exception e) {
				Log.error("Metrics: Failed to enable bStats Metrics stats.");
			}
		}
	}

	@Override
	public void disable() {
		// Unregister the channels
		Bukkit.getMessenger().unregisterIncomingPluginChannel(plugin);
		Bukkit.getMessenger().unregisterOutgoingPluginChannel(plugin);
		plugin = null;
	}

	// mythichud reload
	public void reload() {
		reloadConfiguration();
	}

	public static MythicHUDPlugin inst() {
		return plugin;
	}
}
