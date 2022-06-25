package eu.asangarin.mythichud.util;

import eu.asangarin.mythichud.MythicHUDPlugin;
import io.lumine.mythic.bukkit.utils.logging.ConsoleColor;

import java.util.logging.Level;

public final class Log {
	public static void info(String s) {
		MythicHUDPlugin.inst().getLogger().log(Level.INFO, s);
	}

	public static void info(String s, Object... params) {
		MythicHUDPlugin.inst().getLogger().log(Level.INFO, s, params);
	}

	public static void info(ConsoleColor color, String s) {
		MythicHUDPlugin.inst().getLogger().log(Level.INFO, color + s + ConsoleColor.WHITE);
	}

	public static void info(ConsoleColor color, String s, Object... params) {
		MythicHUDPlugin.inst().getLogger().log(Level.INFO, color + s + ConsoleColor.WHITE, params);
	}

	public static void warn(String s) {
		MythicHUDPlugin.inst().getLogger().log(Level.WARNING, ConsoleColor.YELLOW + s + ConsoleColor.WHITE);
	}

	public static void warn(String s, Object... params) {
		MythicHUDPlugin.inst().getLogger().log(Level.WARNING, ConsoleColor.YELLOW + s + ConsoleColor.WHITE);
	}

	public static void severe(String s) {
		MythicHUDPlugin.inst().getLogger().log(Level.SEVERE, ConsoleColor.RED + s + ConsoleColor.WHITE);
	}

	public static void severe(String s, Exception ex) {
		MythicHUDPlugin.inst().getLogger().log(Level.SEVERE, ConsoleColor.RED + s + ConsoleColor.WHITE);
		ex.printStackTrace();
	}

	public static void error(String s) {
		MythicHUDPlugin.inst().getLogger().warning(ConsoleColor.RED + s + ConsoleColor.WHITE);
	}

	public static void good(String s) {
		MythicHUDPlugin.inst().getLogger().warning(ConsoleColor.GREEN + s + ConsoleColor.WHITE);
	}

	private Log() {
		throw new UnsupportedOperationException("This class cannot be instantiated");
	}
}

