package eu.asangarin.mythichud.command;

import io.lumine.mythic.bukkit.utils.text.Text;
import org.bukkit.command.CommandSender;

public class CommandHelper {
	public static void sendCommandHeader(CommandSender sender) {
		sender.sendMessage(Text.colorizeLegacy(Text.center(
				"<rainbow><strikethrough><bold> ---------</bold></strikethrough></rainbow> <gold><bold>MythicHUD <rainbow><strikethrough><bold>---------</bold></strikethrough></rainbow>")));
	}

	public static void sendCommandMessage(CommandSender player, String[] args) {
		sendCommandHeader(player);
		player.sendMessage(" ");
		player.sendMessage(args);
		player.sendMessage(" ");
		sendCommandFooter(player);
	}

	public static void sendCommandFooter(CommandSender sender) {
		sender.sendMessage(Text.colorizeLegacy(Text.center("<rainbow><strikethrough><bold>------------------------------")));
	}

	public static void sendSuccess(CommandSender sender, String message) {
		sender.sendMessage(Text.colorizeLegacy("<gray>[<gold><bold>MythicMMO<gray>] <green>" + message));
	}

	public static void sendError(CommandSender sender, String message) {
		sender.sendMessage(Text.colorizeLegacy("<gray>[<gold><bold>MythicMMO<gray>] <red>" + message));
	}
}
