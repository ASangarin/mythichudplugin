package eu.asangarin.mythichud.instance;

import eu.asangarin.mythichud.core.HUDInstance;
import lombok.RequiredArgsConstructor;
import org.bukkit.inventory.ItemStack;

import java.io.DataOutputStream;
import java.io.IOException;

@RequiredArgsConstructor
/** @deprecated This Instance isn't implemented yet. */
@Deprecated
public class ItemStackInstance implements HUDInstance {
	private final ItemStack stack;

	@Override
	public int getId() {
		return -1;//1;
	}

	@Override
	public void write(DataOutputStream out) throws IOException {
		//PacketHandler.writeItemStack(out, stack);
	}
}
