package eu.asangarin.mythichud.api;

public enum InstanceType {
	ENTITY, @Deprecated ITEMSTACK, @Deprecated TOOLTIP, TEXT, TEXTURE;

	public int getID() {
		return ordinal();
	}
}
