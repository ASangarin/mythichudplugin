package eu.asangarin.test;

import eu.asangarin.mythichud.MythicHUDPlugin;
import eu.asangarin.mythichud.instance.EntityInstance;
import eu.asangarin.mythichud.instance.TextInstance;
import eu.asangarin.mythichud.instance.TextureInstance;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

public class TestAPIUse {
	private static final NamespacedKey tex = NamespacedKey.minecraft("textures/gui/toasts.png");

	public static void test(Player player) {
		MythicHUDPlugin.get().getHandler().sendInstance(player, i("testtext"), new TextInstance(createText("Hello")), 150, 150);
		EntityInstance.EntityPose pose = new EntityInstance.EntityPose(100, 180.0f, 180.0f, 0.0f);
		MythicHUDPlugin.get().getHandler().sendInstance(player, i("shiiiinnyyyy"), new EntityInstance(player, pose), 150, 150);
		TextureInstance.TextureData data = new TextureInstance.TextureData(tex, 218, 0, 15, 20);
		MythicHUDPlugin.get().getHandler().sendInstance(player, i("yohane"), new TextureInstance(data), 50, 50);
		MythicHUDPlugin.get().getHandler().sendInstance(player, i("testtext"), new TextInstance(createText("MUDA")), 150, 100);
	}

	private static NamespacedKey i(String path) {
		return new NamespacedKey(MythicHUDPlugin.get(), path);
	}

	private static BaseComponent[] createText(String str) {
		TextComponent text = new TextComponent(str);
		text.setColor(ChatColor.DARK_PURPLE);
		return new BaseComponent[]{text};
	}
}
