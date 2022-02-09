package eu.asangarin.mythichud.instance;

import eu.asangarin.mythichud.core.HUDInstance;
import lombok.RequiredArgsConstructor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.chat.ComponentSerializer;

import java.io.DataOutputStream;
import java.io.IOException;

@RequiredArgsConstructor
public class TextInstance implements HUDInstance {
	private final BaseComponent[] component;

	@Override
	public int getId() {
		return 3;
	}

	@Override
	public void write(DataOutputStream out) throws IOException {
		out.writeUTF(ComponentSerializer.toString(component));
	}
}
