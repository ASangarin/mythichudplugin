package eu.asangarin.mythichud.command;

import eu.asangarin.mythichud.MythicHUDPlugin;
import eu.asangarin.mythichud.constants.Permissions;
import io.lumine.mythic.bukkit.utils.commands.Command;
import org.bukkit.command.CommandSender;

import java.util.Collections;
import java.util.List;

public class ReloadCommand extends Command<MythicHUDPlugin> {
	public ReloadCommand(Command<MythicHUDPlugin> parent) {
		super(parent);
	}

	@Override
	public boolean onCommand(CommandSender sender, String[] args) {
		getPlugin().reload();

		CommandHelper.sendSuccess(sender, "MythicHUD has been reloaded!");
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, String[] args) {
		return Collections.emptyList();
	}

	@Override
	public String getPermissionNode() {
		return Permissions.PERMISSION_COMMAND_ADMIN;
	}

	@Override
	public boolean isConsoleFriendly() {
		return true;
	}

	@Override
	public String getName() {
		return "reload";
	}
}

