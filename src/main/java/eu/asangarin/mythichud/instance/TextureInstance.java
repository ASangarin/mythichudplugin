package eu.asangarin.mythichud.instance;

import eu.asangarin.mythichud.util.Log;
import eu.asangarin.mythichud.api.HUDInstance;
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
		data.init();
		out.writeUTF(data.texture.getKey());
		out.writeUTF(data.texture.getNamespace());
		out.writeInt(data.u);
		out.writeInt(data.v);
		out.writeInt(data.width);
		out.writeInt(data.height);

		out.writeInt(data.sizeX);
		out.writeInt(data.sizeY);
	}

	@RequiredArgsConstructor
	public static class TextureData {
		private final NamespacedKey texture;
		private final int u, v, width, height;
		private int sizeX = -1, sizeY = -1;

		private void init() {
			if (sizeX == -1) sizeX = width;
			if (sizeY == -1) sizeY = height;
		}

		public void scale(double scale) {
			if (scale <= 0) {
				Log.error("Texture scale can't be 0 or less!");
				return;
			}
			init();
			sizeX = Math.max(1, (int) (((double) sizeX) * scale));
			sizeY = Math.max(1, (int) (((double) sizeY) * scale));
		}

		public void setSize(int x, int y) {
			if (x < 1 || y < 1) {
				Log.error("Size can't be lower than 1!");
				return;
			}
			this.sizeX = x;
			this.sizeY = y;
		}

		public void resetSize() {
			sizeX = width;
			sizeY = height;
		}
	}
}
