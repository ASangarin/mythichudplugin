package eu.asangarin.mythichud.api.test;

import eu.asangarin.mythichud.MythicHUDPlugin;
import eu.asangarin.mythichud.instance.EntityInstance;
import eu.asangarin.mythichud.instance.TextInstance;
import eu.asangarin.mythichud.instance.TextureInstance;
import io.lumine.mythic.bukkit.utils.text.Text;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

public class TestAPIUse {
	private static final NamespacedKey tex = NamespacedKey.minecraft("textures/gui/toasts.png");

	public static void test(Player player) {
		MythicHUDPlugin.inst().getHandler().sendInstance(player, i("testtext"), new TextInstance(createText("Hello")), 150, 150);

		EntityInstance.EntityPose pose = new EntityInstance.EntityPose(100, 180.0f, 180.0f, 0.0f);
		MythicHUDPlugin.inst().getHandler().sendInstance(player, i("shiiiinnyyyy"), new EntityInstance(player, pose), 150, 150);

		/* TextureData is needed for a texture document. It contains a key which references a texture file in the assets path
		 * and the U, V, Width and Height parameters. */
		TextureInstance.TextureData data = new TextureInstance.TextureData(tex, 218, 0, 15, 20);
		data.setSize(6, 6);
		MythicHUDPlugin.inst().getHandler().sendInstance(player, i("yohane"), new TextureInstance(data), 50, 50);

		// Will replace the other "testtext" instance with a new one:
		MythicHUDPlugin.inst().getHandler().sendInstance(player, i("testtext"), new TextInstance(createText("MUDA")), 150, 100);

		// Lets add some random text...
		MythicHUDPlugin.inst().getHandler().sendInstance(player, i("byebyetext"), new TextInstance(createText("Mega Cool Text")), 150, 150);
		// Just to remove it again, cuz that's needed.
		MythicHUDPlugin.inst().getHandler().removeInstance(player, i("byebyetext"));
	}

	private static NamespacedKey i(String path) {
		return new NamespacedKey(MythicHUDPlugin.inst(), path);
	}

	private static BaseComponent[] createText(String str) {
		TextComponent text = new TextComponent(str);
		text.setColor(ChatColor.DARK_PURPLE);
		return new BaseComponent[]{text};
	}
}
