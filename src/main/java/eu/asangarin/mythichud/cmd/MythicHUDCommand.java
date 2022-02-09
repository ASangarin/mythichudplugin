package eu.asangarin.mythichud.cmd;

import eu.asangarin.mythichud.MythicHUDPlugin;
import eu.asangarin.test.TestAPIUse;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MythicHUDCommand implements CommandExecutor, TabCompleter {
	private static final List<String> COMMANDS = Arrays.asList("reload", "info", "version", "test");

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
		if (args.length < 1) return false;

		String cmd = args[0];
		if (cmd.equals("reload")) {
			MythicHUDPlugin.get().reload();
			sender.sendMessage(ChatColor.AQUA + "[MythicFabric] " + ChatColor.GREEN + "Plugin was successfully reloaded.");
			return true;
		}
		if (cmd.equals("info") || cmd.equals("version")) {
			sender.sendMessage(
					ChatColor.AQUA + "[MythicFabric] " + ChatColor.GREEN + "Version " + MythicHUDPlugin.get().getDescription().getVersion());
			return true;
		}
		if (cmd.equals("test")) {
			if(sender instanceof Player) {
				TestAPIUse.test((Player) sender);
				sender.sendMessage(ChatColor.AQUA + "[MythicFabric] " + ChatColor.GREEN + "Test Initiated");
				return true;
			}
		}

		return false;
	}

	@Nullable
	@Override
	public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
		final List<String> completions = new ArrayList<>();
		StringUtil.copyPartialMatches(args[0], COMMANDS, completions);
		Collections.sort(completions);
		return completions;
	}
}