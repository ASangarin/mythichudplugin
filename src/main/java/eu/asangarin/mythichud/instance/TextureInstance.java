package eu.asangarin.mythichud.instance;

import eu.asangarin.mythichud.core.HUDInstance;
import lombok.RequiredArgsConstructor;
import org.bukkit.NamespacedKey;

import java.io.DataOutputStream;
import java.io.IOException;

@RequiredArgsConstructor
public class TextureInstance implements HUDInstance {
	private final TextureData data;

	@Override
	public int getId() {
		return 4;
	}

	@Override
	public void write(DataOutputStream out) throws IOException {
		out.writeUTF(data.texture.getKey());
		out.writeUTF(data.texture.getNamespace());
		out.writeInt(data.u);
		out.writeInt(data.v);
		out.writeInt(data.width);
		out.writeInt(data.height);
	}

	@RequiredArgsConstructor
	public static class TextureData {
		private final NamespacedKey texture;
		private final int u, v, width, height;
	}
}
