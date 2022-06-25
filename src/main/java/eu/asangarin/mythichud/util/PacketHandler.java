package eu.asangarin.mythichud.util;

import eu.asangarin.mythichud.MythicHUDPlugin;
import eu.asangarin.mythichud.constants.Channels;
import eu.asangarin.mythichud.api.HUDInstance;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class PacketHandler {// implements PluginMessageListener {
	public PacketHandler(MythicHUDPlugin plugin) {
		// Register all the channels needed for incoming/outgoing packets.
		//Bukkit.getMessenger().registerIncomingPluginChannel(plugin, MHChannels.HANDSHAKE, this);

		Bukkit.getMessenger().registerOutgoingPluginChannel(plugin, Channels.ADD_INSTANCE);
		Bukkit.getMessenger().registerOutgoingPluginChannel(plugin, Channels.REMOVE_INSTANCE);
	}

	/*@Override
	public void onPluginMessageReceived(String channel, @NotNull Player player, byte[] message) {
		// When receiving a handshake or key press, forward to their respective methods.
		//if (channel.equalsIgnoreCase(MHChannels.HANDSHAKE)) receiveGreeting(player);
	}*/

	/*public void receiveGreeting(Player player) {}*/

	// Simply send over the information in an add instance packet.
	public void sendInstance(Player player, NamespacedKey id, HUDInstance instance, int x, int y) {
		try {
			player.sendPluginMessage(MythicHUDPlugin.inst(), Channels.ADD_INSTANCE, writeMainInformation(id, instance, x, y).toByteArray());
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	// Remove an instance.
	public void removeInstance(Player player, NamespacedKey id) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);

		try {
			out.writeUTF(id.getNamespace());
			out.writeUTF(id.getKey());
		} catch (IOException io) {
			io.printStackTrace();
		}

		player.sendPluginMessage(MythicHUDPlugin.inst(), Channels.REMOVE_INSTANCE, b.toByteArray());
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

	/*public static void writeItemStack(DataOutputStream out, ItemStack stack) {
	}

	private static void writeNBT(DataOutputStream out, Object nbt) {
	}*/
}
