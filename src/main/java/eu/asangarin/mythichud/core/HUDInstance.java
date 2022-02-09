package eu.asangarin.mythichud.core;

import java.io.DataOutputStream;
import java.io.IOException;

public interface HUDInstance {
	int getId();
	void write(DataOutputStream out) throws IOException;
}
