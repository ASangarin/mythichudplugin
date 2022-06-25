package eu.asangarin.mythichud.config;

import eu.asangarin.mythichud.MythicHUDPlugin;
import eu.asangarin.mythichud.util.Log;
import io.lumine.mythic.bukkit.utils.config.properties.Property;
import io.lumine.mythic.bukkit.utils.config.properties.PropertyHolder;
import io.lumine.mythic.bukkit.utils.config.properties.types.BooleanProp;
import io.lumine.mythic.bukkit.utils.plugin.ReloadableModule;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Configuration extends ReloadableModule<MythicHUDPlugin> implements PropertyHolder {
	private final static BooleanProp METRICS = Property.Boolean(Scope.CONFIG, "EnableMetrics", true);

	public Configuration(MythicHUDPlugin plugin) {
		super(plugin);
	}

	@Override
	public void load(MythicHUDPlugin plugin) {
		generateDefaultConfigFiles();
	}

	@Override
	public void unload() {
	}

	public boolean isMetricsEnabled() {
		return METRICS.get(this);
	}

	@Override
	public String getPropertyNode() {
		return "Configuration";
	}

	@SuppressWarnings("ConstantConditions")
	private void generateDefaultConfigFiles() {
		final File instanceFolder = new File(plugin.getDataFolder(), "instances");

		if (!instanceFolder.exists()) {
			Log.info("Generating default instances files...");

			if (instanceFolder.mkdir()) {
				try {
					JarFile jarFile = new JarFile(getPlugin().getJarFile());
					for (Enumeration<JarEntry> entries = jarFile.entries(); entries.hasMoreElements(); ) {
						String name = entries.nextElement().getName();
						if (name.startsWith("instances/") && name.length() > ("instances/").length()) {
							Files.copy(getPlugin().getResource(name),
									new File(getPlugin().getDataFolder() + "/instances", name.split("/")[2]).toPath());
						}
					}
					jarFile.close();
				} catch (IOException ex) {
					Log.error("Could not load default instances.");
					ex.printStackTrace();
				}
			} else Log.error("Could not create instances directory!");
		}
	}

}
