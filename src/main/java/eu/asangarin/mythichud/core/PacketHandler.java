package eu.asangarin.mythichud.core;

import eu.asangarin.mythichud.MythicHUDPlugin;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class PacketHandler implements PluginMessageListener {
	@Override
	public void onPluginMessageReceived(String channel, @NotNull Player player, byte[] message) {
		// When receiving a handshake or key press, forward to their respective methods.
		//if (channel.equalsIgnoreCase(MHChannels.HANDSHAKE)) receiveGreeting(player);
	}

	/*public void receiveGreeting(Player player) {}*/

	// Simply send over the information in an add instance packet.
	public void sendInstance(Player player, NamespacedKey id, HUDInstance instance, int x, int y) {
		try {
			player.sendPluginMessage(MythicHUDPlugin.get(), MHChannels.ADD_INSTANCE, writeMainInformation(id, instance, x, y).toByteArray());
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	private ByteArrayOutputStream writeMainInformation(NamespacedKey id, HUDInstance instance, int x, int y) throws IOException {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);

		out.writeUTF(id.getNamespace());
		out.writeUTF(id.getKey());
		out.writeInt(instance.getId());
		out.writeInt(x);
		out.writeInt(y);

		instance.write(out);

		return b;
	}

	public static void writeItemStack(DataOutputStream out, ItemStack stack) {}
	private static void writeNBT(DataOutputStream out, Object nbt) {}
}
