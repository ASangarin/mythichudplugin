package eu.asangarin.mythichud.command;

import eu.asangarin.mythichud.MythicHUDPlugin;
import eu.asangarin.mythichud.constants.Permissions;
import io.lumine.mythic.bukkit.utils.commands.Command;
import io.lumine.mythic.bukkit.utils.text.Text;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.List;

public class MythicHUDCommand extends Command<MythicHUDPlugin> {
	public MythicHUDCommand(MythicHUDPlugin plugin) {
		super(plugin);

		addSubCommands(new ReloadCommand(this));
	}

	@Override
	public boolean onCommand(CommandSender sender, String[] args) {
		String[] messages = {
			Text.colorizeLegacy("<aqua>/mythichud reload <gray>- <white>Reload the plugin"),
			Text.colorizeLegacy("<aqua>/mythicmmo test <gray>- <white>Runs a pre-defined test")
		};
		CommandHelper.sendCommandMessage(sender, messages);
		return true;

	}

	@Override
	public List<String> onTabComplete(CommandSender sender, String[] args) {
		return Arrays.asList("reload", "info", "version", "test");
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
		return "mythichud";
	}
}